from typing import List
import math

class ZScoreCalculator:
    def __init__(self, data: List[float]):
        self.mean = sum(data) / len(data) if data else 0
        self.std_dev = math.sqrt(sum((x - self.mean) ** 2 for x in data) / len(data)) if data else 0

    def calculate_z_score(self, x: float) -> float:
        return (x - self.mean) / self.std_dev if self.std_dev != 0 else 0