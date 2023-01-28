---
title: Fake Statistics
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
- translated-from: 580e5fb2-8bb9-4b8a-a4c8-ddbd55a48edd
lang: en-US
solution-size: 13
id: 51720f24-23cc-4cb5-bbd0-f3b03c11d0fc

---
# Fake Statistics

In this task, we want to remove elements in a list and add others to it.
A lecturer is dissatisfied with his evaluation and wants to fry his results or those of the students.
The original results are the following:

```python
notes = [0.46, 0.61, 0.75, 1.0, 0.86, 0.38, 0.01, 0.77, 0.21, 0.73, 0.32, 0.99]
```

He wants to remove all notes below 50% or 0.50, i.e. a total of 5. For this he would like to add the following notes:
1.0, 1.0, 0.88, 0.90, 0.67.

You don't have to use loops for this task. It is enough to remove the elements individually with Python commands and add them again at the end of the list.

The test searches for the changed list under the variable name `note` in the file `faked_statistics.py`.
