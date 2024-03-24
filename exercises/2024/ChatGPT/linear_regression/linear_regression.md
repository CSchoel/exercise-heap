---
title: Linear Regression
author:
- ChatGPT
- Christopher Schölzel
keywords:
- language: python
- course: Introduction to Python for computational linguists
lang: en-US
solution-size: 14  # measured in lines of code
id: 3c3153c7-21aa-4c56-9231-5d4b8e2de8e3
---

# Linear Regression

Implement a [simple linear regression algorithm](https://en.wikipedia.org/wiki/Simple_linear_regression) in `linear_regression.py` which takes a dataset in the form of two lists: `X` (independent variable) and `Y` (dependent variable), and returns the slope `m` and intercept `b` of the regression line.

The formula for the linear regression line is: 

```
Y = m * X + b
```

Where:
- `Y` is the dependent variable,
- `X` is the independent variable,
- `m` is the slope of the line,
- `b` is the intercept of the line.

Your function `linear_regression` should return the slope `m` and intercept `b` as a tuple `(m, b)`.

> Tip: You can use NumPy for mathematical operations if needed.

Make sure to save the function in a file called `linear_regression.py` so that it can be imported with `from linear_regression import linear_regression`.
