from typing import List

def splitting(input: str, batchSize: int) -> List[str]:
	splitted = []
	for i in range(0,len(input), batchSize):
		splitted.append(input[i: i + batchSize])

	return splitted
