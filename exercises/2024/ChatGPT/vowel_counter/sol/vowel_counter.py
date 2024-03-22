def count_vowels(input: str) -> int:
    vowels = "aeiou"
    count = 0
    for char in input:
        if char.lower() in vowels:
            count += 1
    return count