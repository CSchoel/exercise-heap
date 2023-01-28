import os

def write_csv(fname, strings):
    with open(fname, "w", encoding="utf-8") as f:
      for s in strings:
        f.write(s)
        f.write(";")
        f.write(str(len(set(s))))
        f.write(os.linesep)