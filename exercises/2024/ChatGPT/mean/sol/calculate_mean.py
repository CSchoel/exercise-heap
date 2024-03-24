import math
from typing import List


def calculate_mean(numbers: List[float]) -> float:
    if not numbers:
        return math.nan
    return sum(numbers) / len(numbers)
