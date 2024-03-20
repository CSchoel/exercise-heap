<exercise>
<description>
---
title: Ngram Model
author:
- ChatGPT
- Christopher Schölzel
keywords:
- language: python
- course: Introduction to Python for computational linguists
lang: en-US
solution-size: 20  # measured in lines of code
id: 2d9898f0-5e25-40c2-8d7c-f842c01166e1
---

# Ngram Model

Create a class `NgramModel` in `ngram.py` that can generate an ngram model and make predictions based on it. The class should have the following methods:

1. `__init__(self, n: int)` - Initialize the ngram model with the value of `n`, the order of the ngrams.
2. `train(self, text: str)` - Train the model using the provided text. This method should build the ngram model.
3. `predict(self, prefix: str) -> List[str]` - Given a prefix, predict the next word based on the trained ngram model. Return a list of possible predictions sorted by their probabilities.

Example:

```python
model = NgramModel(2)
model.train("The quick brown fox jumps over the lazy dog")
predictions = model.predict("The quick")
print(predictions)  # -> ['brown', 'fox']
```

Make sure to save the class in a file called `ngram.py` so that it can be imported with `from ngram import NgramModel`.

</description>
<unittest>

```python
import unittest

from ngram import NgramModel

class TestNgramModel(unittest.TestCase):

    def test_ngram_2(self):
        model = NgramModel(2)
        model.train("The quick brown fox jumps over the lazy dog")
        predictions = model.predict("The quick")
        self.assertCountEqual(["brown", "fox"], predictions)

    def test_ngram_3(self):
        model = NgramModel(3)
        model.train("The quick brown fox jumps over the lazy dog")
        predictions = model.predict("quick brown")
        self.assertCountEqual(["fox"], predictions)

    def test_ngram_4(self):
        model = NgramModel(3)
        model.train("The quick brown fox jumps over the lazy dog")
        predictions = model.predict("jumps over")
        self.assertCountEqual(["the"], predictions)

if __name__ == '__main__':
    unittest.main()
```

</unittest>
<example_solution>

```python
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

```
</example_solution>
</exercise>