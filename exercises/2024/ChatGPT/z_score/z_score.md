---
title: Z-score Calculation with Class
author:
- ChatGPT
- Christopher Schölzel
keywords:
- language: python
- course: Introduction to Python for computational linguists
lang: en-US
solution-size: 14  # measured in lines of code
id: 91f9dc76-f774-4cf5-b9d6-9f6312fc0c9f
---

# Z-score Calculation with Class

Implement a class `ZScoreCalculator` in `z_score.py` which calculates the mean and standard deviation of a dataset once and then provides a method to calculate the Z-score of an individual element. The Z-score of an element is calculated as follows:

\[ Z = \frac{x - \mu}{\sigma} \]

Where \( x \) is the element, \( \mu \) is the mean of the data, and \( \sigma \) is the standard deviation of the data.

The class should have the following methods:

1. `__init__(self, data: List[float])`: Constructor method that takes a list of numbers as input and initializes the mean and standard deviation.
2. `calculate_z_score(self, x: float) -> float`: Method that calculates the Z-score of the given element `x` using the pre-calculated mean and standard deviation.

Example:

```python
# Initialize with data
calculator = ZScoreCalculator([1, 2, 3, 4, 5])

# Calculate Z-score for individual elements
print(calculator.calculate_z_score(3))  # -> 0.0
print(calculator.calculate_z_score(6))  # -> 1.414213562373095
```

Make sure to save the class in a file called `z_score.py` so that it can be imported with `from z_score import ZScoreCalculator`.
