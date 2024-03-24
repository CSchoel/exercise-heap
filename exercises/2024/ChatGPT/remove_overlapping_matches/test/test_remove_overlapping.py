import unittest
from remove_overlapping import remove_overlapping_matches


class TestRemoveOverlapping(unittest.TestCase):

    def testNoOverlap(self):
        matches = [(0, 5, 1), (7, 10, 2), (12, 15, 3)]
        result = remove_overlapping_matches(matches)
        self.assertEqual(result, matches)

    def testOverlapSamePriority(self):
        matches = [(0, 5, 1), (3, 7, 1), (6, 9, 1), (8, 12, 1)]
        result = remove_overlapping_matches(matches)
        self.assertEqual(result, [(0, 5, 1), (6, 9, 1)])

    def testOverlapDifferentPriority(self):
        matches = [(0, 5, 1), (3, 7, 2), (6, 9, 3), (8, 12, 1)]
        result = remove_overlapping_matches(matches)
        self.assertEqual(result, [(0, 5, 1), (6, 9, 3)])

    def testEmptyInput(self):
        matches = []
        result = remove_overlapping_matches(matches)
        self.assertEqual(result, [])

    def testSingleMatch(self):
        matches = [(0, 5, 1)]
        result = remove_overlapping_matches(matches)
        self.assertEqual(result, [(0, 5, 1)])

    def testMultipleSamePriority(self):
        matches = [(0, 5, 2), (1, 3, 2), (3, 6, 2), (4, 7, 2)]
        result = remove_overlapping_matches(matches)
        self.assertEqual(result, [(0, 5, 2)])


if __name__ == "__main__":
    unittest.main()
