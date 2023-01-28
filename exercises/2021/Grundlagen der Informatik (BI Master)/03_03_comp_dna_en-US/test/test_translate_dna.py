import unittest

import translate_dna as td

class dnaTest(unittest.TestCase):

    def testResultVar(self):

        # Tests for predefined value
        self.assertEqual("TGCCA", td.result,
                         "Es wurde entweder keine Variable im äußeren Scope mit dem namen `result` angelegt " \
                         + "oder das Ergebnis is inkorrekt.")

    def testRandomValue(self):

        self.assertEqual("TGAATC", td.translate("ACTTAG"),
                         "Die Funktion `translate` funktioniert nicht richtig bei anderen Eingabewerten.")

if __name__ == '__main__':
    unittest.main()
