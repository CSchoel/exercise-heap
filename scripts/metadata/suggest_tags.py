#!/bin/env python3
# Suggests which tags to add or remove for a newly added exercise
# Usage: ./suggest_tags.py path/to/exercise_description.md

from functools import reduce
import sys
from typing import List, Tuple, Dict, Callable
from pathlib import Path
import nltk
import math

def indexify(text: str, lang="german") -> Dict[str, int]:
    tokens = nltk.word_tokenize(text, language=lang)
    stemmer = nltk.SnowballStemmer(lang, ignore_stopwords=True)
    stems = [stemmer.stem(x) for x in tokens]
    return count(stems)

def count(lst: list) -> Dict[str, int]:
    counts = {}
    for x in lst:
        counts.setdefault(x, 0)
        counts[x] += 1
    return x

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

def index_similarity(id1: Dict[str, int], id2: Dict[str, int]) -> float:
    # implements cosine similarity (https://en.wikipedia.org/wiki/Cosine_similarity)
    num = 0
    for k in id1.keys() + id2.keys():
        num += id1.get(k, 0) * id2.get(k, 0)
    den = len(id1) * len(id2)
    return num / den

def query_index(idx: List[Tuple[str, Dict[str, int]]], query: str, k: int) -> List[str]:
    query_idx = indexify(query)
    args = list(range(len(idx)))
    args.sort(key=lambda i: index_similarity(idx[i][1], query_idx))
    results = [idx[i][0] for i in args[:k]]
    return results

def build_index(files: List[Path]) -> List[Tuple[str, Dict[str, int]]]:
    print("Building index ...")
    indices = [indexify(x.read_text(encoding="utf-8")) for x in files]
    print("Calculating IDF ...")
    idfdict = idf(indices)
    indices = [dict_reduce(float.__add__, [x, idfdict], default=1, keep_default=False) for x in indices]
    return list(zip(files, indices))

def suggest(exdir: str, queryfile: str, num_results=5) -> List[str]:
    files = Path(exdir).glob("*/*/*/*.md")
    idx = build_index(files)
    results = query_index(idx, Path(queryfile).read_text(encoding="utf-8"), num_results)
    return results

if __name__ == '__main__':
    nltk.download("punkt")
    nltk.download("stopwords")
    res = suggest(Path(__file__).parent.parent.parent / "exercises", sys.argv[1])
    print(res)
