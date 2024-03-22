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
