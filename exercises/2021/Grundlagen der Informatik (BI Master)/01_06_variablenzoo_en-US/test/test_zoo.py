import unittest

import zoo

class ZooTest(unittest.TestCase):

    def test_a(self):
        self.assertIsInstance(zoo.a, int)

    def test_b(self):
        self.assertIsInstance(zoo.b, float)

    def test_c(self):
        self.assertIsInstance(zoo.c, str)

    def test_d(self):
        self.assertIsInstance(zoo.d, bool)

    def test_e(self):
        self.assertIsNone(zoo.e)

if __name__ == '__main__':
    unittest.main()
