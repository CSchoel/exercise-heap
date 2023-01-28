---
title: Merge Lists
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
- translated-from: 0aab231b-5277-4b77-bf84-11ccbc8eab89
lang: en-US
solution-size: 9
id: b4a0df64-5677-42bb-8e8e-a239fa5d31d8

---
# Merge Lists

The following list is given:

```python
l = [[4, 3], [50, 100], [3, 44], [120, 948], [84, 31]
# Oh no it contains more lists
```

Something's gone wrong here! Unfortunately, our list l contains lists again, which in turn contain elements.
We wanted to have a list of all the elements.
Can you merge the list of lists into a single list of all elements?
(Here loops are allowed again, please save the result in a variable called `result` in the file `merge_lists.py`, then the test is easier).
