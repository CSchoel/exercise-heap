---
title: DNA Test
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
solution-size: 18
id: 4ff99da4-dd28-44a7-9bf5-2f6f84b7c960
---

# DNA Test
Implementieren Sie eine Funktion `dnatest` in `dnatest.py`, welche einen String als Input bekommt und eine Boolean zurückgibt. Die Funktion soll testen, ob in dem Input String die Aminosäure Lysin codiert wird. Wenn Lysin codiert wird, soll diese `True` zurückgeben, sonst `False`.

> Tipp: Es gibt mehr als nur eine Codierung für Lysin

> Tipp: Achten Sie darauf, dass die Zeichenkette nur als zusammenhängende Basenkette vorkommt. Sie können die Lösung Ihrer vorherigen Aufgabe `splitting` gerne wiederverwenden: \
> Gehen Sie sicher, dass die Datei im gleichen Ordner wie die neue Aufgabe ist und verwenden Sie `import splitting`.
> Daraufhin können Sie mit `splitting.splitting("ABCDEF", 9)` darauf zugreifen.