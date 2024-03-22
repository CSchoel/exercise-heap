from collections import Counter
import math


def sentence_similarity(sentence1: str, sentence2: str) -> float:
    def vectorize(sentence):
        words = sentence.lower().split()
        word_counts = Counter(words)
        return word_counts

    vec1 = vectorize(sentence1)
    vec2 = vectorize(sentence2)

    intersection = set(vec1.keys()) & set(vec2.keys())
    dot_product = sum(vec1[word] * vec2[word] for word in intersection)

    magnitude1 = math.sqrt(sum(vec1[word] ** 2 for word in vec1))
    magnitude2 = math.sqrt(sum(vec2[word] ** 2 for word in vec2))

    similarity = dot_product / (magnitude1 * magnitude2)
    return similarity
