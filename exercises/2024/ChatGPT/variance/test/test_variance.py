import unittest
import math

from variance import calculate_variance


class TestVarianceCalculation(unittest.TestCase):

    def test_basic_variance(self):
        data = [1, 2, 3, 4, 5]
        result = calculate_variance(data)
        self.assertAlmostEqual(result, 2.5)

    def test_negative_values(self):
        data = [-1, -2, -3, -4, -5]
        result = calculate_variance(data)
        self.assertAlmostEqual(result, 2.5)

    def test_mixed_values(self):
        data = [-2, -1, 0, 1, 2]
        result = calculate_variance(data)
        self.assertAlmostEqual(result, 2.5)

    def test_single_value(self):
        data = [42]
        result = calculate_variance(data)
        self.assertEqual(result, float("inf"))

    def test_empty_list(self):
        data = []
        result = calculate_variance(data)
        self.assertTrue(math.isnan(result))

    def test_large_dataset(self):
        data = list(range(1, 1001))
        result = calculate_variance(data)
        self.assertAlmostEqual(result, 83416.66666666667, places=2)


if __name__ == "__main__":
    unittest.main()
