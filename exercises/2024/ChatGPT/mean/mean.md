---
title: Calculate Mean
author:
- ChatGPT
- Christopher Schölzel
keywords:
- language: python
- course: Introduction to Python for computational linguists
lang: en-US
solution-size: 3  # measured in lines of code
id: 5111a717-e313-49b5-b95f-8bec5a07e30f
---

# Calculate Mean

Implement a function `calculate_mean(numbers: List[float]) -> float` in `calculate_mean.py` which calculates the mean of a list of numbers.

Example:

```python
result = calculate_mean([1, 2, 3, 4, 5])
print(result)  # -> 3.0

result = calculate_mean([0])
print(result)  # -> 0.0

result = calculate_mean([])
print(result)  # -> math.nan
```

> Tip: Use the `sum()` function and the length of the list to calculate the mean.

Make sure to save the function in a file called `calculate_mean.py` so that it can be imported with `from calculate_mean import calculate_mean`.
