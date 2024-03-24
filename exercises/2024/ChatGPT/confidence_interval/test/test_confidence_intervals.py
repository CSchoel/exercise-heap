import unittest
from confidence_intervals import calculate_confidence_interval

class TestConfidenceIntervals(unittest.TestCase):

    def test_confidence_interval(self):
        data = [3.4, 2.7, 4.1, 3.9, 2.8, 3.5, 3.7]
        confidence_level = 0.95
        result = calculate_confidence_interval(data, confidence_level)
        self.assertAlmostEqual(result[0], 3.033, delta=0.001)
        self.assertAlmostEqual(result[1], 3.767, delta=0.001)

    def test_low_sample_size(self):
        data = [3.4, 2.7]
        confidence_level = 0.90
        result = calculate_confidence_interval(data, confidence_level)
        self.assertAlmostEqual(result[0], 2.486, delta=0.001)
        self.assertAlmostEqual(result[1], 3.613, delta=0.001)

    def test_high_confidence_level(self):
        data = [3.4, 2.7, 4.1, 3.9, 2.8, 3.5, 3.7]
        confidence_level = 0.99
        result = calculate_confidence_interval(data, confidence_level)
        self.assertAlmostEqual(result[0], 2.840, delta=0.001)
        self.assertAlmostEqual(result[1], 3.960, delta=0.001)

if __name__ == '__main__':
    unittest.main()