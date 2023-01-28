---
title: Unicode in Python
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
- translated-from: 43ef1256-5850-487b-b54a-9cee60885f49
lang: en-US
solution-size: 6
id: b22edf4d-c6b6-4ee4-a2bc-504b60b61466

---
# Unicode in Python

Save the text `100€ Öcken` in a string variable called `text` in a file called `unifun.py`.
Then create the following variables:

* `code_utf8` contains the byte sequence of the text in `text` in the encoding `utf-8`.
* `code_win` contains the byte sequence of the text in `text` in the encoding `cp1252`.
* `code_mac` contains the byte sequence of the text in `text` in the encoding `macroman`.
* `text_broken` contains the text you get when you first encode the original text with the encoding `cp1252` and then decode it with the encoding `macroman`.

*Tip: To encode or decode you can use the string methods `encode()` and `decode()` (`help(str.encode)`, `help(bytes.decode)`).*