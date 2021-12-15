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
        destdir.mkdir(parents=True, exist_ok=True)
        shutil.copytree(ex / "test", destdir / "test", dirs_exist_ok=True)
        if (ex / "src").exists():
            shutil.copytree(ex / "src", destdir / "sol", dirs_exist_ok=True)
        desc = next(x for x in ex.iterdir() if x.suffix == ".md")
        desctext = desc.read_text(encoding="utf-8")
        desctext_dest = textwrap.dedent(f"""
        ---
        title: {re.search(r"^# (.*)$",desctext, flags=re.RegexFlag.M).group(1)}
        author:
            - GDI-Tutoren
            - Christopher Schölzel
        keywords:
            - python
            - semester-1
            - bioinformatics
        lang: de-DE
        solution-size: {sum([len(x.read_text(encoding="utf-8").splitlines()) for x in (ex / "src").iterdir()])}
        ---
        """ + desctext)
        (destdir / desc.name).write_text(desctext_dest, encoding="utf-8")
