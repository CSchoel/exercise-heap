from typing import Generator
import unittest
import generator_comprehension as gc

from typing import Generator



class gcTest(unittest.TestCase):

    def matchValues(self, generator: Generator[int, None, None], compareValues):

        for list_item in compareValues:
            self.assertEqual(list_item, next(generator))

    def testReturnType(self):

       self.assertEqual("<class 'generator'>", str(type(gc.generate(200))))

    def test200Range(self):

       self.matchValues(gc.generate(200), [2*x for x in range(200)])

    def testTestValue(self):

       self.matchValues(gc.result, [2*x for x in range(256)])



if __name__ == '__main__':
    unittest.main()
