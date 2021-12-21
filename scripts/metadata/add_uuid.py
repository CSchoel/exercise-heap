#!/bin/env python3
# Adds UUID to all exercises

import yaml
from pathlib import Path
import glob
import os
import re
import warnings
import io

def patch_header(fname, func):
    p = Path(fname)
    text = p.read_text(encoding="utf-8")
    header = re.search(r"^---$(.+?)^---$", text, flags=re.M | re.S)
    if header is None:
        raise Exception(f"{p} does not contain a YAML header")
    if header.start() != 0:
        raise Exception(f"{p} has a YAML block, which is not at the beginning of the file but at postion {header.start()}")
    rest = text[header.end():]
    metadata = yaml.safe_load(io.StringIO(header.group(1)))
    func(metadata)
    new_text = os.linesep.join(["---", yaml.dump(metadata), "---"]) + rest
    print(new_text)
    # p.write_text(text)


if __name__ == "__main__":
    os.chdir(Path(__file__).parent)
    for x in glob.glob("../../exercises/*/*/*/*.md"):
        p = Path(x)
        patch_header(x, lambda x: print(x))