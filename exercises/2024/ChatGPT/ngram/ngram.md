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
3. `predict(self, prefix: str) -> List[str]` - Given a prefix, predict the next word based on the trained ngram model. Return a list of up to 10 possible predictions sorted by their probabilities (descending).

Example:

```python
model = NgramModel(2)
model.train("The quick brown fox jumps over the lazy dog")
predictions = model.predict("The quick")
print(predictions)  # -> ['brown', 'fox']
```

Make sure to save the class in a file called `ngram.py` so that it can be imported with `from ngram import NgramModel`.
