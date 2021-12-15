import unittest

import max_by_len

class MaxByLenTest(unittest.TestCase):

    def testWordlist(self):
        words = ["foo", "ab", "bar", "foobar", "a"]
        self.assertEqual("foobar", max_by_len.max_by_len(words))

if __name__ == '__main__':
    unittest.main()