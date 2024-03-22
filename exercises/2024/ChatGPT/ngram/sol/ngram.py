from typing import List
from collections import defaultdict, Counter


class NgramModel:
    def __init__(self, n: int):
        self.n = n
        self.ngrams = defaultdict(Counter)

    def train(self, text: str):
        words = text.split()
        for i in range(len(words) - self.n):
            prefix = tuple(words[i : i + self.n - 1])
            next_word = words[i + self.n - 1]
            self.ngrams[prefix][next_word] += 1

    def predict(self, prefix: str) -> List[str]:
        prefix_words = prefix.split()
        prefix_tuple = tuple(prefix_words[-self.n + 1 :]) if self.n > 1 else tuple()
        possible_next_words = self.ngrams.get(prefix_tuple, Counter())
        return [x[0] for x in possible_next_words.most_common(10)]
