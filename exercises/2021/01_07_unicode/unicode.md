---
title: Unicode in Python
author:
    - GDI-Tutoren
    - Christopher Schölzel
keywords:
    - python
    - semester-1
    - bioinformatics
    - Technische Hochschule Mittelhessen
    - Justus-Liebig-Universität
    - Grundlagen der Informatik
lang: de-DE
solution-size: 6
---

# Unicode in Python

Speichern Sie den Text `100€ Öcken` in einer Stringvariable namens `text` in einer Datei namens `unifun.py`.
Erstellen Sie dann die folgenden Variablen:

* `code_utf8` enthält die Bytefolge des Textes in `text` in der Kodierung `utf-8`.
* `code_win` enthält die Bytefolge des Textes in `text` in der Kodierung `cp1252`.
* `code_mac` enthält die Bytefolge des Textes in `text` in der Kodierung `macroman`.
* `text_broken` enthält den Text den man erhält wenn man den Ursprungstext erst mit der Kodierung `cp1252` kodiert und dann mit der Kodierung `macroman` dekodiert.

*Tipp: Zum kodieren bzw. dekodieren können Sie die String-Methoden `encode()` und `decode()` verwenden (`help(str.encode)`, `help(bytes.decode)`).*