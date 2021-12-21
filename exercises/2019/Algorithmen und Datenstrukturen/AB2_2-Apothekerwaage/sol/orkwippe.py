#!/usr/bin/python3
# -*- coding: utf-8 -*-

# Author: Birger Schulze

import sys

baseNumbers = [2,7]

def fromSequence(index):
    return baseNumbers[(index % len(baseNumbers))] * int(10 ** int(index / len(baseNumbers)))

def fewestCounterweights(weight, counterweights, depth, shortestDepth):
#    print("Depths {d}".format(d=depth))
    if depth > shortestDepth:
#        print("Going too deep")
        return None, None
    if weight == 0:
#        print("Found a solution")
        return depth, []
    shortestSubPath = []
    solution = False
    for cw in counterweights:
        if cw > weight:
#            print("Weight too high")
            continue
#        print(cw)
        newDepth, subPath = fewestCounterweights(weight - cw,
                                                           counterweights,
                                                           depth + 1,
                                                           shortestDepth)
        if newDepth == None and subPath == None:
            continue
        solution = True
        shortestDepth = newDepth
        shortestSubPath = subPath
        shortestSubPath.append(cw)
    if not solution:
        return None, None
#    print("New shortest path: {sp}".format(sp=shortestSubPath))
    return shortestDepth, shortestSubPath
        

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
    return fewestCounterweights(weight, possibles, 0, 999999999)

if __name__ == "__main__":
    filename = sys.argv[1]
    inFile = open(filename, "r")
    #outFile = open("output.txt", "w")
    for line in inFile:
        dept, path = balance(int(line))
        if path == []:
            path.append(0)
        pathString = str(path).replace(" ","").replace("[", "").replace("]","")
        #print("{orig} {summed} {p}".format(orig=line, summed=sum(path), p=pathString))
        print(pathString)
        #outFile.write("{s}\n".format(s=pathString))
        if sum(path) != int(line):
            print("It's fucked!")
