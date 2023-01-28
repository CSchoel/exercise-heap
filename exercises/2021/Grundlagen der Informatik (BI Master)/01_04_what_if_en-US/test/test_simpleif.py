import unittest

import simple_if
import importlib
import random


class FibonacciTest(unittest.TestCase):

    def testSmaller(self):
        random.seed(0)
        importlib.reload(simple_if)
        self.assertEqual(198 * 400, simple_if.result)

    def testGreater(self):
        random.seed(333)
        importlib.reload(simple_if)
        self.assertEqual(242 * 100, simple_if.result)

if __name__ == '__main__':
    unittest.main()
