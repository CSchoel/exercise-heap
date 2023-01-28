import unittest

import divisor_sum as ds

class DivisorSumTest(unittest.TestCase):

    def testDivisorSum8128(self):
        self.assertEqual(8128, ds.result)

if __name__ == '__main__':
    unittest.main()
