from typing import Set


a = [1, 5, 9, 13, 17]
b = [3, 6, 9, 13, 17, 20]

unique: Set[int] = set()
for val in a+b:
    if val not in a or val not in b:
        unique.add(val)

