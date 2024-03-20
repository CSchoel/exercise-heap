<exercise>
<description>
---
title: Pig Latin Translation
author:
- ChatGPT
- Christopher Schölzel
keywords:
- language: python
- course: Introduction to Python for computational linguists
lang: en-US
solution-size: 11  # measured in lines of code
id: 5111a717-e313-49b5-b95f-8bec5a07e30e
---

# Pig Latin Translation

Implement a function `pig_latin(sentence: str) -> str` in `piglatin.py` which translates a given sentence into Pig Latin. In Pig Latin, you move the first letter of each word to the end of the word and add "ay". Words that start with a vowel (a, e, i, o, u) simply have "ay" added to the end.

Example:

```python
result = pig_latin("hello world")
print(result) # -> "ellohay orldway"
```

> Tip: You can use string manipulation methods like `split()` and string slicing.

Make sure to save the function in a file called `piglatin.py` so that it can be imported with `from piglatin import pig_latin`.

</description>
<unittest>

```python
import unittest

from piglatin import pig_latin

class TestPigLatin(unittest.TestCase):
    
    def testPigLatin(self):
        sentence = "hello world"
        result = pig_latin(sentence)
        self.assertEqual("ellohay orldway", result)

    def testPigLatin2(self):
        sentence = "python is fun"
        result = pig_latin(sentence)
        self.assertEqual("ythonpay isay unfay", result)

if __name__ == '__main__':
    unittest.main()
```

</unittest>
<example_solution>

```python
def pig_latin(sentence: str) -> str:
    vowels = "aeiou"
    words = sentence.split()
    pig_latin_words = []
    
    for word in words:
        if word[0].lower() in vowels:
            pig_latin_words.append(word + "ay")
        else:
            pig_latin_words.append(word[1:] + word[0] + "ay")
    
    return " ".join(pig_latin_words)
```
</example_solution>
</exercise>