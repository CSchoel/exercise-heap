#!/usr/bin/env python3
# imports exercise folder written for "Algorithmen und Datenstrukturen" into heap format

import sys
import textwrap
import shutil
import datetime
import re
import glob
import os
from pathlib import Path

if __name__ == '__main__':
    os.chdir(Path(__file__).parent)
    exfiles = glob.glob(Path(sys.argv[1]) / "*/*/*.md")
    exfiles = [Path(x) for x in exfiles]
    exfiles = [x for x in exfiles if not (x.name.endswith("-solution") or x.name.endswith("-korr"))]
    for ex in exfiles:
        print(ex)
    exit(0)
    

    exdir = Path(sys.argv[1])
    for ex in exdir.iterdir():
        if not (ex / "test").is_dir():
            continue
        destdir =(dest / ex.name)
        destdir.mkdir(parents=True, exist_ok=True)
        shutil.copytree(ex / "test", destdir / "test", dirs_exist_ok=True)
        if (ex / "src").exists():
            shutil.copytree(ex / "src", destdir / "sol", dirs_exist_ok=True)
        for res in [x for x in (ex / "test").iterdir() if x.suffix != ".py"]:
            (destdir / "res").mkdir(exist_ok=True)
            shutil.copy2(res, destdir / "res" / res.name)
        desc = next(x for x in ex.iterdir() if x.suffix == ".md")
        desctext = desc.read_text(encoding="utf-8")
        sol_size = sum([
            len(x.read_text(encoding="utf-8").splitlines())
            for x in (ex / "src").iterdir()
            if x.suffix == ".py"
        ])
        desctext_dest = textwrap.dedent(f"""\
        ---
        title: {re.search(r"^# (.*)$",desctext, flags=re.RegexFlag.M).group(1)}
        author:
            - GDI-Tutoren
            - Christopher Schölzel
        keywords:
            - python
            - semester-1
            - bioinformatics
            - Technische Hochschule Mittelhessen
            - Justus-Liebig-Universität
            - Grundlagen der Informatik
        lang: de-DE
        solution-size: {sol_size}
        ---
        
        """)
        desctext_dest += desctext
        (destdir / desc.name).write_text(desctext_dest, encoding="utf-8")