---
title: Splitting 
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
id: 685cd658-689d-4ecb-b440-a5366be3db24
---

# Splitting 

Implementieren Sie eine Funktion `splitting(input: str, batchSize: int) -> List[str]` in `splitting.py` welche einen String als Input bekommt, sowie eine Zahl `batchSize`. Diese Funktion soll eine Liste zurückgeben, in welcher der Input nach `batchSize` Zeichen gesplitted wird. 

Beispiel:

```python
	result = splitting("ABCDEFGH",4)
    print(result) # -> ['ABCD','EFGH']

    result = splitting("ABCDEFGH",3)
    print(result) # -> ['ABC','DEF','GH']
```


> Tipp: Verwenden Sie den bereits kennen gelernten Splicing-Operator.

> Sie können diese Funktion in zukünftigen Aufgaben wiederverwenden:\
> Gehen Sie sicher, dass die Datei im gleichen Ordner wie die neue Aufgabe ist und verwenden Sie `import splitting`.
> Daraufhin können Sie mit `splitting.splitting("ABCDEF", 9)` darauf zugreifen.