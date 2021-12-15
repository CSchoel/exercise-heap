import unittest
import merge_lists as ml

class MergeListTest(unittest.TestCase):
    def testSome(self):
        self.assertEqual([4, 3, 50, 100, 3, 44, 120, 948, 84, 31], ml.result)

if __name__ == '__main__':
    unittest.main()

