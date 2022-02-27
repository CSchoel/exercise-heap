#!/usr/bin/env python3
# Exports all Python exercises that have unit tests to dozeloc exercise folder
# Usage: ./export_dozeloc.py destination/folder
import os
from pathlib import Path
import yaml
import re
import io
import sys
import shutil

RE_HEADER = r"^---$(.+?)^---$"

def get_header(exfile: Path) -> dict:
    text = exfile.read_text(encoding="utf-8")
    header = re.search(RE_HEADER, text, flags=re.M | re.S)
    if header is None:
        raise Exception(f"{exfile} does not contain a YAML header")
    if header.start() != 0:
        raise Exception(f"{exfile} has a YAML block, which is not at the beginning of the file but at postion {header.start()}")
    return yaml.safe_load(io.StringIO(header.group(1)))

def strip_header(exfile: Path):
    text = exfile.read_text(encoding="utf-8")
    header = re.search(RE_HEADER, text, flags=re.M | re.S)
    text = text[header.end(0)+1:]
    exfile.write_text(text, encoding="utf-8")


if __name__ == "__main__":
    os.chdir(Path(__file__).parent)
    outdir = Path("../../export/dozeloc")
    if len(sys.argv) > 1:
        outdir = Path(sys.argv[1])
    outdir.mkdir(parents=True, exist_ok=True)
    exercises =  list(Path("../../exercises").glob("*/*/*/*.md"))
    headers = [get_header(x) for x in exercises]
    exercises = [(x, h) for x, h in zip(exercises, headers) if {"language": "python"} in h["keywords"]]
    headers = [x[1] for x in exercises]
    exercises = [x[0] for x in exercises]
    titles = ["{:03d}_{}".format(i, h["title"].replace("/","_")) for i, h in enumerate(headers)]
    exercises = [x for x in exercises if (x.parent / "test").is_dir()]
    for t, ex in zip(titles, exercises):
        exout = outdir / t
        print(exout)
        shutil.copytree(ex.parent, exout, dirs_exist_ok=True)
        # move solutions to "src" subfolder
        if (exout / "sol").exists() and not (exout / "src").exists():
            (exout / "sol").rename(exout / "src")
        if (exout / "sol").exists():
            shutil.rmtree(exout / "sol")
        # copy resources to "test" subfolder
        if (exout / "res").exists():
            for p in (exout / "res").iterdir():
                if p.is_dir():
                    shutil.copytree(p, exout / "test" / p.name)
                else:
                    shutil.copy2(p, exout / "test")
            shutil.rmtree(exout / "res")
        # strip header from exercise description
        strip_header(outdir / ex.name)
