import unittest

import sys
import io
import re

sys.stdin = io.StringIO("Ei Morsche\nDu Babbsack\n")
res = io.StringIO()
sys.stdout = res
import greetings

class GreetingTest(unittest.TestCase):

    def test_greeting(self):
        self.assertEqual("Ei Morsche", greetings.greeting)
    
    def test_name(self):
        self.assertEqual("Du Babbsack", greetings.name)

    def test_output(self):
        exp = r".*{}[,. \t]*{}.*".format(greetings.greeting, greetings.name)
        self.assertRegex(res.getvalue(), exp)

if __name__ == '__main__':
    unittest.main()
