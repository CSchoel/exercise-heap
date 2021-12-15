import unittest

import bubblesort

class FibonacciTest(unittest.TestCase):

    def testSome(self):
        arr = [5, 4, 3, 2, 1]
        bubblesort.bubblesort(arr)
        self.assertEqual([1, 2, 3, 4, 5], arr)
if __name__ == '__main__':
    unittest.main()
