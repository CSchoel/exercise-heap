import unittest

from calculate_mode import calculate_mode


class TestCalculateMode(unittest.TestCase):

    def testSingleMode(self):
        numbers = [1, 2, 3, 4, 4, 5, 5, 6]
        result = calculate_mode(numbers)
        self.assertEqual([4, 5], result)

    def testNoMode(self):
        numbers = [1, 2, 3, 4, 5, 6]
        result = calculate_mode(numbers)
        self.assertEqual([1, 2, 3, 4, 5, 6], result)

    def testMultipleModes(self):
        numbers = [1, 2, 2, 3, 4, 5, 5, 6, 6]
        result = calculate_mode(numbers)
        self.assertEqual([2, 5, 6], result)

    def testEmptyList(self):
        numbers = []
        result = calculate_mode(numbers)
        self.assertEqual([], result)

    def testAllSameNumber(self):
        numbers = [1, 1, 1, 1, 1]
        result = calculate_mode(numbers)
        self.assertEqual([1], result)


if __name__ == "__main__":
    unittest.main()
