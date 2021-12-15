#!/usr/bin/env python3
# imports exercise folder written for Dozeloc into heap format
# usage: ./import_dozeloc.py exercise-folder

import sys
import textwrap
import shutil
import datetime
import re
from pathlib import Path

dest = Path(__file__).parent / f"../../exercises/{datetime.date.today().year}"

if __name__ == '__main__':
    exdir = Path(sys.argv[1])
    for ex in exdir.iterdir():
        if not (ex / "test").is_dir():
            continue
        destdir =(dest / ex.name)
        destdir.mkdir(exist_ok=True)
        shutil.copy2(ex / "test", destdir / "test")
        shutil.copy2(ex / "src", destdir / "sol")
        desc = next(x for x in ex.iterdir() if x.suffix == ".md")
        desctext = desc.read_text(encoding="utf-8")
        desctext_dest = textwrap.dedent(f"""
        ---
        title: {re.search(r"^# (.*)$",desctext).group(1)}
        author:
            - GDI-Tutoren
            - Christopher Schölzel
        keywords:
            - python
            - semester-1
            - bioinformatics
        lang: en-US
        solution-size: {sum([len(x.read_text(encoding="utf-8").splitlines()) for x in (ex / "src").listdir()])}
        ---
        """ + desctext)
        (destdir / desc.name).write_text(desctext_dest, encoding="utf-8")
