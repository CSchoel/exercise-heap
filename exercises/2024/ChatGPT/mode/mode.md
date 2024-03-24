---
title: Calculate Mode
author:
- ChatGPT
- Christopher Schölzel
keywords:
- language: python
- course: Introduction to Python for computational linguists
lang: en-US
solution-size: 13  # measured in lines of code
id: 74f4d0a3-90eb-4a8d-bd48-4d646553f92c
---

# Calculate Mode

Implement a function `calculate_mode(numbers: List[int]) -> List[int]` in `calculate_mode.py` which takes a list of integers as input and returns a list containing the mode(s) of the input list. If there are multiple modes, return all of them in ascending order. If there's no mode, return an empty list.

The mode of a list of numbers is the number(s) that appear most frequently.

Example:

```python
result = calculate_mode([1, 2, 3, 4, 4, 5, 5, 6])
print(result) # -> [4, 5]

result = calculate_mode([1, 2, 3, 4, 5, 6])
print(result) # -> []

result = calculate_mode([1, 2, 2, 3, 4, 5, 5, 6, 6])
print(result) # -> [2, 5, 6]
```
