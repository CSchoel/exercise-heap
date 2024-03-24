---
title: Variance Calculation (Unbiased Estimator)
author:
- ChatGPT
- Christopher Schölzel
keywords:
- language: python
- course: Introduction to Python for computational linguists
lang: en-US
solution-size: 8  # measured in lines of code
id: 92d0d5c8-0b6c-4fe0-b47c-7f84c3c30e48
---

# Variance Calculation (Unbiased Estimator)

Implement a function `calculate_variance(data: List[float]) -> float` in `variance.py` which calculates the variance of a dataset using the unbiased estimator.

The unbiased estimator for the variance corrects for the bias introduced by using sample data rather than a full population. Mathematically, it is represented as:

\[ \text{variance} = \frac{1}{n-1} \sum_{i=1}^{n} (x_i - \bar{x})^2 \]

Where:
- \(n\) is the number of data points.
- \(x_i\) is the \(i\)-th data point.
- \(\bar{x}\) is the mean of the dataset.

Example:

```python
data = [1, 2, 3, 4, 5]
result = calculate_variance(data)
print(result)  # Output: 3.5
```

> Hint: You can calculate the mean of the dataset using the `sum()` function and the `len()` function.

Make sure to save the function in a file called `variance.py` so that it can be imported with `from variance import calculate_variance`.
