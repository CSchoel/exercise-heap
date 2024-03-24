---
title: Remove Overlapping Matches with Priority
author:
- ChatGPT
- Christopher Schölzel
keywords:
- language: python
- course: Introduction to Python for computational linguists
lang: en-US
solution-size: 16  # measured in lines of code
id: e2d488f9-6d5f-4fe1-a88e-ff90bbf5a5f1
---

# Remove Overlapping Matches with Priority

You are given a list of match positions represented as tuples `(start, end, priority)`, where `start` and `end` are integers representing the start and end positions of a match in a sequence, and `priority` is an integer representing the priority of the match. Your task is to implement a function `remove_overlapping_matches(matches: List[Tuple[int, int, int]]) -> List[Tuple[int, int, int]]` in `remove_overlapping.py` which removes overlapping matches, keeping only the match with the highest priority. If two matches have the same priority, keep the first one encountered.

Example:

```python
matches = [(0, 5, 1), (3, 7, 2), (6, 9, 3), (8, 12, 1)]
result = remove_overlapping_matches(matches)
print(result)  # -> [(0, 5, 1), (6, 9, 3)]
```

> Note: You are encouraged to implement the solution manually instead of using built-in functions like `functools.reduce` or libraries like `pandas`. 

Make sure to save the function in a file called `remove_overlapping.py` so that it can be imported with `from remove_overlapping import remove_overlapping_matches`.
