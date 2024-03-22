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
