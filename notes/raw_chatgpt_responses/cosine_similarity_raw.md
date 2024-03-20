<exercise>
<description>
---
title: Sentence Similarity
author:
- ChatGPT
- Christopher Schölzel
keywords:
- language: python
- course: Introduction to Python for computational linguists
lang: en-US
solution-size: 11  # measured in lines of code
id: 5111a717-e313-49b5-b95f-8bec5a07e31f
---

# Sentence Similarity

Implement a function `sentence_similarity(sentence1: str, sentence2: str) -> float` in `sentence_similarity.py` which calculates the cosine similarity between two input sentences.

The cosine similarity between two vectors A and B is calculated as:

\[ \text{similarity} = \frac{A \cdot B}{\|A\| \times \|B\|} \]

Where \(A \cdot B\) is the dot product of A and B, and \(\|A\|\) and \(\|B\|\) are the magnitudes of vectors A and B, respectively. For sentences, you'll treat them as Bag-of-Words vectors, where each word is a dimension and the value is the frequency of the word in the sentence.

Example:

```python
similarity = sentence_similarity("I like bananas", "I like apples")
print(similarity) # Output should be approximately 0.7071067811865475
```

You can ignore punctuation and consider words case-insensitively.

> Tip: You can use the `Counter` class from the `collections` module to count word frequencies.

Make sure to save the function in a file called `sentence_similarity.py` so that it can be imported with `from sentence_similarity import sentence_similarity`.

</description>
<unittest>

```python
import unittest
from sentence_similarity import sentence_similarity

class TestSimilarity(unittest.TestCase):

    def test_similarity_same_sentence(self):
        sentence1 = "I like bananas"
        similarity = sentence_similarity(sentence1, sentence1)
        self.assertEqual(1.0, similarity)

    def test_similarity_different_sentences(self):
        sentence1 = "I like bananas"
        sentence2 = "I like apples"
        similarity = sentence_similarity(sentence1, sentence2)
        self.assertAlmostEqual(0.7071067811865475, similarity, places=5)

    def test_similarity_different_order(self):
        sentence1 = "I like bananas"
        sentence2 = "bananas like I"
        similarity = sentence_similarity(sentence1, sentence2)
        self.assertEqual(1.0, similarity)

if __name__ == '__main__':
    unittest.main()
```

</unittest>
<example_solution>

```python
from typing import List
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
```
</example_solution>
</exercise>