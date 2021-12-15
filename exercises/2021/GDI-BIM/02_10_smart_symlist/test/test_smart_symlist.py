import unittest
import re
from os.path import abspath

import smartsymlist

class SmartSymTest(unittest.TestCase):

    def testSome(self):
        self.assertEqual({1, 3, 20, 5, 6}, smartsymlist.unique)

    def testLoopInCheck(self):
        with open(abspath(smartsymlist.__file__), "r") as file:
            
            contains_required_method = False

            for line in file.readlines():
                strippedLine = line.strip()
                if not strippedLine \
                        or strippedLine.startswith("#") \
                        or strippedLine.startswith("import") \
                        or strippedLine.startswith("from"):
                    continue

                # no keyword `in`
                if re.search(r"\bin\b", strippedLine) is not None:
                    self.fail("Die folgende Zeile enthält das keyword 'in', das in dieser Aufgabe verboten ist.\n" + strippedLine)
                # no keyword `for`
                if re.search(r"\bfor\b", strippedLine) is not None:
                    self.fail("Die folgende Zeile enhtält das Schlüsselwort 'for', das in dieser Aufgabe verboten ist.\n" + strippedLine)
                if re.search(r".\s*symmetric_difference\s*\(", strippedLine) is not None:
                    contains_required_method = True
                if re.search(r".\s*^\s*.", strippedLine) is not None:
                    contains_required_method = True

        self.assertTrue(contains_required_method, "Error: Aufgabenstellung nochmal aufmerksam lesen ;)")

if __name__ == '__main__':
    unittest.main()