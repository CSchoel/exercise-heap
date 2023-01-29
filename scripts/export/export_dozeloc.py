#!/usr/bin/env python3
"""Exports all Python exercises that have unit tests to dozeloc exercise folder.

Usage: ./export_dozeloc.py [-l language] [-o destination/folder]
"""

import os
from pathlib import Path
import operator
import sys
import shutil
import argparse

from exercise_heap.header import load_header_for_editing


if __name__ == "__main__":
    outdir = Path(__file__).parent.parent / "export" / "dozeloc"
    parser = argparse.ArgumentParser("Dozelot exporter", description=__doc__)
    parser.add_argument("-l", "--language", default="de-DE", help="Desired description language of exercises.")
    parser.add_argument("-o", "--outdir", default=outdir, help="Output directory for exercises.")
    parser.add_argument(
        "-s",
        "--add-solutions",
        action="store_true",
        help="If this is set, sample solutions will also be copied to the output folder.",
    )
    args = parser.parse_args(sys.argv[1:])
    outdir = Path(args.outdir).absolute()

    outdir.mkdir(parents=True, exist_ok=True)
    os.chdir(Path(__file__).parent)
    exercise_paths = list(Path("../../exercises").glob("*/*/*/*.md"))
    exercises = [(load_header_for_editing(p), p) for p in exercise_paths]
    # filter by programming language
    exercises = [(ex, p) for ex, p in exercises if {"language": "python"} in ex.header["keywords"]]
    # filter by description language
    exercises = [(ex, p) for ex, p in exercises if ex.header["lang"] == args.language]
    # filter by the existance of tests
    exercises = [(ex, p) for ex, p in exercises if (p.parent / "test").is_dir()]
    # sort by path
    exercises.sort(key=operator.itemgetter(1))
    exercises_with_dirnames = [
        ("{:03d}_{}".format(i, ex.header["title"].replace("/", "_")), ex, p) for i, (ex, p) in enumerate(exercises)
    ]
    for dirname, exercise, path in exercises_with_dirnames:
        exout = outdir / dirname
        print(f"Adding exercise {exout}")
        shutil.copytree(path.parent, exout, dirs_exist_ok=True)
        # move solutions to "src" subfolder
        if not args.add_solutions:
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
        (exout / path.name).write_text(exercise.description, encoding="utf-8")
