import unittest

from word_wrap import word_wrap


class TestWordWrap(unittest.TestCase):

    def test_wrap20(self):
        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
        result = word_wrap(text, 20)
        self.assertEqual(
            ["Lorem ipsum dolor", "sit amet,", "consectetur", "adipiscing elit."],
            result,
        )

    def test_wrap10(self):
        text = "This is a short text."
        result = word_wrap(text, 10)
        self.assertEqual(["This is a", "short", "text."], result)


if __name__ == "__main__":
    unittest.main()
