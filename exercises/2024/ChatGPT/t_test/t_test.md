---
title: T-test
author:
- ChatGPT
- Christopher Schölzel
keywords:
- language: python
- course: Introduction to Python for computational linguists
lang: en-US
solution-size: 11  # measured in lines of code
id: 68fb14b3-51a7-498e-bfa5-b4bbd33ef789
---

# T-test

Implement a function `t_test(sample1: List[float], sample2: List[float]) -> Tuple[float, float]` in `t_test.py` which performs a two-sample t-test on the provided samples. This function should return a tuple containing the t-statistic and the p-value.

**Note:** Do **not** use any functions from external libraries like NumPy or SciPy.

Example:

```python
t_statistic, p_value = t_test([1, 2, 3, 4, 5], [2, 3, 4, 5, 6])
print("t-statistic:", t_statistic)  # Example output: t-statistic: -0.7071067811865475
print("p-value:", p_value)           # Example output: p-value: 0.5131083916747507
```

> Tip: You can refer to the formula for the t-statistic and p-value in a two-sample t-test.

Make sure to save the function in a file called `t_test.py` so that it can be imported with `from t_test import t_test`.
