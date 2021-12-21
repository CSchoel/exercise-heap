#!/usr/bin/env python3
# imports exercise folder written for "Algorithmen und Datenstrukturen" into heap format

import sys
import textwrap
import shutil
from pathlib import Path

if __name__ == '__main__':
    src = Path(sys.argv[1])
    dst = Path(sys.argv[2])
    exfiles = list(src.glob("*/*/*.md")) + list(src.glob("*/Bonus/*/*.md"))
    exfiles = [
        x for x in exfiles
        if not (
            x.stem.endswith("-solution")
            or x.stem.endswith("-korr")
            or x.stem.endswith("-gami")
            or x.stem.endswith("kriterien")
    )]
    dst.mkdir(exist_ok=True, parents=True)
    for ex in exfiles:
        if ex.parent.parent.name == "Bonus":
            destdir = dst / (ex.parent.parent.parent.name + "_Bonus_" + ex.parent.name)
        else:
            destdir = dst / (ex.parent.parent.name + "_" + ex.parent.name)
        destdir.mkdir(exist_ok=True)

        desctext = ex.read_text(encoding="utf-8")
        desctext_dest = textwrap.dedent(f"""\
        ---
        title: {ex.stem}
        author:
            - AuD-Tutoren
            - Christopher Schölzel
        keywords:
            - language: java
            - semester: 2
            - major: computer science
            - institution: Technische Hochschule Mittelhessen
            - course: Algorithmen und Datenstrukturen
        lang: de-DE
        solution-size: 0
        ---

        """)
        desctext_dest += desctext
        (destdir / ex.name).write_text(desctext_dest, encoding="utf-8")

        sol = ex.parent / (ex.stem + "-solution.md")
        if sol.exists():
            (destdir / "sol").mkdir(exist_ok=True)
            shutil.copy2(sol, destdir / "sol" / sol.name)

        soldir = ex.parent / "musterloesung"
        if soldir.exists():
            (destdir / "sol").mkdir(exist_ok=True)
            shutil.copytree(soldir, destdir / "sol", dirs_exist_ok=True)
