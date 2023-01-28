import unittest

import fibonacci_iterative as fibit

class FibonacciTest(unittest.TestCase):

    def testSome(self):
        self.assertEqual(5, fibit.fibonacci_iterative(5))
if __name__ == '__main__':
    unittest.main()
