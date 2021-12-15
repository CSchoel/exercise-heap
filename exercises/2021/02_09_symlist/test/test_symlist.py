import unittest
from os.path import abspath

import symlist

class SymTest(unittest.TestCase):

    def testSome(self):
        self.assertEqual({1, 3, 20, 5, 6}, symlist.unique)

    def testLoopInCheck(self):
        with open(abspath(symlist.__file__), "r") as file:
            contains_in = False
            contains_for = False

            contains_unallowed_method = False

            for line in file.readlines():
                strippedLine = line.strip()
                if not strippedLine \
                        or strippedLine.startswith("#") \
                        or strippedLine.startswith("import") \
                        or strippedLine.startswith("from"):
                    continue

                if "in" in strippedLine:
                    contains_in = True
                if "for" in strippedLine:
                    contains_for = True
                if "symmetric_difference" in strippedLine \
                    or "^" in strippedLine:
                    contains_unallowed_method = True
        
        self.assertTrue(contains_in, "Der Code enthält keinen `in`-Check.")
        self.assertTrue(contains_for, "Der Code enthält keinen `for`-Check.")
        self.assertFalse(contains_unallowed_method, "Der Code enthält unerlaubte Methoden.")

if __name__ == '__main__':
    unittest.main()
