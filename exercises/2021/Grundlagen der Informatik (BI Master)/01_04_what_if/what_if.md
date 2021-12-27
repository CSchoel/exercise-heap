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
lang: de-DE
solution-size: 8
id: f21504e6-6011-4bd4-9eb5-e67ec843a851
---

# What_if 1

Ein fragwürdiger Wissenschaftler hat uns gesagt, wir könnten den wichtigsten Wert seiner hochrbrisanten Laboranalyse mit dem folgenden Befehl bekommen.

```python
import random

awesome_result = random.randint(100, 300)
```

Uns wurde aufgetragen, diesen Wert mit dem Schwellenwert: 200 zu vergleichen und ihn zu strecken.
Wenn der Wert unter dem Schwellenwert liegt soll er mit 400 multipliziert werden, ansonsten mit 100.
Das Ergebnis soll ein einer Variable namens `result` in der Quelldatei `simple_if.py` gespeichert werden.