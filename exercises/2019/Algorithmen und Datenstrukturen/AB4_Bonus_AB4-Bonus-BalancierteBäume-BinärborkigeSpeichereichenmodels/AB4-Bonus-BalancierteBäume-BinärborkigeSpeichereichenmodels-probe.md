---
title: AB4-Bonus-BalancierteBäume-BinärborkigeSpeichereichenmodels-probe
author:
    - AuD-Tutoren
    - Christopher Schölzel
keywords:
    - language: java
    - semester: 2
    - major: computer science
    - institution: Technische Hochschule Mittelhessen
    - course: Algorithmen und Datenstrukturen
lang: de-DE
solution-size: 0
---

fun isBalanced(tree)
	if (tree.isLeaf)
	    return true
	if (abs(pathLength(tree.left) - pathlength(tree.right)) > 1)
	    return false
    return isBalanced(tree.left) && isBalanced(tree.right)

fun pathLength(tree)
    if (tree.isLeaf)
        return 1
    return 1 + max(pathLength(tree.left), pathLenght(tree.right))
