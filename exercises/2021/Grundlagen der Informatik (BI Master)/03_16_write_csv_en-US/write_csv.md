---
title: Write CSV
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
- translated-from: b8761069-25ad-417f-a21e-425722478088
lang: en-US
solution-size: 9
id: a87dbee0-996f-413f-9cb9-9a5618a393a0

---
# Write CSV

Write a `write_csv(fname, strings)` function in the `write_csv.py` file, which creates a file whose name is specified in the `fname` parameter, and writes a line of `s;n` form to the file for each string in the `strings` list. Here `s` stands for the string from the list and `n` indicates how much *different* letters `s` consists of.

For this example input

`["foo", "bar", "oooff"]`

the file should look like this:

```
foo;2
Cash;3
oooff;2
```