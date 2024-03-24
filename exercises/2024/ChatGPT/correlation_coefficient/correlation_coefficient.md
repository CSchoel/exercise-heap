---
title: Correlation Coefficient
author:
- ChatGPT
- Christopher Schölzel
keywords:
- language: python
- course: Introduction to Python for computational linguists
lang: en-US
solution-size: 10  # measured in lines of code
id: 04d8b3e0-a963-46ee-aee1-9fd9f9341ac4
---

# Correlation Coefficient 

Implement a function `correlation_coefficient(X: List[float], Y: List[float]) -> float` in `correlation.py` which calculates the correlation coefficient between two datasets represented as lists of floats. 

The correlation coefficient, also known as Pearson's correlation coefficient, is a measure that quantifies the degree to which two datasets are linearly related. It ranges from -1 to 1, where:

- 1 indicates a perfect positive linear relationship,
- -1 indicates a perfect negative linear relationship, and
- 0 indicates no linear relationship between the datasets.

The formula to compute the correlation coefficient is as follows:

\[
r = \frac{{\sum{(X_i - \bar{X})(Y_i - \bar{Y})}}}{{\sqrt{\sum{(X_i - \bar{X})^2}} \sqrt{\sum{(Y_i - \bar{Y})^2}}}}
\]

Where:
- \(X\) and \(Y\) are the datasets,
- \(X_i\) and \(Y_i\) are individual data points in \(X\) and \(Y\),
- \(\bar{X}\) and \(\bar{Y}\) are the means of \(X\) and \(Y\) respectively.

Example:

```python
X = [1, 2, 3, 4, 5]
Y = [2, 4, 6, 8, 10]
result = correlation_coefficient(X, Y)
print(result)  # Expected output: 1.0 (Perfect positive correlation)
```

Make sure to save the function in a file called `correlation.py` so that it can be imported with `from correlation import correlation_coefficient`.
