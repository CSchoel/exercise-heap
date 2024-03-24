from typing import List
import numpy as np

def linear_regression(X: List[float], Y: List[float]) -> tuple:
    X_mean = np.mean(X)
    Y_mean = np.mean(Y)

    numerator = sum((x - X_mean) * (y - Y_mean) for x, y in zip(X, Y))
    denominator = sum((x - X_mean) ** 2 for x in X)

    slope = numerator / denominator
    intercept = Y_mean - slope * X_mean

    return slope, intercept