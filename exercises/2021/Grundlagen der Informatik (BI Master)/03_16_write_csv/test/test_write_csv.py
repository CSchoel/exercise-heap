import unittest
import write_csv as wc

class WriteCSVTest(unittest.TestCase):

    def testSome(self):
        inputs = [
          "foo",
          "bar",
          "the quick brown fox jumps over the lazy dog",
          "she sells sea shells at the sea shore",
          "when is a door not a door?",
          "when it's ajar"
        ]
        chars = [2, 3, 27, 9, 13, 12]
        wc.write_csv("data.csv", inputs)
        with open("data.csv", "r", encoding="utf-8") as f:
            for i,(inp, nchar, line) in enumerate(zip(inputs, chars, f)):
                self.assertEqual(inp+";"+str(nchar)+"\n", line)

if __name__ == '__main__':
    unittest.main()
