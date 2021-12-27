#!/bin/env python3
# Suggests which tags to add or remove for a newly added exercise
# Usage: ./suggest_tags.py path/to/exercise_description.md

from functools import reduce
from typing_extensions import TypedDict, List, Tuple
import nltk
import math

def indexify(text: str, lang="german") -> TypedDict[str, int]:
    tokens = nltk.word_tokenize(language=lang)
    stemmer = nltk.SnowballStemmer(lang, ignore_stopwords=True)
    stems = [stemmer.stem(x) for x in tokens]
    return count(stems)

def count(lst: list) -> TypedDict[str, int]:
    counts = {}
    for x in lst:
        counts.setdefault(x, 0)
        counts[x] += 1
    return x

def dict_reduce(func: function, dicts: List[dict], default=0, keep_default=True) -> dict:
    res = {}
    for d in dicts:
        for k in d:
            res.setdefault(k, default)
            res[k] = func(res[k], d[k])
            if res[k] == default and not keep_default:
                del res[k]
    return res

def idf(dicts: List[TypedDict[str, int]]) -> TypedDict[str, float]:
    # implements inverse document frequency
    n = len(dicts)
    keys = reduce(lambda acc, x: acc | x, [d.keys() for d in dicts])
    res = {}
    for k in keys:
        count = len([d for d in dicts if k in d])
        res[k] = math.log(n / count)

def index_similarity(id1: TypedDict[str, int], id2: TypedDict[str, int]) -> float:
    # implements cosine similarity (https://en.wikipedia.org/wiki/Cosine_similarity)
    num = 0
    for k in id1.keys() + id2.keys():
        num += id1.get(k, 0) * id2.get(k, 0)
    den = len(id1) * len(id2)
    return num / den

def query_index(idx: List[Tuple(str, TypedDict[str, int])], query: str, k: int) -> List[str]:
    query_idx = indexify(query)
    args = range(len(idx))
    args.sort(key=lambda i: index_similarity(idx[i][1], query_idx))
    results = [idx[i][0] for i in args[:k]]
    return results