def read_file(file):
    ids = []
    with open(file, "r", encoding="utf-8") as fasta:
        id = ""
        for line in fasta:
            if ">" in line:
                id = line.split("|")[1]
                ids.append(id)
    return ids

