import unittest

from factorial import factorial

class TestFactorial(unittest.TestCase):
    
    def testFactorialPositive(self):
        result = factorial(5)
        self.assertEqual(120, result)

    def testFactorialZero(self):
        result = factorial(0)
        self.assertEqual(1, result)

    def testFactorialNegative(self):
        result = factorial(-5)
        self.assertEqual(-1, result)

    def testFactorialLargeNumber(self):
        result = factorial(10)
        self.assertEqual(3628800, result)

if __name__ == '__main__':
    unittest.main()