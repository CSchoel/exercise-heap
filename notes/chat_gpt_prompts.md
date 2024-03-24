# ChatGPT prompts for exercise generation

## Base prompt

You are a teacher of a introductory Python course for computational linguists. You use type hinting and Python features up to Python 3.8. Since the course is quite large, you use an automatic grading system using unit tests with the `unittest` module.

Please write a programming exercise for your students. Be precise in the wording. The programming exercise should take no more than 1 h to complete. Students should write a function that is then tested with a unit test. Please also provide the code for the unit test.

For your answer, please use the same structure as the following example delimited by <exercise> and </exercise>:

<exercise>
<description>
---
title: Batchify
author:
- ChatGPT
- Christopher Schölzel
keywords:
- language: python
- course: Introduction to Python for computational linguists
lang: en-US
solution-size: 8  # measured in lines of code
id: 5111a717-e313-49b5-b95f-8bec5a07e30e
---

# Batchify 

Implement a function `batchify(input: str, batchSize: int) -> List[str]` in `batchify.py` which gets a string as input, as well as a number `batchSize`. This function should split the `input` into chunks of `batchSize` characters length.

Example:

```python
result = batchify("ABCDEFGH",4)
print(result) # -> ['ABCD','EFGH']

result = batchify("ABCDEFGH",3)
print(result) # -> ['ABC', 'DEF', 'GH']
```


> Tip: Use the slicing operator.

Make sure to save the function in a file called `batchify.py` so that it can be imported with `from batchify import batchify`.

</description>
<unittest>

```python
import unittest

from batchify import batchify

class TestSplitting(unittest.TestCase):
    
    def testBatch4(self):
        input = "Hallo Welt!"
        result = batchify(input, 4)
        self.assertEqual(["Hall", "o We", "lt!"], result)

    def testBatch2(self):
        input = "Hallo Welt!"
        result = batchify(input, 2)
        self.assertEqual(["Ha","ll", "o ", "We", "lt", "!"], result)

if __name__ == '__main__':
    unittest.main()
```

</unittest>
<example_solution>

```python
from typing import List

def batchify(input: str, batchSize: int) -> List[str]:
	batches = []
	for i in range(0, len(input), batchSize):
		batches.append(input[i: i + batchSize])
	return batches
```
</example_solution>
</exercise>

Please answer with the same structure as above for the following type of exercise: Calculate Mode: Create a function to determine the mode of a list of numbers.

If there is a function in the Python standard library that makes this task trivial, add a hint that this function should not be used. Ensure that the unit tests cover edge cases and a diverse range of inputs.

## Variants of final Paragraph

* Please answer with the same structure as above but choose a different exercise.
* Please answer with the same structure as above but choose a different exercise.
    The exercise should be more complex than the example.
* Please answer with the same structure as above for the following type of exercise: Pig Latin translation: Write a function that translates a given sentence into Pig Latin.

## Prompts for exercise ideas

Please give me examples of programming exercises for an introductory Python course for computational linguists. The exercises should require to write a single function or class. Please list 10 easy, 10 medium, and 10 hard examples. Just write one sentence per example that gives a general idea what the exercise should be about. The exercises should only require to use the Python standard library and take no more than one hour.

---

Can you give me examples of good exercises for an introductory Python course for data analysis and statistics? Let's start with simple exercises that only use the Python standard library. Give me 20 different exercises, only describing the main idea with a single sentence.

Please give me 20 more comples examples, involving libaries like numpy and pandas and having more specific problems that are closer to real-world applications. Focus more on data analysis than on statistics and make at least half the exercises about string-based data.

---