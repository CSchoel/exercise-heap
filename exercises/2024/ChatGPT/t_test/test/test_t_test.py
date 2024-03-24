import unittest

from t_test import t_test

class TestTTest(unittest.TestCase):
    
    def test_t_test(self):
        sample1 = [1, 2, 3, 4, 5]
        sample2 = [2, 3, 4, 5, 6]
        t_statistic, p_value = t_test(sample1, sample2)
        self.assertAlmostEqual(t_statistic, -0.7071067811865475)
        self.assertAlmostEqual(p_value, 0.5131083916747507)

    def test_t_test_empty_samples(self):
        sample1 = []
        sample2 = []
        t_statistic, p_value = t_test(sample1, sample2)
        self.assertTrue(t_statistic == 0.0 and p_value == 0.0)

    def test_t_test_different_lengths(self):
        sample1 = [1, 2, 3, 4, 5]
        sample2 = [2, 3, 4, 5, 6, 7]
        t_statistic, p_value = t_test(sample1, sample2)
        self.assertTrue(t_statistic == 0.0 and p_value == 0.0)

    def test_t_test_same_samples(self):
        sample1 = [1, 2, 3, 4, 5]
        sample2 = [1, 2, 3, 4, 5]
        t_statistic, p_value = t_test(sample1, sample2)
        self.assertTrue(t_statistic == 0.0 and p_value == 1.0)

if __name__ == '__main__':
    unittest.main()