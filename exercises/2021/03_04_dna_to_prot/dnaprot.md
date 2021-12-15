---
title: DNA to Protein
author:
    - GDI-Tutoren
    - Christopher Schölzel
keywords:
    - python
    - semester-1
    - bioinformatics
lang: de-DE
solution-size: 30
---

# DNA to Protein

Schreiben Sie eine eine Funktion `translate_to_prot(x)` in der Datei `dna_to_protein.py`, die die  Proteinsequenz zur übergebenen DNA-Sequenz x baut.

Beispiel:

```python
result = translate_to_prot("ATGGAAGTATTTAAAGCGCCACCTATTGGGATATAAG")
print(result) # MEVFKAPPIGI
```


* Teste deine Funktion mit `ATGGAAGTATTTAAAGCGCCACCTATTGGGATATAAG` und speichere das Ergebnis in einer Variable `result`.

> Wichtig: Hören Sie bei der Übersetzung zu einem `STOP`-Zeichen auf und geben Sie das bisherige Ergebnis zurück



```python
# Um es etwas leichter zu machen, wird die Codesonne in Form eines Dictionarys gegeben
# Sie können die Werte unten in ihr Programm kopieren.
# Code-Sonne von Wikipedia: https://de.wikipedia.org/wiki/Code-Sonne#/media/Datei:Aminoacids_table.svg

protein = {"TTT" : "F", "CTT" : "L", "ATT" : "I", "GTT" : "V",
           "TTC" : "F", "CTC" : "L", "ATC" : "I", "GTC" : "V",
           "TTA" : "L", "CTA" : "L", "ATA" : "I", "GTA" : "V",
           "TTG" : "L", "CTG" : "L", "ATG" : "M", "GTG" : "V",
           "TCT" : "S", "CCT" : "P", "ACT" : "T", "GCT" : "A",
           "TCC" : "S", "CCC" : "P", "ACC" : "T", "GCC" : "A",
           "TCA" : "S", "CCA" : "P", "ACA" : "T", "GCA" : "A",
           "TCG" : "S", "CCG" : "P", "ACG" : "T", "GCG" : "A",
           "TAT" : "Y", "CAT" : "H", "AAT" : "N", "GAT" : "D",
           "TAC" : "Y", "CAC" : "H", "AAC" : "N", "GAC" : "D",
           "TAA" : "STOP", "CAA" : "Q", "AAA" : "K", "GAA" : "E",
           "TAG" : "STOP", "CAG" : "Q", "AAG" : "K", "GAG" : "E",
           "TGT" : "C", "CGT" : "R", "AGT" : "S", "GGT" : "G",
           "TGC" : "C", "CGC" : "R", "AGC" : "S", "GGC" : "G",
           "TGA" : "STOP", "CGA" : "R", "AGA" : "R", "GGA" : "G",
           "TGG" : "W", "CGG" : "R", "AGG" : "R", "GGG" : "G"
           }

```
