---
title: Indentation
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
- translated-from: 74eab8f0-f4cd-44dc-b466-eea869b33cd9
lang: en-US
solution-size: 5
id: 2d6d22af-1b89-4c07-afb8-629a1a01ec2e

---
# Indentation

Write a file called `indent.py` in which you can read out a whole positive number from the standard input (`help(input)`) and save it to the variable `indent`.
If the user enters a negative number, they enter the error message `The number must be positive!`.
If the number is positive or zero, output a number of spaces in front of it, which corresponds to the value of the variable `indent`, followed by the text `indented`.

Example:

Input: 6
Output: `      indented`

Input: 3
Output: `   indented`

*Tip: Remember that you can also multiply strings in Python.*