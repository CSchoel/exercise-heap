---
title: Factorial Calculation
author:
- ChatGPT
- Christopher Schölzel
keywords:
- language: python
- course: Introduction to Python for computational linguists
lang: en-US
solution-size: 6  # measured in lines of code
id: 6b7bfb5f-4b6a-422d-a25e-dfdb5b50a73b
---

# Factorial Calculation

Write a function `factorial(n: int) -> int` in `factorial.py` which computes the factorial of a given non-negative integer `n`.

The factorial of a non-negative integer `n`, denoted by `n!`, is the product of all positive integers less than or equal to `n`. For example:
- `5! = 5 * 4 * 3 * 2 * 1 = 120`
- `0! = 1` (by definition)

Your function should return `-1` if `n` is negative.

Example:

```python
result = factorial(5)
print(result) # -> 120

result = factorial(0)
print(result) # -> 1

result = factorial(-5)
print(result) # -> -1
```
