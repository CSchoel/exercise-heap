def translate(x):
    result = ""
    for letter in x:
        if letter == "A":
            result += "T"
        if letter == "T":
            result += "A"
        if letter == "C":
            result += "G"
        if letter == "G":
            result += "C"
    return result


result = translate("ACGGT")

