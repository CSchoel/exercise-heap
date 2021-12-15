import unittest
import random

import substitution_cipher

class SubstitutionCipherTest(unittest.TestCase):

    def testGene(self):
        cipher = {'A': 'T', 'C': 'G', 'G' : 'C', 'T': 'A'}
        self.assertEqual("TTCGTCA", substitution_cipher.subst("AAGCAGT", cipher))

    def testRot13(self):
        cipher = { chr(ord('a') + x): chr(ord('a') + (x + 13) % 26) for x in range(26)}
        self.assertEqual("sbbone", substitution_cipher.subst("foobar", cipher))

    def testRandom(self):
        random.seed(0)
        alphabet = "abcdefghijklmnopqrstuvwxyz"
        shuffled = list(alphabet)
        random.shuffle(shuffled)
        cipher = dict(zip(alphabet, shuffled))
        self.assertEqual("frraoj", substitution_cipher.subst("foobar", cipher))

if __name__ == '__main__':
    unittest.main()