import statistics
l = [500, 504, 499, 399, 590, 123, 430, 758, 938, 637, 750, 735]

result = 0
for element in l:
    result += element
result = result / len(l)

# print(result)
# print(statistics.mean(l))