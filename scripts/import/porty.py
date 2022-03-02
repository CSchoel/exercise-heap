#!/bin/env python3
# Porty, your friendly import bot

import argparse
import sys

if __name__ == "__main__":
    parser = argparse.ArgumentParser(prog="Porty", description="Your friendly import bot")

    # ./porty.py import
    import_parser=argparse.ArgumentParser()

    # ./porty.py update
    update_parser=argparse.ArgumentParser()

    subparsers = parser.add_subparsers()
    subparsers.add_parser("import", import_parser)
    subparsers.add_parser("update", update_parser)
    args = parser.parse_args(sys.argv[1:])
