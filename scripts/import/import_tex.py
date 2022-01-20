#!/bin/env python3
# imports latex exercises (using pandoc to convert them to Markdown)
# Usage: ./import_tex.py path/to/exercise/sheet.tex /path/to/header_template.yaml [output/dir]

import os
from pathlib import Path
import sys
import subprocess
import re
import warnings
import yaml
import io
import uuid

def to_md(srcpath: Path, dstpath: Path):
    dstpath.parent.mkdir(exist_ok= True, parents= True)
    code = subprocess.call([
            "pandoc",
            "-f",
            "latex+raw_tex+latex_macros",
            "-t",
            "markdown+raw_tex",
            srcpath.absolute(),
            "-o",
            dstpath.absolute()
    ])

def split_md(srcpath: Path, header_templ: Dict[Any]):
    md = srcpath.read_text(encoding="utf-8")
    sections = re.split(r"^## ", md, flags=re.M)
    sections = ["## " + s for s in sections[1:]]
    for i, s in enumerate(sections):
        heading = re.search(r"^## (.+)\{#(\S+) (.+)\}$", s, flags=re.M)
        if heading is None:
            warnings.warn(f"The exercise '{s.splitlines()[0]}' does not have pandoc header attributes")
            continue
        header = header_templ
        header["id"] = uuid.uuid4()
        header["title"] = heading.group(1)
        headertxt = io.StringIO(yaml.safe_dump(header))
        fn = srcpath.parent / f"{str(i).zfill(2)}_{heading.group(2)}.md"
        fn.write_text("---\n", "utf-8")
        fn.write_text(headertxt, "utf-8")
        fn.write_text("---\n", "utf-8")
        fn.write_text(s, encoding="utf-8")

if __name__ == '__main__':
    os.chdir(Path(__file__).parent)
    texfile = Path(sys.argv[1])
    yamlfile = Path(sys.argv[2])
    if len(sys.argv > 3):
        outdir = Path(sys.argv[3])
    else:
        outdir = Path(os.getcwd()) / "out"
    outdir.mkdir(parents=True, exists_ok=True)
    header_templ = yaml.safe_load(io.StringIO(yamlfile.read_text("utf-8")))
    outfile = outdir / (texfile.stem + ".md")
    to_md(texfile, outfile)
    split_md(outfile, header_templ)
    outfile.unlink()
