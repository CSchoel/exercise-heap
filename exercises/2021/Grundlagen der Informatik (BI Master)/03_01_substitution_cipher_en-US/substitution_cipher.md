---
title: Substitution Cipher
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
- translated-from: 0a6d5a16-8349-449b-8647-774746ddf85d
lang: en-US
solution-size: 2
id: f1a3ae1a-7086-40eb-a17e-895243bd40d0

---
# Substitution Cipher

Write a `subst(message, cipher)` function in the `substitution_cipher.py` file, which replaces all characters in the `message` string using the `cipher` dictionary. This means you have to use each character `c` from `message` as a key in `cipher` and determine the assigned value (as a character `z`).

Example:

```python
>>> cipher = {'A': 'T', 'C': 'G', 'G': 'C', 'T': 'A'}
>>> subst("AAGCAGT", cipher)
TTCGTCA
```