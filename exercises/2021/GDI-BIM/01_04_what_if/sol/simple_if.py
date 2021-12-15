import random

schwellenwert = 200
result = random.randint(100, 300)
if result < 200:
    result = result * 400
else:
    result = result * 100
