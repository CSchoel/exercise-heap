import unittest
import math

from calculate_mean import calculate_mean

class TestMeanCalculation(unittest.TestCase):
    
    def testMeanOfIntegers(self):
        input = [1, 2, 3, 4, 5]
        result = calculate_mean(input)
        self.assertAlmostEqual(3.0, result)

    def testMeanOfZero(self):
        input = [0]
        result = calculate_mean(input)
        self.assertAlmostEqual(0.0, result)

    def testMeanOfEmptyList(self):
        input = []
        result = calculate_mean(input)
        self.assertTrue(math.isnan(result))

    def testMeanOfFractionalNumbers(self):
        input = [0.5, 1.5, 2.5, 3.5, 4.5]
        result = calculate_mean(input)
        self.assertAlmostEqual(2.5, result)

    def testMeanOfNegativeNumbers(self):
        input = [-1, -2, -3, -4, -5]
        result = calculate_mean(input)
        self.assertAlmostEqual(-3.0, result)

    def testMeanOfMixedNumbers(self):
        input = [-1, 2, -3, 4, -5]
        result = calculate_mean(input)
        self.assertAlmostEqual(-0.6, result)

if __name__ == '__main__':
    unittest.main()