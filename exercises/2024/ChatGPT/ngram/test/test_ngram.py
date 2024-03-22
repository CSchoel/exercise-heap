import unittest

from ngram import NgramModel

class TestNgramModel(unittest.TestCase):

    def test_ngram_2(self):
        model = NgramModel(2)
        model.train("The quick brown fox jumps over the lazy dog")
        predictions = model.predict("The quick")
        self.assertCountEqual(["brown", "fox"], predictions)

    def test_ngram_3(self):
        model = NgramModel(3)
        model.train("The quick brown fox jumps over the lazy dog")
        predictions = model.predict("quick brown")
        self.assertCountEqual(["fox"], predictions)

    def test_ngram_4(self):
        model = NgramModel(3)
        model.train("The quick brown fox jumps over the lazy dog")
        predictions = model.predict("jumps over")
        self.assertCountEqual(["the"], predictions)

if __name__ == '__main__':
    unittest.main()