import unittest

import fibonacci

class FibonacciTest(unittest.TestCase):

    def testSome(self):
        self.assertEqual(5, fibonacci.fib(5))
if __name__ == '__main__':
    unittest.main()
