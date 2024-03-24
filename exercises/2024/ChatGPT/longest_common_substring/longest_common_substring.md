---
title: Longest Common Substring
author:
- ChatGPT
- Christopher Schölzel
keywords:
- language: python
- course: Introduction to Python for computational linguists
lang: en-US
solution-size: 12  # measured in lines of code
id: 3bc81529-7a87-400a-82b1-2864b772ca3f
---

# Longest Common Substring 

Implement a function `longest_common_substring(str1: str, str2: str) -> str` in `longest_common_substring.py` which takes two strings as input and returns the longest common substring between them.

Example:

```python
result = longest_common_substring("abcdefg", "xyzabcdeftuvw")
print(result) # -> 'abcde'

result = longest_common_substring("aaa", "aaab")
print(result) # -> 'aaa'
```

> Hint: You can solve this problem efficiently using dynamic programming. Avoid using functions from the Python standard library that directly solve this problem.

Make sure to save the function in a file called `longest_common_substring.py` so that it can be imported with `from longest_common_substring import longest_common_substring`.
