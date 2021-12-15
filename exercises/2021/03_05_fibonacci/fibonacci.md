---
title: Fibonacci
author:
    - GDI-Tutoren
    - Christopher Schölzel
keywords:
    - python
    - semester-1
    - bioinformatics
lang: de-DE
solution-size: 8
---

# Fibonacci

Schreiben Sie eine Funktion `fib(n)` in der Datei `fibonacci.py`, die die Fibonacci-Funktion implementiert:

```
fib(n) = n                   falls n <= 1
         fib(n-1) + fib(n-2) sonst
```

Beispiele:

* fib(0) = 0
* fib(1) = 1
* fib(2) = 0 + 1 = 1
* fib(3) = 1 + 1 = 2
* fib(4) = 1 + 2 = 3

*Tipp: Sie können diese **rekursive** Funktionsdefinition exakt so in Python abschreiben. Sie können aber auch gerne einen anderen Lösungsweg wählen.*