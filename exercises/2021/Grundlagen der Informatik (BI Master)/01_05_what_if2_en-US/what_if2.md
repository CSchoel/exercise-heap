---
title: What_if 2
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
- translated-from: 90e6c878-94fa-4682-a083-f88c15b4b90e
lang: en-US
solution-size: 8
id: 7ffe795a-ecbc-419f-bd2f-ba6db7be0198

---
# What_if 2

In this task it is about checking whether the age of Mannfred allows to see the new John Wick in the cinema.

Manfred's old we find out with the following piece code

```python
import random

age = random.randint(1, 100)
```

The film is rated FSK 18. If Mannfred's age is big enough, we would like to write the value `True` in the variable `result`, otherwise `false`.
As an additional difficulty, the management of the cinema for which we are working does not want to be responsible for older viewers dying of a heart attack.
That's why Mannfred shouldn't be allowed to see the film even if he's 82 or older.

Please call your source file `age.py`.