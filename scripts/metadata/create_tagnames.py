#!/bin/env python3
"""
Creates list of tag names from Stack Exchange Data Dump
"""

import argparse
import sys
import lxml

if __name__ == "__main__":
    parser = argparse.ArgumentParser(prog="Tagname creator", description=__doc__)
    parser.add_argument("file")
    parser.add_argument("--mincount", "-c", help="minimum count required to add tag name", default=0, type=int)
    args = parser.parse_args(sys.argv[1:])
    print(args)