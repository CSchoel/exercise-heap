import skip
import unittest
from os.path import abspath
import re

class SkipTest(unittest.TestCase):

    def test_list(self):
        self.assertEqual([3], list(skip.skip(2, [1,2,3])))

    def test_range(self):  
        self.assertEqual([3, 4], list(skip.skip(3, range(5))))

    def test_map(self):
        self.assertEqual([3, 6], list(skip.skip(1, map(len, ["foo", "bar", "foobar"]))))

    def test_zeroskip(self):
        self.assertEqual([1, 2, 3], list(skip.skip(0, [1, 2, 3])))

    def test_isiter(self):
        s = skip.skip(1, [1,2])
        self.assertFalse(isinstance(s, list), "Die Funktion soll einen Iterator zurückgeben, keine Liste.")
        # check that we do not get errors if we use iterator functions on s
        self.assertEqual(2, next(iter(s)), "Die Funktion soll etwas zurückgeben, das iterierbar ist.")

    def test_islazyiter(self):
        lst = []
        it = skip.skip(1, (lst.append(7) for x in range(3)))
        self.assertEqual(0, len(lst), "skip(n, it) soll next(it) erst ausführen, wenn next() auf dem Iterator aufgerufen wird, der von skip zurückgegeben wird")
        self.assertEqual([None, None], list(it))

    def test_load_one_by_one(self):
        lst = []
        it = skip.skip(1, (lst.append(7) for x in range(5)))
        # call iterator once to see how often next is called for input iterator
        next(it)
        self.assertEqual(2, len(lst), "ein einzelner Aufruf von next() auf dem Ergebnis von skip(1, it) sollte nur genau zwei mal next(it) aufrufen")

if __name__ == '__main__':
    unittest.main()
