import unittest

from histogram import generate_histogram

class TestHistogram(unittest.TestCase):
    
    def testSimpleHistogram(self):
        data = [1, 2, 2, 3, 3, 3, 4, 4, 4, 4]
        result = generate_histogram(data, bucket_size=2)
        self.assertEqual({1: 1, 2: 2, 3: 3, 4: 4}, result)

    def testBucketSizeThree(self):
        data = [1, 2, 2, 3, 3, 3, 4, 4, 4, 4]
        result = generate_histogram(data, bucket_size=3)
        self.assertEqual({1: 1, 2: 3, 3: 6, 4: 4}, result)

    def testDefaultBucketSize(self):
        data = [1, 2, 2, 3, 3, 3, 4, 4, 4, 4]
        result = generate_histogram(data)
        self.assertEqual({1: 1, 2: 2, 3: 3, 4: 4}, result)

    def testEmptyList(self):
        data = []
        result = generate_histogram(data, bucket_size=2)
        self.assertEqual({}, result)

    def testSingleElementList(self):
        data = [42]
        result = generate_histogram(data, bucket_size=5)
        self.assertEqual({42: 1}, result)

    def testNegativeNumbers(self):
        data = [-1, -2, -2, -3, -3, -3, -4, -4, -4, -4]
        result = generate_histogram(data, bucket_size=2)
        self.assertEqual({-1: 1, -2: 2, -3: 3, -4: 4}, result)

    def testMixedNumbers(self):
        data = [1, 2, 3, 4, 5, -1, -2, -3, -4, -5]
        result = generate_histogram(data, bucket_size=2)
        self.assertEqual({1: 1, 2: 2, 3: 2, 4: 2, 5: 1, -1: 1, -2: 2, -3: 2, -4: 2, -5: 1}, result)

if __name__ == '__main__':
    unittest.main()