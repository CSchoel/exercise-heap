---
title: DNA to Protein
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
- translated-from: 8e38392c-2669-45ec-b2a6-93750759e45a
lang: en-US
solution-size: 30
id: 14fabfc9-ae02-4c16-9a6f-dcbcd809a30a

---
# DNA to protein

Write a `translate_to_prot(x)' function in the `dna_to_protein.py' file that builds the protein sequence for the passed DNA sequence x.

Example:

```python
result = translate_to_prot("ATGGAAGTATTTAAAGCGCCACTATTGGGATAAG")
print(result) # MEVFKAPPIGI
```


* Test your function with `ATGGAAGTATTTAAAGCGCCACCTATTGGGATATAAG` and save the result in a variable `result`.

> Important: When translating, stop using a `STOP` character and return the previous result



```python
# To make it a little easier, the code sun is given in the form of a dictionary
# You can copy the values below into your program.
* Code sun from Wikipedia: https://en.wikipedia.org/wiki/Code sun#/media/File:Aminoacids_table.svg

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
           "TGG" : "W", "CG" : "R", "AGG" : "R", "GG" : "G"
           }

```
