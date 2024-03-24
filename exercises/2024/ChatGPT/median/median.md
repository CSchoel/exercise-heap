---
title: Calculate Median
author:
- ChatGPT
- Christopher Schölzel
keywords:
- language: python
- course: Introduction to Python for computational linguists
lang: en-US
solution-size: 5  # measured in lines of code
id: 71532c99-1982-42a1-b5b7-92c667f3ec16
---

# Calculate Median

Implement a function `calculate_median(numbers: List[float]) -> float` in `calculate_median.py` which takes a list of numbers as input and returns the median of the list.

The median is the middle value of a sorted dataset. If the dataset has an odd number of elements, the median is the middle value. If the dataset has an even number of elements, the median is the average of the two middle values.

Example:

```python
result = calculate_median([1, 2, 3, 4, 5])
print(result) # -> 3

result = calculate_median([1, 2, 3, 4, 5, 6])
print(result) # -> 3.5
```

> Tip: You can use the `sorted()` function to sort the list of numbers.

Make sure to save the function in a file called `calculate_median.py` so that it can be imported with `from calculate_median import calculate_median`.
