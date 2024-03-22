import unittest

from vowel_counter import count_vowels

class TestCountVowels(unittest.TestCase):
    
    def testNoVowels(self):
        input = "rhythm"
        result = count_vowels(input)
        self.assertEqual(0, result)

    def testAllVowels(self):
        input = "aeiou"
        result = count_vowels(input)
        self.assertEqual(5, result)

    def testMixedCase(self):
        input = "AbCdEfGhIj"
        result = count_vowels(input)
        self.assertEqual(3, result)

if __name__ == '__main__':
    unittest.main()