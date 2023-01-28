from typing import List

def dnatest(input: str) -> bool:
	splitted_dna = splitting(input, 3)
	for lysin in ["AAG", "AAA"]:
		if lysin in splitted_dna:
			return True

	return False


def splitting(input: str, batchSize: int) -> List[str]:
	splitted = []
	for i in range(0,len(input), batchSize):
		splitted.append(input[i: i + batchSize])

	return splitted

