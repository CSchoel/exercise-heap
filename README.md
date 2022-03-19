# Exercise Heap

This repository contains a collection of programming exercises that were created by myself, my tutors, colleagues, and friends.
I and/or the original authors release this work to the public domain ([CC0](https://creativecommons.org/share-your-work/public-domain/cc0/)).
I will keep all texts regarding the organization of this repository in English, so that this repository is as useful to international users as possible.
The exercise texts, however, will be mainly in German, since I teach at German universities.

## Structure of the heap

I choose the word "heap" for this project, because like heap memory in Java or other programming languages it represents a rather unstructured data storage, that nonetheless can be used efficiently with the right tools and links.
Since I think any organization approach based on a single hierarchy that could be mapped to the file system is doomed to fail anyway, I simply use the year in which the exercise was first created and the course or project from which they originate as the folder structure.
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
    - category: value
    - category: value
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
* Name of institution (Technische Hochschule Mittelhessen, Justus-Liebig-Universität)
* ...

They should be treated as [semantic triples](https://en.wikipedia.org/wiki/Semantic_triple) with the exercise as the subject, the category as the verb and the value as the object.

### Links to other exercises

If an exercise requires the solution of a different exercise or is derived from another exercise in the heap, these references should be represented as tags.
In order to do so while keeping the exercises as self-contained as possible, [UUIDs](https://en.wikipedia.org/wiki/Universally_unique_identifier) are used:
Each exercise has a UUID and links between exercises might look as follows:

```yaml
id: cc88c944-cc85-4a7f-80c9-16b4f3a122e4
keywords:
    derived-from: 24601e04-a0c3-41a4-adbd-74da90765ac2
    previous: 63e81a6e-8616-4d5a-8440-e647e55c8523
    next: dd3e4ff2-fa89-4365-8e8c-8d6595d7fb80
    references: 92d4383f-5e4a-42b9-a1ed-4d2fe7098ef7
    requires-solution: 6ca78dd4-48ec-4894-8924-3a7970833105
```

## General notes

### Source code

Source code for tests and solutions should be self-contained.
If it depends on other code that cannot be simply installed as a package, this code has to be copied to the exercise folder.
Note that this can be a major pain in the ass, if you have a folder for common code but need to determine which exercise needs which file from this folder.

## Contributing

If you would like to add one of your exercises to the heap, you can do this with the help of Porty, the friendly import bot.
Just open an issue with the exercise name as the title and the exercise text as the issue body formatted in the usual GitHub markdown style.
You can then add the keyword `#import` either directly in the issue body or in a separate comment and Porty will automatically try to import your exercise into the heap and also suggest a few tags to add.
