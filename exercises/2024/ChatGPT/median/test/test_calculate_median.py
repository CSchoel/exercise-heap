import unittest
import math
from calculate_median import calculate_median


class TestCalculateMedian(unittest.TestCase):

    def testOddLength(self):
        numbers = [1, 2, 3, 4, 5]
        result = calculate_median(numbers)
        self.assertEqual(3, result)

    def testEvenLength(self):
        numbers = [1, 2, 3, 4, 5, 6]
        result = calculate_median(numbers)
        self.assertEqual(3.5, result)

    def testEmptyList(self):
        numbers = []
        result = calculate_median(numbers)
        self.assertTrue(math.isnan(result))

    def testSingleElement(self):
        numbers = [5]
        result = calculate_median(numbers)
        self.assertEqual(5, result)

    def testNegativeNumbers(self):
        numbers = [-3, -5, -1, -10, -7]
        result = calculate_median(numbers)
        self.assertEqual(-5, result)

    def testDuplicateValues(self):
        numbers = [2, 2, 3, 3, 4, 4]
        result = calculate_median(numbers)
        self.assertEqual(3, result)


if __name__ == "__main__":
    unittest.main()
