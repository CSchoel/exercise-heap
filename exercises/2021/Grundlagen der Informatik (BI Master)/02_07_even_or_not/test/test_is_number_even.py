import unittest

import sys
from io import StringIO

sys.stdin = StringIO("434\n")


import is_even as ev

class IsEvenNumberTest(unittest.TestCase):

    def testSome(self):
        self.assertEqual(True, ev.result)

if __name__ == '__main__':
    unittest.main()
