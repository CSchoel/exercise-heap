---
title: Dictionary Comprehensions
author:
- GDI-Tutoren
- Christopher Schölzel
keywords:
- language: python
- semester: 1
- major: bioinformatics
- institution: Technische Hochschule Mittelhessen
- institution: Justus-Liebig-Universität
- course: Grundlagen der Informatik
- translated-from: e05d01c5-5d7b-40ea-96e1-ab747c8f5a4c
lang: en-US
solution-size: 9
id: 39f404dc-295b-4fa0-b95c-51496247697b

---
# Dictionary Comprehensions

Write a `make_dict(sentence: str) -> Dict[str, int]` function in the `dictionary_comprehension.py` file.
This function takes a sentence (see below) and creates a dictionary from it.
The method should process the sentence in such a way that the dictionary has the words as keys and the length of the respective word is the value. 
But we never want to save the word `"the"` in the dictionary!

Use Dictionary Comprehensions for this.

Test your function with the sentence:
`"the quick brown fox jumps over the lazy dog"` and save the result in the variable `result`.
