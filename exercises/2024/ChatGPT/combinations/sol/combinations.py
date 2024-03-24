def calculate_combinations(n: int, k: int) -> int:
    def factorial(num):
        if num == 0:
            return 1
        return num * factorial(num - 1)
    
    return factorial(n) // (factorial(k) * factorial(n - k))