#!/bin/env python3
# Adds UUID to all exercises

from pathlib import Path
import glob
import os
import re
import uuid

def patch_header(fname, func, dry_run=False):
    p = Path(fname)
    text = p.read_text(encoding="utf-8")
    header = re.search(r"^---$(.+?)^---$", text, flags=re.M | re.S)
    if header is None:
        raise Exception(f"{p} does not contain a YAML header")
    if header.start() != 0:
        raise Exception(f"{p} has a YAML block, which is not at the beginning of the file but at postion {header.start()}")
    rest = text[header.end():]
    header = header.group(1).strip()
    new_header = os.linesep.join(["---", func(header), "---"])
    new_text = new_header + rest
    if dry_run:
        print(new_text)
    else:
        p.write_text(new_text)

def add_attribute(header, att, valfunc):
    if re.search(f"^{att}:", header, flags=re.M) is not None:
        # only add if not already present
        return header
    return os.linesep.join([header, f"{att}: {valfunc(header)}"])


if __name__ == "__main__":
    os.chdir(Path(__file__).parent)
    for x in glob.glob("../../exercises/*/*/*/*.md"):
        p = Path(x)
        patch_header(x, lambda h: add_attribute(h, "id", lambda x: uuid.uuid4()))
