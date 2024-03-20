<exercise>
<description>
---
title: Vowel Counter
author:
- ChatGPT
- Christopher Schölzel
keywords:
- language: python
- course: Introduction to Python for computational linguists
lang: en-US
solution-size: 5  # measured in lines of code
id: 37a7dacc-07ef-4b15-a32e-cd963e252bc7
---

# Vowel Counter

Write a function `count_vowels(input: str) -> int` in `vowel_counter.py` that takes a string `input` and returns the number of vowels (a, e, i, o, u) in the input string.

Example:

```python
result = count_vowels("hello")
print(result) # -> 2

result = count_vowels("python")
print(result) # -> 1
```

Make sure to save the function in a file called `vowel_counter.py` so that it can be imported with `from vowel_counter import count_vowels`.

</description>
<unittest>

```python
import unittest

from vowel_counter import count_vowels

class TestCountVowels(unittest.TestCase):
    
    def testNoVowels(self):
        input = "rhythm"
        result = count_vowels(input)
        self.assertEqual(0, result)

    def testAllVowels(self):
        input = "aeiou"
        result = count_vowels(input)
        self.assertEqual(5, result)

    def testMixedCase(self):
        input = "AbCdEfGhIj"
        result = count_vowels(input)
        self.assertEqual(3, result)

if __name__ == '__main__':
    unittest.main()
```

</unittest>
<example_solution>

```python
def count_vowels(input: str) -> int:
    vowels = "aeiou"
    count = 0
    for char in input:
        if char.lower() in vowels:
            count += 1
    return count
```
</example_solution>
</exercise>