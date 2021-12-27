#!/bin/env python3
# Suggests which tags to add or remove for a newly added exercise
# Usage: ./suggest_tags.py path/to/exercise_description.md

from functools import reduce
import os
import sys
from typing import Any, List, Tuple, Dict, Callable
from pathlib import Path
import nltk
import math
import re
import operator as op
import yaml
import io

def indexify(text: str, lang="german") -> Dict[str, int]:
    tokens = nltk.word_tokenize(text, language=lang)
    stemmer = nltk.SnowballStemmer(lang, ignore_stopwords=True)
    stems = [stemmer.stem(x) for x in tokens]
    return count(stems)

def make_hashable(key):
    if isinstance(key, dict):
        return tuple(key.items())
    elif isinstance(key, set):
        return frozenset(key)
    elif isinstance(key, list):
        return tuple(key)
    else:
        return key

def count(lst: list) -> Dict[str, int]:
    counts = {}
    for x in lst:
        key = make_hashable(x)
        counts.setdefault(key, 0)
        counts[key] += 1
    return counts

def dict_reduce(func: Callable, dicts: List[dict], default=0, keep_default=True) -> dict:
    res = {}
    for d in dicts:
        for k in d:
            res.setdefault(k, default)
            res[k] = func(res[k], d[k])
            if res[k] == default and not keep_default:
                del res[k]
    return res

def idf(dicts: List[Dict[str, int]]) -> Dict[str, float]:
    # implements inverse document frequency
    n = len(dicts)
    keys = reduce(lambda acc, x: acc | x, [d.keys() for d in dicts], set())
    res = {}
    for k in keys:
        count = len([d for d in dicts if k in d])
        res[k] = math.log(n / count)
    return res

def index_similarity(id1: Dict[str, int], id2: Dict[str, int]) -> float:
    # implements cosine similarity (https://en.wikipedia.org/wiki/Cosine_similarity)
    num = 0
    for k in id1.keys() | id2.keys():
        num += id1.get(k, 0) * id2.get(k, 0)
    den = len(id1) * len(id2)
    return num / den

def query_index(idx: List[Tuple[str, Dict[str, int]]], query: str, k: int) -> List[str]:
    query_idx = indexify(query)
    args = list(range(len(idx)))
    args.sort(key=lambda i: index_similarity(idx[i][1], query_idx))
    results = [idx[i][0] for i in args[-k:]]
    return results

def build_index(files: List[Path]) -> List[Tuple[str, Dict[str, int]]]:
    print("Building index ...")
    indices = [indexify(x.read_text(encoding="utf-8")) for x in files]
    print("Calculating IDF ...")
    idfdict = idf(indices)
    indices = [dict_reduce(op.mul, [x, idfdict], default=1, keep_default=False) for x in indices]
    return list(zip(files, indices))

def find_similar(exdir: str, queryfile: str, num_results=5) -> List[str]:
    files = list(Path(exdir).glob("*/*/*/*.md"))
    idx = build_index(files)
    results = query_index(idx, Path(queryfile).read_text(encoding="utf-8"), num_results)
    return results

def header(fname):
    p = Path(fname)
    text = p.read_text(encoding="utf-8")
    head = re.search(r"^---$(.+?)^---$", text, flags=re.M | re.S)
    if head is None:
        raise Exception(f"{p} does not contain a YAML header")
    if head.start() != 0:
        raise Exception(f"{p} has a YAML block, which is not at the beginning of the file but at postion {header.start()}")
    head = head.group(1).strip()
    return head

def tags(fname):
    head = header(fname)
    yhead = yaml.safe_load(io.StringIO(head))
    tags = yhead["keywords"]
    return tags

def suggest_tags(tags: List[Any], other_tags: List[List[Any]], padd: int=50, prem: int=20):
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
    nb = find_similar(Path(__file__).parent.parent.parent / "exercises", sys.argv[1])
    add, rem = suggest_tags(tags(sys.argv[1]), [tags(x) for x in nb])
    print("Most similar exercises:")
    print(*nb, sep=os.linesep)
    print("Tags to add:")
    print(*add, sep=os.linesep)
    print("Tags to remove:")
    print(*rem, sep=os.linesep)
