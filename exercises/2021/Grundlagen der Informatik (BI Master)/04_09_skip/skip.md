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
lang: de-DE
solution-size: 16
id: 5e78f0c6-03eb-44e5-a8a6-e0bdd67e6814
---

# Skip

Schreiben Sie in der datei `skip.py` eine Generatorfunktion `skip(n, iterable)`, die ein iterierbares Objekt (z.B. Liste, Set, range, ...) `iterable` als zweites Argument übernimmt und einen Iterator zurückgibt, der die ersten `n` (erstes Argument) Elemente im Iterator überspringt.

Beispiele:

```python
>>> list(skip(3, range(5)))
[3, 4]
>>> list(skip(2, [1,2,3]))
[3]
>>> list(skip(1, map(len, ["foo", "bar", "foobar"])))
[3, 6]
```

*Hinweis: Verwenden Sie kein `return`, sondern ein `yield`.*

*Tipp: Schauen Sie sich die Funktionen `next()` und `iter()` an. Denken Sie daran, dass Ihr input auch etwas anderes als eine Liste sein kann.*