from typing import List, Tuple
import math
from scipy.stats import norm

def calculate_confidence_interval(data: List[float], confidence: float) -> Tuple[float, float]:
    mean = sum(data) / len(data)
    std_dev = math.sqrt(sum((x - mean) ** 2 for x in data) / (len(data) - 1))
    z_score = norm.ppf((1 + confidence) / 2)
    margin_of_error = z_score * (std_dev / math.sqrt(len(data)))
    lower_bound = mean - margin_of_error
    upper_bound = mean + margin_of_error
    return lower_bound, upper_bound