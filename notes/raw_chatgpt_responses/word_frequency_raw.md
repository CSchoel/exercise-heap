<exercise>
<description>
---
title: Word Frequency Counter
author:
- ChatGPT
- Christopher Schölzel
keywords:
- language: python
- course: Introduction to Python for computational linguists
lang: en-US
solution-size: 10  # measured in lines of code
id: 42f3d804-ecb2-4fa0-b5aa-14e330a2f3e7
---

# Word Frequency Counter

Write a function `word_frequency(text: str) -> dict` in a file named `word_frequency.py`. The function should take a string `text` as input and return a dictionary where keys are words in the text, and values are the frequencies of those words in the text.

The function should be case-insensitive, meaning "Word" and "word" should be considered the same word.

Example:

```python
result = word_frequency("This is a test. This is only a test.")
print(result) # -> {'this': 2, 'is': 2, 'a': 2, 'test': 2, 'only': 1}
```

> Tip: You can use the `split()` method to split the text into words and `lower()` method to convert words to lowercase.

</description>
<unittest>

```python
import unittest

from word_frequency import word_frequency

class TestWordFrequency(unittest.TestCase):
    
    def testSimpleSentence(self):
        input_text = "This is a test. This is only a test."
        result = word_frequency(input_text)
        expected_result = {'this': 2, 'is': 2, 'a': 2, 'test': 2, 'only': 1}
        self.assertEqual(expected_result, result)

    def testEmptyText(self):
        input_text = ""
        result = word_frequency(input_text)
        self.assertEqual({}, result)

if __name__ == '__main__':
    unittest.main()
```

</unittest>
<example_solution>

```python
def word_frequency(text: str) -> dict:
    word_list = text.lower().split()
    frequency_dict = {}
    for word in word_list:
        frequency_dict[word] = frequency_dict.get(word, 0) + 1
    return frequency_dict
```
</example_solution>
</exercise>