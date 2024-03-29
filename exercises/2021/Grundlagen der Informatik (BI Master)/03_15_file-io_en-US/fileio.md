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
- translated-from: fcac20f9-7d14-4209-9e82-e8d5dcbce320
lang: en-US
solution-size: 10
id: beb280e8-075b-49ee-ad58-f65bdfcf56cb

---
# File I/O

Write a `read_file` function in the `read_fasta.py` file that reads the file: `uniprot_small.fasta`.
Return all IDs (see below) in a list.

The Fasta file is structured as follows: 

* At ">" the line begins with the ID, which stands between the  |...|, after that there are informations about the sequence and in the next line the sequence itself.


```
>sp|Q6GZW9|006R_FRG3G Uncharacterized protein 006R OS=Frog virus 3 (isolate Goorha) GN=FV3-006R PE=4 SV=1
MYKMYFLKDQKFSLSGTIRINDKTQSEYGSVWCPGLSITGLHHDAIDHNMFEEMETEIIE
YLGPWVQAEYRRIKG
```

> Tip: You can find the file for this task at `dozeloc/03_15_file-io_en-US/test/uniprot_small.fasta`
