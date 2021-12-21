#!/usr/bin/python3
# -*- coding: utf-8 -*-

# Author: Birger Schulze

import sys

baseNumbers = [2,7]

def fromSequence(index):
    return baseNumbers[(index % len(baseNumbers))] * int(10 ** int(index / len(baseNumbers)))

def getCounterweights(weight, counterweights):
    counterweights.sort()
    counterweights.reverse()
    solution = []
    while weight > 0:
        found = False
        for cw in counterweights:
            if cw <= weight:
                found = True
                solution.append(cw)
                weight -= cw
                continue
        if (not found):
            break
    return solution

def balance(weight):
    index = 0
    num = fromSequence(index)
    possibles = []
    while (num <= weight):
        possibles.append(num)
        num = fromSequence(index)
        index += 1
    possibles.reverse()
    #print(possibles)
    return getCounterweights(weight, possibles)

if __name__ == "__main__":
    filename = sys.argv[1]
    inFile = open(filename, "r")
    outFile = open("output.txt", "w")
    for line in inFile:
        path = balance(int(line))
        if path == []:
            path.append(0)
        pathString = str(path).replace(" ","").replace("[", "").replace("]","")
        print("{orig} {summed} {p}".format(orig=line.strip(), summed=sum(path), p=pathString))
        #outFile.write("{s}\n".format(s=pathString))
        if sum(path) != int(line):
            print("It's fucked!")
