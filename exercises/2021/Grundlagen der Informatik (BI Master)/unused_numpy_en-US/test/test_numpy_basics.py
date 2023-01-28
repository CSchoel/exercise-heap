import unittest
import numpy_basics as nb



class npbTest(unittest.TestCase):

    def testSome(self):
        a, b = nb.create_arrays()
        self.assertListEqual([1, 2, 3], a)
        self.assertListEqual([4, 5, 6], b)
        self.assertListEqual([-3, 6, -3], nb.crossp(a, b))
        self.assertAlmostEqual(5.196152422706632, nb.dist(a, b))

if __name__ == '__main__':
    unittest.main()
