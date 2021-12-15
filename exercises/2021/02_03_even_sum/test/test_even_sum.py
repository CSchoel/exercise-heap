import unittest

import even_sum as es

class EvenSumTest(unittest.TestCase):

    def testEvenSum100(self):
        self.assertEqual(2550, es.result)

if __name__ == '__main__':
    unittest.main()
