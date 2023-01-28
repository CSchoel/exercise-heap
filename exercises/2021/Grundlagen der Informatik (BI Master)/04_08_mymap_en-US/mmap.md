---
title: Own map function
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
- translated-from: dcfb9961-7416-475e-97c0-07c7185918d9
lang: en-US
solution-size: 10
id: d5db866d-e22d-440c-8f84-5664eaaeb2ae

---
# Own map function

We already know the map function in the lecture, now we want to write our own map function.
(This must not be called `map`! Proposal: `my_map`)


The function should take a function (e.g. in the form of a lambda expression) and an iterable object (e.g. a list) as arguments.
The passed function should be applied for each element in the iterable, the method should then return a new iterable, for example a list.

The following list is given: 

```python 
l = [1, 2, 3]
```

The Lambda expression should multiply a value with 42, the result of the method must be stored in a variable named `result`.
Note: The file should be called as follows: `my_map.py`