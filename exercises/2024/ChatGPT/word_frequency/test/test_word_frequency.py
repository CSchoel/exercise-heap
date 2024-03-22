import unittest

from word_frequency import word_frequency

class TestWordFrequency(unittest.TestCase):
    
    def testSimpleSentence(self):
        input_text = "This is a test. This is only a test."
        result = word_frequency(input_text)
        expected_result = {'this': 2, 'is': 2, 'a': 2, 'test': 2, 'only': 1}
        self.assertEqual(expected_result, result)

    def testEmptyText(self):
        input_text = ""
        result = word_frequency(input_text)
        self.assertEqual({}, result)

if __name__ == '__main__':
    unittest.main()