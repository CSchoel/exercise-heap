---
title: Random Sampling
author:
- ChatGPT
- Christopher Schölzel
keywords:
- language: python
- course: Introduction to Python for computational linguists
lang: en-US
solution-size: 9  # measured in lines of code
id: f2f5a1c4-0ff7-4a56-bf24-9813f6f5c3d4
---

# Random Sampling

Implement a function `random_sample(data: List[str], sample_size: int) -> List[str]` in `random_sampling.py` which takes a list of strings `data` and an integer `sample_size`. This function should return a random sample of strings from the `data` list with the specified `sample_size`. 

Example:

```python
data = ["apple", "banana", "cherry", "date", "elderberry"]
sample = random_sample(data, 3)
print(sample)  # Possible output: ["banana", "date", "cherry"]
```

> Tip: You can use the `random.sample()` function from the `random` module.

Make sure to save the function in a file called `random_sampling.py` so that it can be imported with `from random_sampling import random_sample`.
