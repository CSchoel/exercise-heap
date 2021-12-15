def fib(n):
    a, b = 0, 1
    for x in range(n):
        a, b = b, a + b
    return a

if __name__ == '__main__':
    fib(5)
