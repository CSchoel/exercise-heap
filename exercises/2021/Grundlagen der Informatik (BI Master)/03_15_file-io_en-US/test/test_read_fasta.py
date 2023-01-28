import unittest

from sys import platform
from os import rename
import read_fasta as rf
import subprocess

class fastaTest(unittest.TestCase):

    filename = "uniprot_small.fasta"
    renamedName = "uniprot_small_rename.fasta"

    def testValuesAndClosed(self):
        ids = rf.read_file(self.filename)
        ids_expected = [
            "Q6GZX4", "Q6GZX3", "Q197F8", "Q197F7", "Q6GZX2", "Q6GZX1",
            "Q197F5", "Q6GZX0", "Q91G88", "Q6GZW9", "Q6GZW8", "Q197F3",
            "Q197F2", "Q6GZW6", "Q91G85", "Q6GZW5"
        ]
        self.assertSequenceEqual(ids_expected, ids)

        

        if platform == "linux" or platform == "linux2":
            lsof = subprocess.call(["lsof", "uniprot_small.fasta"])
            self.assertEqual(1, lsof, "the file uniprot_small.fasta is still open!")
        

if __name__ == '__main__':
    unittest.main()
