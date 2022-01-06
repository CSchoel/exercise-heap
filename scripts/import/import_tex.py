#!/bin/env python3
# imports latex exercises (using pandoc to convert them to Markdown)
# Usage: ./import_tex.py path/to/exercise/sheet.tex

import os
from pathlib import Path
import sys
import subprocess

def to_md(srcpath: Path, dstpath: Path):
    code = subprocess.call([
            "pandoc",
            "-f",
            "latex",
            "-t",
            "gfm+raw_tex",
            srcpath.absolute(),
            "-o",
            dstpath.absolute()
    ])

if __name__ == '__main__':
    os.chdir(Path(__file__).parent)
    texfile = Path(sys.argv[1])
    to_md(texfile, Path(os.getcwd()) / "out" / texfile.name)