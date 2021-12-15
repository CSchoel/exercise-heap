import unittest

import faked_statistics as fs

class FakeStest(unittest.TestCase):

    def testSome(self):
        self.assertEqual([0.61, 0.75, 1.0, 0.86, 0.77, 0.73, 0.99, 1.0, 1.0, 0.88, 0.9, 0.67], fs.noten)
if __name__ == '__main__':
    unittest.main()
