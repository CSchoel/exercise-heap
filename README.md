# Exercise Heap

This repository contains a collection of programming exercises that were created by myself, my tutors, colleagues, and friends.
I and/or the original authors release this work to the public domain ([CC0](https://creativecommons.org/share-your-work/public-domain/cc0/)).
I will keep all texts regarding the organization of this repository in English, so that this repository is as useful to international users as possible.
The exercise texts, however, will be mainly in German, since I teach at German universities.

## Structure of the heap

I choose the word "heap" for this project, because like heap memory in Java or other programming languages it represents a rather unstructured data storage, that nonetheless can be used efficiently with the right tools and links.
Since I think any organization approach based on a single hierarchy that could be mapped to the file system is doomed to fail anyway, I simply use the year in which the exercise was first created as the folder structure.
This at least allows me to quickly find newer exercises and prevents folders from growing unboundedly.
The actual *semantic* organization then is done by adding tags/keywords to the individual exercises.

## Structure of an exercise

My goal with the exercise heap is to allow as many people as possible to easily incorporate the exercises into their workflow.
Therefore, I choose Markdown as the smallest common denominator of text formats and try to make the conversion into different formats using [Pandoc](https://pandoc.org/) as easy as possible.

Consequently, exercise descriptions are just a Markdown file which is placed in a folder that can but is not required to have the following subfolders:

* `test` contains unit tests for automatic assessment of student solutions.
* `res` contains resources required for solving the exercise such as files that have to be read.
* `sol` contains sample solutions.

The Markdown file containing the exercise description should start with a YAML-Header containing [Pandoc-compliant metadata](https://pandoc.org/MANUAL.html#metadata-variables) as follows:

```YAML
---
title: The title of the exercise
author:
    - First Author
    - Second Author
keywords:
    - first tag
    - second tag
lang: en-US
solution-size: 17 # lines of code / number of sentences / ...
---
```

## Tags

I plan on using tags for almost any semantic information that further identifies the exercise:

* Exercise context (exam, graded homework, learning material)
* Exercise subject (loops, if-expressions, sorting algorithms, ...)
* Required preexisting knowledge (loops, if-expressions, sorting algorithms, ...)
* Programming language (python, java, ...)
* Name of course (Grundlagen der Informatik, Algorithmen und Datenstrukturen)
* ...