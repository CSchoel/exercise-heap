import random
from typing import List

def random_sample(data: List[str], sample_size: int) -> List[str]:
    if sample_size <= 0:
        return []
    elif sample_size >= len(data):
        return data
    else:
        return random.sample(data, sample_size)