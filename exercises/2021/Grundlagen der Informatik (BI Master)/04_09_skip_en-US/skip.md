---
title: Skip
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
- translated-from: 5e78f0c6-03eb-44e5-a8a6-e0bdd67e6814
lang: en-US
solution-size: 16
id: 87760164-cccd-4d41-9871-675a69f7f22d

---
# Skip

In the `skip.py` file, write a generator function `skip(n, iterable)`, which takes over an iterable object (e.g. list, set, range,...) `iterable` as a second argument and returns an iterator that skips the first `n` (first argument) elements in the iterator.

Examples:

```python
>>> list(skip(3, range(5)))
[3, 4]
>>> list(skip(2, [1,2,3])
[3]
>>> list(skip(1, map(len, ["foo", "bar", "foobar"]))
[3, 6]
```

*Note: Do not use a `return`, but a `yield`.*

*Tip: Take a look at the functions `next()` and `iter()`. Remember that your input can also be something other than a list.*