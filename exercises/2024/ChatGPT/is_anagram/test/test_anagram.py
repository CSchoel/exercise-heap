import unittest
from anagram import is_anagram

class TestAnagram(unittest.TestCase):
    
    def test_valid_anagram(self):
        self.assertTrue(is_anagram("listen", "silent"))
        self.assertTrue(is_anagram("rail safety", "fairy tales"))

    def test_invalid_anagram(self):
        self.assertFalse(is_anagram("hello", "world"))
        self.assertFalse(is_anagram("python", "pythons"))

if __name__ == '__main__':
    unittest.main()