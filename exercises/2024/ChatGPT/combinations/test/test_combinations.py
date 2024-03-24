import unittest

from combinations import calculate_combinations

class TestCombinations(unittest.TestCase):
    
    def testBasic(self):
        result = calculate_combinations(5, 2)
        self.assertEqual(10, result)

    def testLargerNumbers(self):
        result = calculate_combinations(10, 3)
        self.assertEqual(120, result)

    def testEdgeCase(self):
        result = calculate_combinations(0, 0)
        self.assertEqual(1, result)

    def testLargerEdgeCase(self):
        result = calculate_combinations(100, 50)
        self.assertEqual(100891344545564193334812497256, result)

    def testLargestEdgeCase(self):
        result = calculate_combinations(1000, 500)
        self.assertEqual(159835829026978308584787115025121366330516784565551047924462979739070216583162787607771372140379887971233560446350574496874051476587108097422723622030678294703128518015230150478448458919798841502236981518015815946900521099316652560422691353363083 ... (truncated)
        
if __name__ == '__main__':
    unittest.main()