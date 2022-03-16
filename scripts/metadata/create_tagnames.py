#!/bin/env python3
"""
Creates list of tag names from Stack Exchange Data Dump
"""

import argparse
import sys
from pathlib import Path
from typing import List
import glob
import re
import lxml.etree

def exclude_common(tags: List[str], exdir: Path, commonness: int) -> List[str]:
    """
    Removes tags in ``tags`` that occur in more than ``commonness`` percent
    of the exercise description files in ``exdir``.
    """
    counts = {}
    exfiles = list(glob.glob(exdir / "*" / "*" / "*" / "*.md"))
    total = len(exfiles)
    for ex in exfiles:
        text = ex.read_text("utf-8")
        for t in tags:
            if len(re.findall(r"\b%s\b" % re.escape(t), text)) > 0:
                counts.setdefault(t, 0)
                counts[t] += 1
    uncommon = [t for t in tags if counts.get(t, 0) < commonness / 100 * total]
    return uncommon

if __name__ == "__main__":
    parser = argparse.ArgumentParser(prog="Tagname creator", description=__doc__)
    parser.add_argument("file")
    parser.add_argument(
        "--mincount", "-c",
        help="minimum count required to add tag name",
        default=0, type=int
    )
    parser.add_argument(
        "--commonness", "-C",
        help="exclude tags that occur with at least the given commonness percentage"
    )
    parser.add_argument(
        "--exdir", "-e",
        help="exercise dir to use for --commonness,-c argument",
        default=Path(__file__).parent.parent.parent / "exercises"
    )
    args = parser.parse_args(sys.argv[1:])
    data = lxml.etree.parse(args.file)
    tags = data.xpath(f"//row[@Count>{args.mincount}]/@TagName")
    tags = [x.replace("-", " ") for x in tags]
    if args.commonness is not None:
        tags = exclude_common(tags, args.exdir, args.commonness)
    print(*tags, sep="\n")
