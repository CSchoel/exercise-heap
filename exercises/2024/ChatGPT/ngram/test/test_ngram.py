import unittest

from ngram import NgramModel

import json
import urllib.request
from html.parser import HTMLParser


class PlainTextParser(HTMLParser):
    def __init__(self):
        super().__init__()
        self._plain_text = []

    def handle_data(self, data):
        self._plain_text.append(data)

    def get_plain_text(self):
        return "".join(self._plain_text)


def download_wikipedia_article(title):
    url = (
        "https://en.wikipedia.org/w/api.php?action=query&format=json"
        f"&prop=revisions&titles={title}&rvlimit=1&rvprop=content&rvdir=newer"
        "&rvstart=2024-01-01T00:00:00Z&rvend=2024-02-01T00:00:00Z"
        "&rvparse=html"
    )
    with urllib.request.urlopen(url) as response:
        data = json.load(response)
        page = next(iter(data["query"]["pages"].values()))
        if "revisions" in page:
            html_content = page["revisions"][0]["*"]
            # Parse HTML content to extract plain text
            parser = PlainTextParser()
            parser.feed(html_content)
            return parser.get_plain_text()
        else:
            return None


class TestNgramModel(unittest.TestCase):

    def test_ngram_1(self):
        model = NgramModel(1)
        model.train(download_wikipedia_article("Python_(programming_language)"))
        predictions = model.predict("Python")
        self.assertEqual(["the", "Python", "and", "from", "on"], predictions[:5])

    def test_ngram_2(self):
        model = NgramModel(2)
        model.train(download_wikipedia_article("Python_(programming_language)"))
        predictions = model.predict("Python is")
        self.assertEqual(["a", "the", "also", "better", "used"], predictions[:5])

    def test_ngram_3(self):
        model = NgramModel(3)
        model.train(download_wikipedia_article("Python_(programming_language)"))
        predictions = model.predict("Python is")
        self.assertEqual(
            ["a", "dynamically", "compiled,", "meant", "strongly"], predictions[:5]
        )


if __name__ == "__main__":
    unittest.main()
