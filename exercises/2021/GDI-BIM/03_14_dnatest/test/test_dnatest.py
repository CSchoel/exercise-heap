
from posixpath import split
import unittest

import dnatest

class TestSplitting(unittest.TestCase):
    
    def setUp(self):
        methodImplemented = True

        try:
            dnatest.dnatest
            # Zugriff auf dnatest wirft einen NameError, wenn dnatest nicht vorhanden ist
            # Bei Instanzmethoden wird dies zu einem AttributeError
        except (NameError, AttributeError):
            # Wenn self.fail innerhalb des except-Blocks ist, kommt der NameError im StackTrace vor
            methodImplemented = False

        if not methodImplemented:
            self.fail("Die Lösung kann nicht getestet werden. Eine Funktion \"dnatest(input: str) -> bool\" fehlt!")

    def testContainsLysinVariant1(self):
        input = "ACUUGCUGACUUAAAAUU"
        result = dnatest.dnatest(input)
        self.assertEqual(True, result, "Die DNA Kette enthält Lysin, es wird aber nicht erkannt.")

    def testContainsLysinVariant2(self):
        input = "ACUUGCUGACUUAAGAUU"
        result = dnatest.dnatest(input)
        self.assertEqual(True, result, "Die DNA Kette enthält Lysin, es wird aber nicht erkannt.")

    def testNotContainsLysin(self):
        input = "ACUUGCUGAGAGGGG"
        result = dnatest.dnatest(input)
        self.assertEqual(False, result, "Auch wenn du Lysin findest, die DNA Kette enthält kein Lysin.")
    
    def testOffShiftLysin(self):
        input = "ACUUGCUGAUAAGAAAGG"
        result = dnatest.dnatest(input)
        self.assertEqual(False, result, "Die DNA Kette enthält kein Lysin, vielleicht splittest du nicht richtig die Basen!")


if __name__ == '__main__':
    unittest.main()