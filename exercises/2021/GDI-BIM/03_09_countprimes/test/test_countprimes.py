import unittest
from typing import List

import countprimes

class CountPrimesTest(unittest.TestCase):

    def setUp(self):
        methodImplemented = True

        try:
            countprimes.countPrimes
            
            # Zugriff auf countPrimes wirft einen NameError, wenn countPrimes nicht vorhanden ist
            # Bei Instanzmethoden wird dies zu einem AttributeError
        except (NameError, AttributeError):
            # Wenn self.fail innerhalb des except-Blocks ist, kommt der NameError im StackTrace vor
            methodImplemented = False

        if not methodImplemented:
            self.fail("Die Lösung kann nicht getestet werden. Eine Funktion \"countPrimes(n: int) -> int:\" fehlt!")

    def testSome(self):
        count25 = countprimes.countPrimes(25)

        self.assertEqual(9, count25)

        count10 = countprimes.countPrimes(10)
        
        self.assertEqual(4, count10)

if __name__ == '__main__':
    unittest.main()
