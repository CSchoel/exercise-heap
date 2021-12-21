---
title: Begrüßung
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
solution-size: 4
id: dddc9d97-89b9-484f-aa13-32711436eb08
---

# Begrüßung

Fragen Sie den Benutzer in einer Python-Datei namens `greetings.py` erst nach einer gewünschten Grußformel und dann einem Namen, die beide über den standard input stream eingegeben werden sollen.
Das geht in Python mit dem folgenden Befehl:

```python
name = input("Name:")
```

Speichern Sie die Grußformel in einer Variable `greeting` und den Namen in einer Variable `name` und geben Sie dann mit `print()` die Grußformel gefolgt von dem namen aus. Beispiel:

Name `Hugo` + Grußformel `Seid mir gegrüßt, edler ` ergibt Ausgabe `Seid mir gegrüßt, edler Hugo`.