import unittest
import math

from correlation import correlation_coefficient


class TestCorrelationCoefficient(unittest.TestCase):

    def test_perfect_positive_correlation(self):
        X = [1, 2, 3, 4, 5]
        Y = [2, 4, 6, 8, 10]
        result = correlation_coefficient(X, Y)
        self.assertAlmostEqual(result, 1.0)

    def test_perfect_negative_correlation(self):
        X = [5, 4, 3, 2, 1]
        Y = [2, 4, 6, 8, 10]
        result = correlation_coefficient(X, Y)
        self.assertAlmostEqual(result, -1.0)

    def test_no_correlation(self):
        X = [1, 2, 3, 4, 5]
        Y = [-1, 0, 1, 0, -1]
        result = correlation_coefficient(X, Y)
        self.assertAlmostEqual(result, 0.0)

    def test_mixed_correlation(self):
        X = [1, 2, 3, 4, 5]
        Y = [2, 4, 7, 8, 11]
        result = correlation_coefficient(X, Y)
        self.assertAlmostEqual(result, 0.9918365981341756)

    def test_empty_lists(self):
        X = []
        Y = []
        result = correlation_coefficient(X, Y)
        print("Test: " + str(result))
        self.assertTrue(math.isnan(result))

    def test_different_lengths(self):
        X = [1, 2, 3]
        Y = [2, 4, 6, 8]
        with self.assertRaises(ValueError):
            correlation_coefficient(X, Y)


if __name__ == "__main__":
    unittest.main()
