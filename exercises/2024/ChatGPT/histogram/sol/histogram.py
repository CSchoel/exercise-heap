from typing import List, Dict, Optional
from collections import defaultdict

def generate_histogram(data: List[int], bucket_size: Optional[int] = None) -> Dict[int, int]:
    histogram = defaultdict(int)
    if bucket_size:
        for num in data:
            bucket = num // bucket_size
            histogram[bucket] += 1
    else:
        for num in data:
            histogram[num] += 1
    return dict(histogram)