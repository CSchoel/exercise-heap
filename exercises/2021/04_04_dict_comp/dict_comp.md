---
title: Dictionary Comprehensions
author:
    - GDI-Tutoren
    - Christopher Schölzel
keywords:
    - python
    - semester-1
    - bioinformatics
lang: de-DE
solution-size: 9
---

# Dictionary Comprehensions

Schreibe eine Funktion `make_dict(sentence: str) -> Dict[str, int]` in der Datei `dictionary_comprehension.py`.
Diese Funktion nimmt einen Satz (siehe unten) und erzeugt aus diesem ein Dictionary.
Die Methode soll hierbei den Satz so verarbeiten, dass das jeweilige Wort der Key im Dictionary ist und die Länge des Wortes das Value. 
Das Wort `"the"` möchten wir aber nie im Dictionary speichern! 

Verwenden Sie hierfür Dictionary-Comprehensions.

Testen Sie ihre Funktion mit dem Satz:
`"the quick brown fox jumps over the lazy dog"` und speichern Sie das Ergebnis in der Variable `result`.