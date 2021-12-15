import unittest

import smean as s

class SmeanTest(unittest.TestCase):

    def testSome(self):
        self.assertEqual(571.9166666666666, s.result)
if __name__ == '__main__':
    unittest.main()
