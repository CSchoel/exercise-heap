#!/bin/env python3
# Porty, your friendly import bot

import argparse
import sys
import os
from pathlib import Path
import json
import datetime
import subprocess

def create_pr(event, github_token):
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
    exdir = Path(f"exercises/{datetime.date.today.year}/{user}/{title}")
    exdir.mkdir(exist_ok=True, parents=True)
    (exdir / "exercise.md").write_text(body,"utf-8")
    git_env = {
        "GIT_AUTHOR_NAME": user,
        "GIT_AUTHOR_EMAIL": f"{user_id}+{user}@users.noreply.github.com",
        "GIT_COMITTER_NAME": "Porty",
        "GIT_COMITTER_EMAIL": "41898282+github-actions[bot]@users.noreply.github.com"
    }
    subprocess.run(f"git checkout -b import#{number}", check=True)
    subprocess.run("git add .", check=True)
    subprocess.run(['git', 'commit', '-m', f"import {title}"], env=git_env, check=True)
    subprocess.run(f"git push origin import#{number}", check=True)

    msg = "Hi, I am Porty, your friendly import bot. :wave: I have created the branch import#$NUMBER for you! :muscle:"
    subprocess.run(["gh", "issue", "comment", issue_url, "-b", msg], check=True)

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
