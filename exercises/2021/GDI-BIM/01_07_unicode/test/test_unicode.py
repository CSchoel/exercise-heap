import unittest

import unifun

class ZooTest(unittest.TestCase):

    def test_text(self):
        self.assertEqual(unifun.text, "100€ Öcken")

    def test_utf8(self):
        self.assertEqual(unifun.code_utf8, b'100\xe2\x82\xac \xc3\x96cken')

    def test_win(self):
        self.assertEqual(unifun.code_win, b'100\x80 \xd6cken')

    def test_mac(self):
        self.assertEqual(unifun.code_mac, b'100\xdb \x85cken')

    def test_broken(self):
        self.assertEqual(unifun.text_broken, '100Ä ÷cken')

if __name__ == '__main__':
    unittest.main()
