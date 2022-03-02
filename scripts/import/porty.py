#!/bin/env python3
# Porty, your friendly import bot

import argparse
import sys

if __name__ == "__main__":
    parser = argparse.ArgumentParser(prog="Porty", description="Your friendly import bot")
    subparsers = parser.add_subparsers()

    # ./porty.py import
    import_parser = subparsers.add_parser("import")

    # ./porty.py update
    update_parser = subparsers.add_parser("update")

    args = parser.parse_args(sys.argv[1:])
