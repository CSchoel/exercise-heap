import unittest
from typing import List
from os.path import abspath

import uniquenumbers as un

class UniqueNumbersTest(unittest.TestCase):

    def setUp(self):
        methodImplemented = True

        try:
            un.uniqueNumbers
            
            # Zugriff auf uniqueNumbers wirft einen NameError, wenn uniqueNumbers nicht vorhanden ist
            # Bei Instanzmethoden wird dies zu einem AttributeError
        except (NameError, AttributeError):
            # Wenn self.fail innerhalb des except-Blocks ist, kommt der NameError im StackTrace vor
            methodImplemented = False

        if not methodImplemented:
            self.fail("Die Lösung kann nicht getestet werden. Eine Funktion \"uniqueNumbers(numbers: List[int]) -> Set[int]\" fehlt!")


    def testSome(self):
        set1 = un.uniqueNumbers([1,1,1,2,-15,-18,-20,20,22,-15,18,5,-18])

        self.assertEqual({1,1,1,2,-15,-18,-20,20,22,-15,18,5,-18}, set1)

        set2 = un.uniqueNumbers([22222,55555,111,222,333,111111,55555])

        self.assertEqual({22222,55555,111,222,333,111111,55555}, set2)

    def testLineCount(self):
        with open(abspath(un.__file__), "r") as file:
            counter = 0
            for line in file.readlines():
                strippedLine = line.strip()
                if not strippedLine \
                        or strippedLine.startswith("#") \
                        or strippedLine.startswith("import") \
                        or strippedLine.startswith("from"):
                    continue

                counter += 1
        
        self.assertLessEqual(counter, 2, "Ihr Code ist zu lang!")

if __name__ == '__main__':
    unittest.main()
