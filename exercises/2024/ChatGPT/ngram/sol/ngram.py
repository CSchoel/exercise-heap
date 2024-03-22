from typing import List, Dict
from collections import defaultdict
import random

class NgramModel:
    def __init__(self, n: int):
        self.n = n
        self.ngrams = defaultdict(list)

    def train(self, text: str):
        words = text.split()
        for i in range(len(words) - self.n):
            prefix = tuple(words[i:i + self.n - 1])
            next_word = words[i + self.n - 1]
            self.ngrams[prefix].append(next_word)

    def predict(self, prefix: str) -> List[str]:
        prefix_words = prefix.split()
        prefix = tuple(prefix_words[-self.n + 1:])
        possible_next_words = self.ngrams.get(prefix, [])
        return sorted(possible_next_words, key=lambda w: self.ngrams[prefix].count(w), reverse=True)
