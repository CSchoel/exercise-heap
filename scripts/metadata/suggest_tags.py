#!/bin/env python3
"""
Suggests which tags to add or remove for a newly added exercise
Usage: ./suggest_tags.py path/to/exercise_description.md
"""

from functools import reduce
import os
import sys
from typing import Any, List, Tuple, Dict, Callable, Union
import math
import re
import operator as op
from pathlib import Path
import io

import nltk
import yaml

# Type aliases
WordCount = Dict[str, int]
IndexVector = Dict[str, float]
IDF = IndexVector
Index = Dict[Path, IndexVector]

def indexify(text: str, lang="german") -> WordCount:
    """
    Transforms a piece of text into a (sparse) index vector of word frequencies.
    """
    # tokenize in two steps: 1) split by whitespace 2) strip non-word characters
    tokens = [re.sub(r"^\W*(.*?)\W*$", r"\1", x, flags=re.U) for x in text.split()]
    tokens = [x for x in tokens if len(x) > 0]
    stemmer = nltk.SnowballStemmer(lang, ignore_stopwords=True)
    # only stem words that do not have any non-word characters in them
    stems = [ stemmer.stem(x) if re.fullmatch(r"[\w-]+", x, flags=re.U) is not None else x for x in tokens]
    counts = count(stems)
    # divide by total number of terms in document to make index independent of document length
    res = dict_reduce(op.mul, [counts], default=1/sum(counts.values()))
    return res

def make_hashable(key):
    """
    Transform input to a hashable type if possible:

    * list -> tuple
    * set -> frozenset
    * dict -> tuple of items
    """
    if isinstance(key, dict):
        return tuple(key.items())
    elif isinstance(key, set):
        return frozenset(key)
    elif isinstance(key, list):
        return tuple(key)
    else:
        return key

def count(lst: list) -> Dict[Any, int]:
    """
    Counts items in a list

    Return:
        Dictionary with list items as keys and item count
        as value. Keys are made hashable with ``make_hashable()``
    """
    counts = {}
    for x in lst:
        key = make_hashable(x)
        counts.setdefault(key, 0)
        counts[key] += 1
    return counts

def dict_reduce(func: Callable, dicts: List[dict], default=0) -> dict:
    """
    Performs a reduce operation across a number of dictionaries,
    e.g. to sum up multiple word counts.
    """
    res = {}
    for d in dicts:
        for k in d:
            res.setdefault(k, default)
            res[k] = func(res[k], d[k])
    return res

def dict_filter(func: Callable, dict: Dict):
    """
    Filters out only those items of a dict that match the given predicate.
    """
    return { k: v for k,v in dict.items() if func(k, v) }

def idf(dicts: List[WordCount]) -> IDF:
    """
    Implements inverse document frequency
    """
    n = len(dicts)
    keys = reduce(lambda acc, x: acc | x, [d.keys() for d in dicts], set())
    res = {}
    for k in keys:
        occurences = len([d for d in dicts if k in d])
        # avoid idf = 0 by using n + 1 instead of n
        # rationale: even terms that appear in each document
        # may help in a search if their frequency varies greatly
        res[k] = math.log((n + 1) / occurences)
    return res

def apply_idf(vector: WordCount, idfs: IDF) -> IndexVector:
    """
    Applies precalculated idf values obtained by ``idf()`` to word count vector.
    """
    return dict_reduce(op.mul, [vector, dict_filter(lambda k,_ : k in vector, idfs)], default=1)

def index_similarity(id1: IndexVector, id2: IndexVector) -> float:
    """
    Implements cosine similarity (https://en.wikipedia.org/wiki/Cosine_similarity)
    """
    num = 0
    for k in id1.keys() | id2.keys():
        num += id1.get(k, 0) * id2.get(k, 0)
    den = sum([x**2 for x in id1.values()]) * sum([x**2 for x in id2.values()])
    return num / den

