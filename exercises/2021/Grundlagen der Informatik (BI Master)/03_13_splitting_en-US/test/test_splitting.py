
from posixpath import split
import unittest

import splitting

class TestSplitting(unittest.TestCase):
    
    def setUp(self):
        methodImplemented = True

        try:
            splitting.splitting
            # Zugriff auf splitting wirft einen NameError, wenn splitting nicht vorhanden ist
            # Bei Instanzmethoden wird dies zu einem AttributeError
        except (NameError, AttributeError):
            # Wenn self.fail innerhalb des except-Blocks ist, kommt der NameError im StackTrace vor
            methodImplemented = False

        if not methodImplemented:
            self.fail("Die Lösung kann nicht getestet werden. Eine Funktion \"splitting(input: Union[str, List[str]], batchSize: int) -> List[str]\" fehlt!")

    def testString5(self):
        input = "Hallo Welt!"
        result = splitting.splitting(input, 4)
        self.assertEqual(["Hall", "o We", "lt!"], result)

    def testString2(self):
        input = "Hallo Welt!"
        result = splitting.splitting(input, 2)
        self.assertEqual(["Ha","ll", "o ", "We", "lt", "!"], result)


if __name__ == '__main__':
    unittest.main()