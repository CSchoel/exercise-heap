import unittest

from permutations import generate_permutations


class TestGeneratePermutations(unittest.TestCase):

    def test_generate_permutations(self):
        result = list(generate_permutations([1, 2, 3]))
        self.assertEqual(
            result, [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
        )

    def test_empty_input(self):
        # Test empty input
        result = list(generate_permutations([]))
        self.assertEqual(result, [[]])

    def test_single_element(self):
        # Test single element input
        result = list(generate_permutations([1]))
        self.assertEqual(result, [[1]])


if __name__ == "__main__":
    unittest.main()
