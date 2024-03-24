---
title: Histogram with Bucket Size
author:
- ChatGPT
- Christopher Schölzel
keywords:
- language: python
- course: Introduction to Python for computational linguists
lang: en-US
solution-size: 10  # measured in lines of code
id: c25a78b7-8776-4486-a8b0-2e3eb3d6f3d7
---

# Histogram with Bucket Size

Modify the function `generate_histogram(data: List[int], bucket_size: Optional[int] = None) -> Dict[int, int]` in `histogram.py` so that it takes an optional parameter `bucket_size`. If `bucket_size` is provided, the function should create buckets of that size and count the occurrences of numbers falling into each bucket. If `bucket_size` is not provided (i.e., `None`), the function should behave as before, counting the occurrences of each unique value in the data.

Example:

```python
data = [1, 2, 2, 3, 3, 3, 4, 4, 4, 4]
result = generate_histogram(data, bucket_size=2)
print(result)  # -> {1: 1, 2: 2, 3: 3, 4: 4}

result = generate_histogram(data, bucket_size=3)
print(result)  # -> {1: 1, 2: 3, 3: 6, 4: 4}

result = generate_histogram(data)
print(result)  # -> {1: 1, 2: 2, 3: 3, 4: 4}
```

> Tip: You can use integer division (`//`) to determine the bucket index for each number.

Make sure to save the function in a file called `histogram.py` so that it can be imported with `from histogram import generate_histogram`.
