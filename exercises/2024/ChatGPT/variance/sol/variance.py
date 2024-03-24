from typing import List

def calculate_variance(data: List[float]) -> float:
    n = len(data)
    if n == 0 or n == 1:
        return 0.0
    
    mean = sum(data) / n
    variance = sum((x - mean) ** 2 for x in data) / (n - 1)
    return variance