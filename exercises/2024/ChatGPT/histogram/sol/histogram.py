import math

from typing import List, Tuple


def calculate_histogram(
    data: List[float], bucket_size: float
) -> Tuple[List[float], List[int]]:
    if not data:
        return [0.0], [0]

    min_val = math.floor(min(data) / bucket_size) * bucket_size
    max_val = max(data)
    num_buckets = int((max_val - min_val) / bucket_size) + 1
    bucket_limits = [min_val + i * bucket_size for i in range(num_buckets)]
    bucket_counts = [0] * num_buckets

    for value in data:
        bucket_index = int((value - min_val) / bucket_size)
        bucket_counts[bucket_index] += 1

    return bucket_limits, bucket_counts
