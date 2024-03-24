from typing import List
import statistics


def compute_standard_deviation(data: List[float]) -> float:
    if len(data) == 0:
        return float("nan")
    if len(data) == 1:
        return float("inf")
    mean = statistics.mean(data)
    variance = sum((x - mean) ** 2 for x in data) / (len(data) - 1)
    return variance**0.5
