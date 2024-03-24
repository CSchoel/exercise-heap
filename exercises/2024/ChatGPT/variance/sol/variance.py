from typing import List


def calculate_variance(data: List[float]) -> float:
    n = len(data)
    if n == 0:
        return float("nan")
    if n == 1:
        return float("inf")

    mean = sum(data) / n
    variance = sum((x - mean) ** 2 for x in data) / (n - 1)
    return variance
