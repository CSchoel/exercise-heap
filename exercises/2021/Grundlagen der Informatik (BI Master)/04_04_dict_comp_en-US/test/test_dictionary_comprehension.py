import unittest

import dictionary_comprehension as dc

class dictTest(unittest.TestCase):

    def testResultValue(self):
        self.assertEqual({'quick': 5, 'brown': 5, 'fox': 3, 'jumps': 5, 'over': 4, 'lazy': 4, 'dog': 3}, dc.result)

    def testRandomSentence(self):
        self.assertEqual(
            {'GDI': 3, 'macht': 5, 'richtig': 7, 'viel': 4, 'Spaß': 4},
             dc.make_dict("GDI macht richtig viel Spaß"))

if __name__ == '__main__':
    unittest.main()
