---
title: Standard Deviation (Unbiased Estimator)
author:
- ChatGPT
- Christopher Schölzel
keywords:
- language: python
- course: Introduction to Python for computational linguists
lang: en-US
solution-size: 8  # measured in lines of code
id: 7640db9a-23ef-44e1-86fc-3c648a441126
---

# Standard Deviation (Unbiased Estimator)

Write a function `compute_standard_deviation(data: List[float]) -> float` in `standard_deviation.py` which computes the standard deviation of a dataset using the unbiased estimator. The standard deviation of a dataset is a measure of how spread out the values in the dataset are. It is calculated as the square root of the unbiased sample variance.

The formula for the unbiased sample variance is:

\[ \sigma = \sqrt{\frac{\sum_{i=1}^{n}(x_i - \bar{x})^2}{n - 1}} \]

Where:
- \( n \) is the number of data points.
- \( x_i \) is the \( i \)th data point.
- \( \bar{x} \) is the mean of the dataset.

Example:

```python
data = [2.0, 4.0, 4.0, 4.0, 5.0, 5.0, 7.0, 9.0]
result = compute_standard_deviation(data)
print(result)  # Output: 2.138
```

> Tip: You can use the `statistics` module to compute the mean.

Make sure to save the function in a file called `standard_deviation.py` so that it can be imported with `from standard_deviation import compute_standard_deviation`.
