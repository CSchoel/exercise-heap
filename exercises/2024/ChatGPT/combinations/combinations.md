---
title: Combinations
author:
- ChatGPT
- Christopher Schölzel
keywords:
- language: python
- course: Introduction to Python for computational linguists
lang: en-US
solution-size: 5  # measured in lines of code
id: 1e8108ae-f94f-4bb4-af8a-45e69aa471f7
---

# Combinations

Implement a function `calculate_combinations(n: int, k: int) -> int` in `combinations.py` which calculates the number of combinations given `n` and `k`. The number of combinations, denoted as "n choose k," is defined as:

\[ \text{C}(n, k) = \frac{n!}{k! \cdot (n - k)!} \]

Example:

```python
result = calculate_combinations(5, 2)
print(result) # -> 10

result = calculate_combinations(10, 3)
print(result) # -> 120
```

> Note: The factorial function (`n!`) can be implemented recursively or iteratively.

Make sure to save the function in a file called `combinations.py` so that it can be imported with `from combinations import calculate_combinations`.
