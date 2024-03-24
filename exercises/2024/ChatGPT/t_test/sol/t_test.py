from typing import List, Tuple
import math


def mean(sample: List[float]) -> float:
    return sum(sample) / len(sample)


def variance(sample: List[float]) -> float:
    sample_mean = mean(sample)
    return sum((x - sample_mean) ** 2 for x in sample) / (len(sample) - 1)


def t_test(sample1: List[float], sample2: List[float]) -> Tuple[float, float]:
    if not sample1 or not sample2:
        return float("nan"), float("nan")

    n1 = len(sample1)
    n2 = len(sample2)
    mean1 = mean(sample1)
    mean2 = mean(sample2)
    var1 = variance(sample1)
    var2 = variance(sample2)

    pooled_var = ((n1 - 1) * var1 + (n2 - 1) * var2) / (n1 + n2 - 2)
    t_statistic = (mean1 - mean2) / math.sqrt(pooled_var * (1 / n1 + 1 / n2))

    # Degrees of freedom
    df = n1 + n2 - 2

    # Calculate p-value using t-distribution
    from scipy.stats import t

    p_value = 2 * (1 - t.cdf(abs(t_statistic), df))
    return t_statistic, p_value
