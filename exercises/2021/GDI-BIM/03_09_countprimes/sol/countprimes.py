
def isPrime(n: int) -> bool:
    for i in range(2,(n // 2) + 1):
    # for i in range(2, n):
        if(n % i == 0):
            return False
    return True

def countPrimes(n: int) -> int:
    counter = 0
    for i in range(2, n+1):
        if isPrime(i):
            counter += 1
    return counter
