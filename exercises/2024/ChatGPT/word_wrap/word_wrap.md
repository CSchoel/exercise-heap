---
title: Word Wrap
author:
- ChatGPT
- Christopher Schölzel
keywords:
- language: python
- course: Introduction to Python for computational linguists
lang: en-US
solution-size: 7  # measured in lines of code
id: e5ad5b7d-aa1b-4a2b-b9f3-75f897cf6d09
---

# Word Wrap

Implement a function `word_wrap(text: str, columns: int) -> List[str]` in `word_wrap.py` which takes a long string `text` and wraps it to fit within a given number of `columns` without breaking words. 

Example:

```python
result = word_wrap("Lorem ipsum dolor sit amet, consectetur adipiscing elit.", 20)
print(result)
# Output:
# ['Lorem ipsum dolor', 'sit amet,', 'consectetur', 'adipiscing elit.']

result = word_wrap("This is a short text.", 10)
print(result)
# Output:
# ['This is a', 'short text.']
```

> Tip: You may need to use the `textwrap` module.

Make sure to save the function in a file called `word_wrap.py` so that it can be imported with `from word_wrap import word_wrap`.
