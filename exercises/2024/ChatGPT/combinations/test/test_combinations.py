import unittest

from combinations import calculate_combinations


class TestCombinations(unittest.TestCase):

    def testBasic(self):
        result = calculate_combinations(5, 2)
        self.assertEqual(10, result)

    def testLargerNumbers(self):
        result = calculate_combinations(10, 3)
        self.assertEqual(120, result)

    def testEdgeCase(self):
        result = calculate_combinations(0, 0)
        self.assertEqual(1, result)

    def testLargerEdgeCase(self):
        result = calculate_combinations(100, 50)
        self.assertEqual(100891344545564193334812497256, result)


if __name__ == "__main__":
    unittest.main()
