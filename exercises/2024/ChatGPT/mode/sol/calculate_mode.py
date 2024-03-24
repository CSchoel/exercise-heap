from typing import List
from collections import Counter

def calculate_mode(numbers: List[int]) -> List[int]:
    if not numbers:
        return []
    
    count = Counter(numbers)
    max_count = max(count.values())
    modes = [num for num, freq in count.items() if freq == max_count]
    
    return sorted(modes)