---
title: File I/O
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
solution-size: 10
id: fcac20f9-7d14-4209-9e82-e8d5dcbce320
---

# File I/O

Schreibe  eine Funktion `read_file` in  der Datei `read_fasta.py`, die die Datei: `uniprot_small.fasta` einliest.
Gebe alle IDs (Siehe unten) in einer Liste zurück.

Die Fasta-Datei ist wie folgt aufgebaut: 

* Bei ">" beginnt die Zeile mit der ID, diese steht zwischen den |...|, danach kommen Informationen über die Sequenz und in der nächsten Zeile die Sequenz selbst.

```
>sp|Q6GZW9|006R_FRG3G Uncharacterized protein 006R OS=Frog virus 3 (isolate Goorha) GN=FV3-006R PE=4 SV=1
MYKMYFLKDQKFSLSGTIRINDKTQSEYGSVWCPGLSITGLHHDAIDHNMFEEMETEIIE
YLGPWVQAEYRRIKG
```

> Tipp: Die Datei für diese Aufgabe findest Du unter `dozeloc/03_15_file-io/test/uniprot_small.fasta
