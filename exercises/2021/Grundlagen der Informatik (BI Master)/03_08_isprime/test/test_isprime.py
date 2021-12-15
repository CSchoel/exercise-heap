import unittest
from typing import List

import isprime

class IsPrimeTest(unittest.TestCase):

    def setUp(self):
        methodImplemented = True

        try:
            isprime.isPrime
            
            # Zugriff auf isprime wirft einen NameError, wenn isprime nicht vorhanden ist
            # Bei Instanzmethoden wird dies zu einem AttributeError
        except (NameError, AttributeError):
            # Wenn self.fail innerhalb des except-Blocks ist, kommt der NameError im StackTrace vor
            methodImplemented = False

        if not methodImplemented:
            self.fail("Die Lösung kann nicht getestet werden. Eine Funktion \"isPrime(n: int) -> bool\" fehlt!")


    def testSome(self):
        result: List[int] = []
        
        for i in range(2,20+1):
            if isprime.isPrime(i):
                result.append(i)

        self.assertEqual([2,3,5,7,11,13,17,19], result)

        result: List[int] = []
        for i in range(2,10):
            if isprime.isPrime(i):
                result.append(i)

        self.assertEqual([2,3,5,7], result)

if __name__ == '__main__':
    unittest.main()
