#!/bin/env python3
"""
Porty, your friendly import bot
"""

import argparse
import sys
import os
from pathlib import Path
import json
import datetime
import subprocess
import textwrap
import shlex

def fs_sanitize(string):
    """
    Sanitizes a string for use in the file system.
    """
    allowed = frozenset(" ._-=@")
    filtered = [c for c in string if c.isalnum() or c in allowed]
    return "".join(filtered)

def maybe_run(args, env=None, dry=False):
    """
    Allows to switch between actually running a subprocess and
    doing a dry run that only prints the command.
    """
    if dry:
        print(shlex.join(args))
    else:
        subprocess.run(args, env=env, check=True)

def create_pr(event, github_token, dry=False):
    """
    Creates a pull request from the content of the issue that triggered
    this function call.
    """
    title = event["issue"]["title"]
    user = event["issue"]["user"]["login"]
    user_id = event["issue"]["user"]["id"]
    number = event['issue']['number']
    body = event["issue"]["body"]
    issue_url = event["issue"]["html_url"]
    exdir = Path(f"exercises/{datetime.date.today().year}/{user}/{str(number).rjust(3, '0')}_{fs_sanitize(title)}")
    if not dry:
        exdir.mkdir(exist_ok=True, parents=True)
        (exdir / "exercise.md").write_text(body,"utf-8")
    else:
        print(f"mkdir -p {exdir}")
        print(f"touch {exdir / 'exercise.md'}")
    git_env = {
        "GIT_AUTHOR_NAME": user,
        "GIT_AUTHOR_EMAIL": f"{user_id}+{user}@users.noreply.github.com",
        "GIT_COMITTER_NAME": "Porty",
        "GIT_COMITTER_EMAIL": "41898282+github-actions[bot]@users.noreply.github.com"
    }
    gh_env = {
        "GITHUB_TOKEN": github_token
    }
    maybe_run(["git", "checkout", "-b", f"import#{number}"], dry=dry)
    maybe_run(["git", "add", "."], dry=dry)
    maybe_run(['git', 'commit', '-m', f"import {title}"], env=git_env, dry=dry)
    maybe_run(["git", "push", "origin", "import#{number}"], dry=dry)

    msg = textwrap.dedent("""
        Hi, I am Porty, your friendly import bot. :wave:
        I have created the branch import#$NUMBER for you! :muscle:

        P.S.: I speak Python now. :snake:
    """)
    maybe_run(["gh", "issue", "comment", issue_url, "-b", msg], env=gh_env, dry=dry)

if __name__ == "__main__":
    parser = argparse.ArgumentParser(prog="Porty", description="Your friendly import bot")
    subparsers = parser.add_subparsers(dest="action")

    # ./porty.py import
    import_parser = subparsers.add_parser("import")
    import_parser.add_argument("--dry", "-d", action="store_true", help="do a dry run printing system calls instead of actuall performing them")

    # ./porty.py update
    update_parser = subparsers.add_parser("update")

    args = parser.parse_args(sys.argv[1:])

    # save event data
    event = json.loads(Path(os.environ["GITHUB_EVENT_PATH"]).read_text("utf-8"))

    if args.action == "import":
        create_pr(event, os.environ["GITHUB_TOKEN"], dry=args.dry)
