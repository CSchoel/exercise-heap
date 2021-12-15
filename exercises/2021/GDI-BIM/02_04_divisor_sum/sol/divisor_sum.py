import math

result = 0
n = 8128
for x in range(1, n // 2 + 1):
    if n % x == 0:
        result += x
