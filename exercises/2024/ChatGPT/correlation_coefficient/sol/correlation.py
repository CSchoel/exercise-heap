from typing import List
import math

def correlation_coefficient(X: List[float], Y: List[float]) -> float:
    if len(X) != len(Y):
        raise ValueError("Input lists must have the same length.")
    
    n = len(X)
    sum_X = sum(X)
    sum_Y = sum(Y)
    sum_XY = sum(x * y for x, y in zip(X, Y))
    sum_X_sq = sum(x ** 2 for x in X)
    sum_Y_sq = sum(y ** 2 for y in Y)
    
    numerator = n * sum_XY - sum_X * sum_Y
    denominator = math.sqrt((n * sum_X_sq - sum_X ** 2) * (n * sum_Y_sq - sum_Y ** 2))
    
    if denominator == 0:
        return 0.0
    
    return numerator / denominator