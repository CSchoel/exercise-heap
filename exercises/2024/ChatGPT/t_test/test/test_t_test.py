import unittest
import math

from t_test import t_test


class TestTTest(unittest.TestCase):

    def test_t_test(self):
        sample1 = [1, 2, 3, 4, 5]
        sample2 = [2, 3, 4, 5, 6]
        t_statistic, p_value = t_test(sample1, sample2)
        self.assertAlmostEqual(t_statistic, -1)
        self.assertAlmostEqual(p_value, 0.3465935070873343)

    def test_t_test_empty_samples(self):
        sample1 = []
        sample2 = []
        t_statistic, p_value = t_test(sample1, sample2)
        self.assertTrue(math.isnan(t_statistic))
        self.assertTrue(math.isnan(p_value))

    def test_t_test_same_samples(self):
        sample1 = [1, 2, 3, 4, 5]
        sample2 = [1, 2, 3, 4, 5]
        t_statistic, p_value = t_test(sample1, sample2)
        self.assertAlmostEqual(t_statistic, 0)
        self.assertAlmostEqual(p_value, 1)


if __name__ == "__main__":
    unittest.main()
