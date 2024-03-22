import unittest

from piglatin import pig_latin

class TestPigLatin(unittest.TestCase):
    
    def testPigLatin(self):
        sentence = "hello world"
        result = pig_latin(sentence)
        self.assertEqual("ellohay orldway", result)

    def testPigLatin2(self):
        sentence = "python is fun"
        result = pig_latin(sentence)
        self.assertEqual("ythonpay isay unfay", result)

if __name__ == '__main__':
    unittest.main()