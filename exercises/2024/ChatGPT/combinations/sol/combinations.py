def calculate_combinations(n: int, k: int) -> int:
    if k == 0:
        return 1
    if k > n / 2:
        return calculate_combinations(n, n - k)
    return n * calculate_combinations(n - 1, k - 1) // k
