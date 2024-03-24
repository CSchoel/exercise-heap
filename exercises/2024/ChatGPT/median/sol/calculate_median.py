from typing import List

def calculate_median(numbers: List[float]) -> float:
    numbers.sort()
    n = len(numbers)
    if n == 0:
        return None
    if n % 2 == 0:
        mid1 = numbers[n // 2 - 1]
        mid2 = numbers[n // 2]
        return (mid1 + mid2) / 2
    else:
        return numbers[n // 2]