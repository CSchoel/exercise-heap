import unittest
import sublist as s

class SublistTest(unittest.TestCase):
    def testSome(self):
        self.assertEqual([376, 205, 407, 238, 450, 426, 391], s.result)

if __name__ == '__main__':
    unittest.main()