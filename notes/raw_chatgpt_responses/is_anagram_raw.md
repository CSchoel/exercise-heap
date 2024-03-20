<exercise>
<description>
---
title: Anagram Checker
author:
- ChatGPT
- Christopher Schölzel
keywords:
- language: python
- course: Introduction to Python for computational linguists
lang: en-US
solution-size: 10  # measured in lines of code
id: 93853c04-1782-4ed1-8275-1f3f934d635e
---

# Anagram Checker

Create a function called `is_anagram(word1: str, word2: str) -> bool` in `anagram.py` that checks if two input strings are anagrams of each other. An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once. The function should return `True` if the two words are anagrams, and `False` otherwise.

Example:

```python
result = is_anagram("listen", "silent")
print(result)  # -> True

result = is_anagram("hello", "world")
print(result)  # -> False
```

> Hint: You can use Python's Counter class to count occurrences of characters in each word.

Make sure to save the function in a file called `anagram.py` so that it can be imported with `from anagram import is_anagram`.

</description>
<unittest>

```python
import unittest
from anagram import is_anagram

class TestAnagram(unittest.TestCase):
    
    def test_valid_anagram(self):
        self.assertTrue(is_anagram("listen", "silent"))
        self.assertTrue(is_anagram("rail safety", "fairy tales"))

    def test_invalid_anagram(self):
        self.assertFalse(is_anagram("hello", "world"))
        self.assertFalse(is_anagram("python", "pythons"))

if __name__ == '__main__':
    unittest.main()
```

</unittest>
<example_solution>

```python
from collections import Counter

def is_anagram(word1: str, word2: str) -> bool:
    return Counter(word1) == Counter(word2)
```
</example_solution>
</exercise>