---
title: What_if 1
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
- translated-from: f21504e6-6011-4bd4-9eb5-e67ec843a851
lang: en-US
solution-size: 8
id: 7171a44c-2ccc-405b-aa11-1823ebf911b6

---
# What_if 1

A questionable scientist has told us that we could get the most important value of his highly controversial laboratory analysis with the following command.

```python
import random

awesome_result = random.randint(100, 300)
```

We were told to compare this value with the threshold: 200 and to stretch it.
If the value is below the threshold, it should be multiplied by 400, otherwise by 100.
The result should be saved to a variable named `result` in the source file `simple_if.py`.