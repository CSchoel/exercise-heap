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
- translated-from: 685cd658-689d-4ecb-b440-a5366be3db24
lang: en-US
solution-size: 8
id: 5111a717-e313-49b5-b95f-8bec5a07e30e

---
# Splitting 

Implement a function `splitting(input: str, batchSize: int) -> List[str]` in `splitting.py` which gets a string as input, as well as a number `batchSize`. This function should return a list in which the input is split according to `batchSize` characters. 

Example:

```python
	result = splitting("ABCDEFGH",4)
    print(result) # -> ['ABCD','EFGH']

    result = splitting("ABCDEFGH",3)
    print(result) # -> ['ABC', 'DEF', 'GH']
```


> Tip: Use the already known splicing operator.

> You can reuse this feature in future tasks:\
> Make sure that the file is in the same folder as the new task and use `import splitting`.
> You can then access it with `splitting.splitting("ABCDEF", 9)".