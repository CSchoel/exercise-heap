import unittest

import age
import importlib
import random

class FibonacciTest(unittest.TestCase):

    def testTooYoung(self):
        random.seed(2)
        importlib.reload(age)
        self.assertFalse(age.result)

    def testInBetween(self):
        random.seed(0)
        importlib.reload(age)
        self.assertTrue(age.result)

    def testTooOld(self):
        random.seed(20)
        importlib.reload(age)
        self.assertFalse(age.result)

if __name__ == '__main__':
    unittest.main()
