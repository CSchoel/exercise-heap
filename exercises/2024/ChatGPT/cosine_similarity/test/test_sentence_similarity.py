import unittest
from sentence_similarity import sentence_similarity


class TestSimilarity(unittest.TestCase):

    def test_similarity_same_sentence(self):
        sentence1 = "I like bananas"
        similarity = sentence_similarity(sentence1, sentence1)
        self.assertAlmostEqual(1.0, similarity, places=5)

    def test_similarity_different_sentences(self):
        sentence1 = "I like bananas"
        sentence2 = "I like apples"
        similarity = sentence_similarity(sentence1, sentence2)
        self.assertAlmostEqual(2 / 3, similarity, places=5)

    def test_similarity_different_order(self):
        sentence1 = "I like bananas"
        sentence2 = "bananas like I"
        similarity = sentence_similarity(sentence1, sentence2)
        self.assertAlmostEqual(1.0, similarity, places=5)


if __name__ == "__main__":
    unittest.main()
