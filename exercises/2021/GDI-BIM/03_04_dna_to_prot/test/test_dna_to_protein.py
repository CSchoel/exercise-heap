import unittest

import dna_to_protein as dtp

class dnaTest(unittest.TestCase):

    def testResultVar(self):
        self.assertEqual("MEVFKAPPIGI", dtp.result,
                         "Es wurde entweder keine Variable im äußeren Scope mit dem namen `result` angelegt " \
                         + "oder das Ergebnis is inkorrekt.")

    def testRandomValue(self):

        self.assertEqual("FFR", dtp.translate_to_prot("TTTTTCCGA"),
                         "Die Funktion `translate_to_prot` funktioniert nicht richtig bei anderen Eingabewerten.")


if __name__ == '__main__':
    unittest.main()
