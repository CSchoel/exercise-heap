#!/bin/env python3
# Checks that each exercise has a unique UUID

import glob
import re
from typing import List, Tuple
import yaml
from pathlib import Path
import os
import io


def get_header(exfile: Path) -> str:
    text = exfile.read_text(encoding="utf-8")
    header = re.search(r"^---$(.+?)^---$", text, flags=re.M | re.S)
    if header is None:
        raise Exception(f"{exfile} does not contain a YAML header")
    if header.start() != 0:
        raise Exception(
            f"{exfile} has a YAML block, which is not at the beginning of the file but at postion {header.start()}"
        )
    return header.group(1)


def find_duplicates(lst: List[Tuple[Path, str]]) -> List[Tuple[str, List[Path]]]:
    count = {}
    for path, id in lst:
        count.setdefault(id, [])
        count[id].append(path)
    duplicates = {i: l for i, l in count.items() if len(l) > 1}
    return list(duplicates.items())


if __name__ == "__main__":
    os.chdir(Path(__file__).parent)
    exercises = Path("../../exercises").glob("*/*/*/*.md")
    headers = [(p, yaml.safe_load(io.StringIO(get_header(p)))) for p in exercises]
    noid = [(p, h) for p, h in headers if "id" not in h]
    ids = [(p, h["id"]) for p, h in headers if "id" in h]
    dup = find_duplicates(ids)
    for p, h in noid:
        print(f"Exercise {p} does not have a UUID in the header")
    for id, paths in dup:
        print(f"Multiple exercises have the same id {id}:")
        for p in paths:
            print("\t", p)
    exit(len(dup) + len(noid))
