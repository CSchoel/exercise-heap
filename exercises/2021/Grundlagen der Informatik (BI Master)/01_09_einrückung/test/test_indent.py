import unittest

import sys
import io
import re
import importlib

sys.stdin = io.StringIO("5")
import indent

def reload_with_io(stdin, module):
    sys.stdin = io.StringIO(stdin)
    res = io.StringIO()
    sys.stdout = res
    importlib.reload(module)
    return res.getvalue()


class IndentTest(unittest.TestCase):

    def assertEndsWith(self, suffix, text):
        self.assertEqual(text[-len(suffix):], suffix)

    def test_positive(self):
        res = reload_with_io("5", indent)
        self.assertEqual(5, indent.indent)
        self.assertEndsWith("     eingerückt\n", res)

    def test_zero(self):
        res = reload_with_io("0", indent)
        self.assertEqual(0, indent.indent)
        self.assertEndsWith("eingerückt\n", res)

    def test_negative(self):
        res = reload_with_io("-5", indent)
        self.assertEqual(-5, indent.indent)
        self.assertEndsWith("Die Zahl muss positiv sein!\n", res)

if __name__ == '__main__':
    unittest.main()
