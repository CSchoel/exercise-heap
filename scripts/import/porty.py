#!/bin/env python3
# Porty, your friendly import bot

import argparse
import sys
import os
from pathlib import Path
import json

if __name__ == "__main__":
    parser = argparse.ArgumentParser(prog="Porty", description="Your friendly import bot")
    subparsers = parser.add_subparsers()

    # ./porty.py import
    import_parser = subparsers.add_parser("import")

    # ./porty.py update
    update_parser = subparsers.add_parser("update")

    args = parser.parse_args(sys.argv[1:])

    # save event data
    event = json.loads(Path(os.environ["GITHUB_EVENT_PATH"]).read_text("utf-8"))
    print(event)
