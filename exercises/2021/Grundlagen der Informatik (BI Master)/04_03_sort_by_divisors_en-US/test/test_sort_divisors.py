import unittest

import sort_by_divisors

class SortByDivisorsTest(unittest.TestCase):

    def testThatEmptyListCanBeSorted(self):
        lst = []
        sort_by_divisors.sort_by_divisors(lst)
        self.assertEqual([], lst)

    def testThatOneElementListCanBeSorted(self):
        lst = [1]
        sort_by_divisors.sort_by_divisors(lst)
        self.assertEqual([1], lst)

    def testThatFiveElementListCanBeSorted(self):
        lst = [1, 167, 12, 15, 7]
        sort_by_divisors.sort_by_divisors(lst)
        self.assertEqual([1, 167, 7, 15, 12], lst)

    def testThatTenElementListCanBeSorted(self):
        lst = [1, 2,155, 13, 18, 19, 12, 15, 13, 120]
        sort_by_divisors.sort_by_divisors(lst)
        self.assertEqual([1, 2, 13, 19, 13, 155, 15, 18, 12, 120], lst)

if __name__ == '__main__':
    unittest.main()