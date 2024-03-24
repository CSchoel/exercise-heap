import unittest

from linear_regression import linear_regression

class TestLinearRegression(unittest.TestCase):
    
    def test_basic_regression(self):
        X = [0, 1, 2, 3, 4, 5]
        Y = [0, 1, 2, 3, 4, 5]
        slope, intercept = linear_regression(X, Y)
        self.assertAlmostEqual(slope, 1.0)
        self.assertAlmostEqual(intercept, 0.0)

    def test_horizontal_line(self):
        X = [0, 1, 2, 3, 4, 5]
        Y = [3, 3, 3, 3, 3, 3]
        slope, intercept = linear_regression(X, Y)
        self.assertAlmostEqual(slope, 0.0)
        self.assertAlmostEqual(intercept, 3.0)

    def test_vertical_line(self):
        X = [2, 2, 2, 2, 2]
        Y = [0, 1, 2, 3, 4]
        slope, intercept = linear_regression(X, Y)
        self.assertAlmostEqual(slope, float('inf'))
        self.assertAlmostEqual(intercept, float('nan'))

if __name__ == '__main__':
    unittest.main()