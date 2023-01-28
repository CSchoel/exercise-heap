import unittest
import my_map as mm

class mmapTest(unittest.TestCase):
    def testSome(self):
        self.assertEqual([42, 84, 126], mm.result)

if __name__ == '__main__':
    unittest.main()

