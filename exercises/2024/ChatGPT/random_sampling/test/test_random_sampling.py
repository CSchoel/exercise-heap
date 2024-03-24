import unittest
from random_sampling import random_sample

class TestRandomSampling(unittest.TestCase):

    def testSampleSize(self):
        data = ["apple", "banana", "cherry", "date", "elderberry"]
        sample = random_sample(data, 3)
        self.assertEqual(3, len(sample))

    def testSampleContains(self):
        data = ["apple", "banana", "cherry", "date", "elderberry"]
        sample = random_sample(data, 3)
        for item in sample:
            self.assertIn(item, data)

    def testSampleUnique(self):
        data = ["apple", "banana", "cherry", "date", "elderberry"]
        sample = random_sample(data, 3)
        self.assertEqual(len(set(sample)), len(sample))

    def testSampleSizeLargerThanData(self):
        data = ["apple", "banana", "cherry", "date", "elderberry"]
        sample = random_sample(data, 10)
        self.assertEqual(len(sample), len(data))

    def testEmptyData(self):
        data = []
        sample = random_sample(data, 3)
        self.assertEqual([], sample)

    def testSampleSizeZero(self):
        data = ["apple", "banana", "cherry", "date", "elderberry"]
        sample = random_sample(data, 0)
        self.assertEqual([], sample)

if __name__ == '__main__':
    unittest.main()