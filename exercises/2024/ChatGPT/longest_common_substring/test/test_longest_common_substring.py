import unittest

from longest_common_substring import longest_common_substring


class TestLongestCommonSubstring(unittest.TestCase):

    def testExample1(self):
        result = longest_common_substring("abcdefg", "xyzabcdeftuvw")
        self.assertEqual("abcdef", result)

    def testExample2(self):
        result = longest_common_substring("aaa", "aaab")
        self.assertEqual("aaa", result)

    def testEmptyStrings(self):
        result = longest_common_substring("", "")
        self.assertEqual("", result)

    def testNoCommonSubstring(self):
        result = longest_common_substring("abcdefg", "xyz")
        self.assertEqual("", result)

    def testSameString(self):
        result = longest_common_substring("abc", "abc")
        self.assertEqual("abc", result)

    def testSubstringAtEnd(self):
        result = longest_common_substring("abcdefg", "xyzdefg")
        self.assertEqual("defg", result)

    def testSubstringAtBeginning(self):
        result = longest_common_substring("abcdefg", "abcdefgx")
        self.assertEqual("abcdefg", result)

    def testLongStrings(self):
        result = longest_common_substring(
            "x" * 1000 + "abc" + "y" * 1000, "z" * 500 + "abc" + "w" * 500
        )
        self.assertEqual("abc", result)


if __name__ == "__main__":
    unittest.main()
