import unittest
import math

from z_score import ZScoreCalculator


class TestZScoreCalculator(unittest.TestCase):

    def testZScoreCalculator(self):
        calculator = ZScoreCalculator([10, 20, 30, 40, 50])
        self.assertAlmostEqual(0.0, calculator.calculate_z_score(30), places=5)
        self.assertAlmostEqual(
            1.7677669529663687, calculator.calculate_z_score(55), places=5
        )
        self.assertAlmostEqual(
            -1.7677669529663687, calculator.calculate_z_score(5), places=5
        )

    def testZScoreCalculatorEmpty(self):
        calculator = ZScoreCalculator([])
        self.assertTrue(math.isnan(calculator.calculate_z_score(10)))

    def testZScoreCalculatorSingleElement(self):
        calculator = ZScoreCalculator([5])
        self.assertEqual(0, calculator.calculate_z_score(5))

    def testZScoreCalculatorRepeatedValues(self):
        calculator = ZScoreCalculator([5, 5, 5, 5, 5])
        self.assertEqual(0, calculator.calculate_z_score(5))


if __name__ == "__main__":
    unittest.main()
