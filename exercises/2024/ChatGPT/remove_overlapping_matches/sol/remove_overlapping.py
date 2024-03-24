from typing import List, Tuple

def remove_overlapping_matches(matches: List[Tuple[int, int, int]]) -> List[Tuple[int, int, int]]:
    matches.sort(key=lambda x: (x[0], -x[2]))  # Sort by start position, then descending priority
    non_overlapping = []
    end = -1
    for start, new_end, priority in matches:
        if start >= end:
            non_overlapping.append((start, new_end, priority))
            end = new_end
    return non_overlapping