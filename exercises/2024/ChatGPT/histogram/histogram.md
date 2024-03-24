---
title: Calculate Histogram
author:
- ChatGPT
- Christopher Schölzel
keywords:
- language: python
- course: Introduction to Python for computational linguists
lang: en-US
solution-size: 6  # measured in lines of code
id: 891d8aa7-8573-40b5-bf80-4785eb93a12b
---

# Calculate Histogram

Implement a function `calculate_histogram(data: List[float], bucket_size: float) -> Tuple[List[float], List[int]]` in `histogram.py` which calculates a histogram from a dataset with an arbitrary bucket size. The function should return a tuple containing two lists: the lower limits of each bucket, and the counts of how many elements fall in the buckets.

> Note: Ensure that the bucket limits are always multiples of the bucket size.

Example:

```python
result = calculate_histogram([1.2, 3.4, 5.6, 7.8, 9.0, 11.1, 13.3], 3)
print(result) # -> ([0, 3, 6, 9, 12], [1, 2, 1, 2, 1])
```

Make sure to save the function in a file called `histogram.py` so that it can be imported with `from histogram import calculate_histogram`.
