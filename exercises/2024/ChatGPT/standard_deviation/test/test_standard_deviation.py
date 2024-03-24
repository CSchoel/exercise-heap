import unittest
import math

from standard_deviation import compute_standard_deviation

class TestStandardDeviation(unittest.TestCase):
    
    def test_standard_deviation(self):
        data = [2.0, 4.0, 4.0, 4.0, 5.0, 5.0, 7.0, 9.0]
        result = compute_standard_deviation(data)
        self.assertAlmostEqual(result, 2.138, places=3)

    def test_standard_deviation_empty(self):
        data = []
        result = compute_standard_deviation(data)
        self.assertTrue(math.isnan(result))

    def test_standard_deviation_single_value(self):
        data = [5.0]
        result = compute_standard_deviation(data)
        self.assertEqual(result, 0.0)

    def test_standard_deviation_negative_values(self):
        data = [-2.0, -4.0, -4.0, -4.0, -5.0, -5.0, -7.0, -9.0]
        result = compute_standard_deviation(data)
        self.assertAlmostEqual(result, 2.138, places=3)

if __name__ == '__main__':
    unittest.main()