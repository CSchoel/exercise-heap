def fibonacci_iterative(value):
    fibs = [0, 1, 1]
    for f in range(2, value):
        fibs.append(fibs[-1] + fibs[-2])
    return fibs[value]

