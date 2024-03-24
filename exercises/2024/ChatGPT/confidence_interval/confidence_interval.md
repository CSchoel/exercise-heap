---
title: Confidence Intervals
author:
- ChatGPT
- Christopher Schölzel
keywords:
- language: python
- course: Introduction to Python for computational linguists
lang: en-US
solution-size: 12  # measured in lines of code
id: f39fd8a2-06d3-48f0-9f2b-6726b44fd978
---

# Confidence Intervals

Write a function `calculate_confidence_interval(data: List[float], confidence: float) -> Tuple[float, float]` in `confidence_intervals.py` that calculates the confidence interval for a dataset given as a list of floats (`data`). The `confidence` parameter should be a float between 0 and 1, representing the desired confidence level.

The formula to calculate the confidence interval is:

\[ \text{CI} = \bar{x} \pm z \times \frac{s}{\sqrt{n}} \]

where:
- \(\bar{x}\) is the sample mean
- \(z\) is the z-score corresponding to the desired confidence level
- \(s\) is the standard deviation of the sample
- \(n\) is the sample size

> Hint: You can use the `NormalDist` class from the `statistics` module to get the z-score with `NormalDist.inv_cdf`. You might need to Google a bit to find the correct argument. That's okay, but try to understand any code that you copy before you use it.

Example:

```python
data = [3.4, 2.7, 4.1, 3.9, 2.8, 3.5, 3.7]
confidence_level = 0.95
result = calculate_confidence_interval(data, confidence_level)
print(result)  # Example output: (3.033, 3.767)
```

> Note: Although Python provides functions in `scipy.stats` or other libraries to calculate confidence intervals easily, in this exercise, implement the calculation manually for learning purposes.

Make sure to save the function in a file called `confidence_intervals.py` so that it can be imported with `from confidence_intervals import calculate_confidence_interval`.