def explain_similarity(id1: IndexVector, id2: IndexVector, ntokens: int=10):
    """
    Returns the ``ntokens`` words that contributed most to the similarity
    value between ``id1`` and ``id2``.
    """
    similarity_terms = { k: id1[k] * id2[k] for k in id1.keys() & id2.keys() }
    res = list(similarity_terms.items())
    res.sort(key=lambda x: -x[1])
    return res[:ntokens]

def query_index(idx: Index, idfs: IDF, query: str, k: int) -> List[Path]:
    """
    Finds the ``k`` documents in the index ``idx`` which are most similar to the ``query``.
    """
    query_idx = indexify(query)
    query_idx = apply_idf(query_idx, idfs)
    args = list(idx.keys())
    args.sort(key=lambda i: index_similarity(idx[i], query_idx))
    results = args[-k:]
    return results

def build_index(files: List[Path]) -> Tuple[Index, IDF]:
    """
    Creates a searchable index from a list of document paths.
    """
    print("Building index ...")
    indices = [indexify(x.read_text(encoding="utf-8")) for x in files]
    print("Calculating IDF ...")
    idfdict = idf(indices)
    indices = [apply_idf(x, idfdict) for x in indices]
    return dict(zip(files, indices)), idfdict

def find_similar(exdir: Union[str, Path], queryfile: Path, num_results: int=5, explain: bool=False) -> List[Path]:
    """
    Finds the ``num_result`` documents in the directory ``exdir`` which are most similar to
    the document ``queryfile``.
    """
    files = list(Path(exdir).glob("*/*/*/*.md"))
    idx, idfs = build_index(files)
    query = queryfile.read_text(encoding="utf-8")
    results = query_index(idx, idfs, query, num_results)
    if explain:
        queryvec = apply_idf(indexify(query), idfs)
        for r in results:
            print(f"Most important terms for determining similarity beween {queryfile} and {r}:")
            print(*explain_similarity(idx[r], queryvec), sep=os.linesep)
    return results

def header(fname):
    p = Path(fname)
    """
    Extracts the YAML header of a markdown document as string.
    """
    text = p.read_text(encoding="utf-8")
    head = re.search(r"^---$(.+?)^---$", text, flags=re.M | re.S)
    if head is None:
        raise Exception(f"{p} does not contain a YAML header")
    if head.start() != 0:
        raise Exception(f"{p} has a YAML block, which is not at the beginning of the file but at postion {header.start()}")
    head = head.group(1).strip()
    return head

def tags(fname):
    """
    Reads the ``keywords`` from a markdown document's YAML header.
    """
    head = header(fname)
    yhead = yaml.safe_load(io.StringIO(head))
    tags = yhead["keywords"]
    return tags

def suggest_tags(tags: List[Any], other_tags: List[List[Any]], padd: int=50, prem: int=20):
    """
    Suggests tags based on current tags ``cur_tags`` and tags of similar documents
    stored in ``other_tags``:

    * If a tag occurs in at least ``padd`` percent of the other documents, it is
      suggested as a tag to add.
    * If a tag does not occur in more than ``prem`` percent of the other documents,
      it is suggested as a tag to remove.
    """
    tagcount = count(sum(other_tags, start=[]))
    hashable_tags = [make_hashable(x) for x in tags]
    cadd = len(other_tags) * padd / 100
    crem = len(other_tags) * prem / 100
    to_add = [x for x in tagcount.keys() if tagcount.get(x, 0) >= cadd and x not in hashable_tags]
    to_remove = [x for x in hashable_tags if tagcount.get(x, 0) <= crem]
    return to_add, to_remove

if __name__ == '__main__':
    nltk.download("punkt")
    nltk.download("stopwords")
    nb = find_similar(Path(__file__).parent.parent.parent / "exercises", sys.argv[1], explain=True)
    add, rem = suggest_tags(tags(sys.argv[1]), [tags(x) for x in nb])
    print("Most similar exercises:")
    print(*nb, sep=os.linesep)
    print("Tags to add:")
    print(*add, sep=os.linesep)
    print("Tags to remove:")
    print(*rem, sep=os.linesep)
