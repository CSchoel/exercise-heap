---
title: Generate Permutations
author:
- ChatGPT
- Christopher Schölzel
keywords:
- language: python
- course: Introduction to Python for computational linguists
lang: en-US
solution-size: 13  # measured in lines of code
id: 7e2e0406-7498-4e57-a03e-b071c8cf0a0f
---

# Generate Permutations

Write a function `generate_permutations(sequence: Iterable) -> Generator[List[Any], None, None]` in `permutations.py` which generates all permutations of a given input sequence.

You should use either a generator expression or the `yield` command to create your generator.

Example:

```python
for perm in generate_permutations([1, 2, 3]):
    print(perm)
```

Output:

```
[1, 2, 3]
[1, 3, 2]
[2, 1, 3]
[2, 3, 1]
[3, 1, 2]
[3, 2, 1]
```

> Note: You may assume that the input sequence does not contain duplicates.

Make sure to save the function in a file called `permutations.py` so that it can be imported with `from permutations import generate_permutations`.
