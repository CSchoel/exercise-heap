import unittest

from histogram import calculate_histogram


class TestHistogram(unittest.TestCase):

    def test_regular_buckets(self):
        data = [1.2, 3.4, 5.6, 7.8, 9.0, 11.1, 13.3]
        result = calculate_histogram(data, 3)
        self.assertEqual(([0, 3, 6, 9, 12], [1, 2, 1, 2, 1]), result)

    def test_irregular_buckets(self):
        data = [1.2, 3.4, 5.6, 7.8, 9.0, 11.1, 13.3]
        result = calculate_histogram(data, 2.5)
        self.assertEqual(([0.0, 2.5, 5.0, 7.5, 10.0, 12.5], [1, 1, 1, 2, 1, 1]), result)

    def test_empty_data(self):
        data = []
        result = calculate_histogram(data, 1)
        self.assertEqual(([0.0], [0]), result)

    def test_single_value(self):
        data = [5.5]
        result = calculate_histogram(data, 2)
        self.assertEqual(([4], [1]), result)

    def test_negative_values(self):
        data = [-2, -1, 0, 1, 2]
        result = calculate_histogram(data, 1)
        self.assertEqual(([-2.0, -1.0, 0.0, 1.0, 2.0], [1, 1, 1, 1, 1]), result)


if __name__ == "__main__":
    unittest.main()
