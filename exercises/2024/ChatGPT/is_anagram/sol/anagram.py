from collections import Counter

def is_anagram(word1: str, word2: str) -> bool:
    return Counter(word1) == Counter(word2)