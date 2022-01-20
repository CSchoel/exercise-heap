#!/bin/env python3
# imports latex exercises (using pandoc to convert them to Markdown)
# Usage: ./import_tex.py path/to/exercise/sheet.tex

import os
from pathlib import Path
import sys
import subprocess
import re

def to_md(srcpath: Path, dstpath: Path):
    dstpath.parent.mkdir(exist_ok= True, parents= True)
    code = subprocess.call([
            "pandoc",
            "-f",
            "latex",
            "-t",
            "markdown+raw_tex",
            srcpath.absolute(),
            "-o",
            dstpath.absolute()
    ])

def split_md(srcpath: Path):
    md = srcpath.read_text(encoding="utf-8")
    sections = re.split(r"^## ", md, flags=re.M)
    sections = ["## " + s for s in sections[1:]]
    for s in sections:
        print(s.splitlines()[0])

if __name__ == '__main__':
    os.chdir(Path(__file__).parent)
    texfile = Path(sys.argv[1])
    outfile = Path(os.getcwd()) / "out" / texfile.name
    to_md(texfile, outfile)
    split_md(outfile)
