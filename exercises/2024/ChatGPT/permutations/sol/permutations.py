from itertools import permutations
from typing import Iterable, List, Any

def generate_permutations(sequence: Iterable) -> Generator[List[Any], None, None]:
    for perm in permutations(sequence):
        yield list(perm)