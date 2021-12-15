import unittest
import prime_comprehension as pc

class pcTest(unittest.TestCase):
    def testSome(self):
        self.assertEqual([2, 3, 5, 7, 11, 13, 17, 19], pc.result)

if __name__ == '__main__':
    unittest.main()

