import unittest

import hello_world

class FibonacciTest(unittest.TestCase):

    def testSome(self):
        self.assertEqual("Hello World!", hello_world.hello)
if __name__ == '__main__':
    unittest.main()
