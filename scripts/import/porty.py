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
import uuid
import yaml
import io

import requests

def fs_sanitize(string):
    """
    Sanitizes a string for use in the file system.
    """
    allowed = frozenset(" ._-=@")
    filtered = [c for c in string if c.isalnum() or c in allowed]
    return "".join(filtered)

def maybe_run(args, env=None, dry=False, capture_output=False):
    """
    Allows to switch between actually running a subprocess and
    doing a dry run that only prints the command.
    """
    if dry:
        print(shlex.join(args))
        if capture_output:
            return ""
    else:
        try:
            res = subprocess.run(args, env=env, check=True, capture_output=capture_output, text=True)
        except subprocess.CalledProcessError as err:
            print(err.stdout, file=sys.stdout)
            print(err.stderr, file=sys.stderr)
            raise
        if capture_output:
            return res.stdout

def gh_userinfo(event):
    """
    Retrieves name of user that triggered an event from GitHub API
    """
    url = event["issue"]["user"]["url"]
    data = requests.get(url).json()
    name = data["name"] if data["name"] is not None else data["login"]
    email = data["email"] if data["email"] is not None else f"{data['id']}+{data['login']}@users.noreply.github.com"
    return name, email

def create_header(title, name, body):
    """
    Creates a YAML header for a new exercise
    """
    header = {}
    header["title"] = title
    header["author"] = [ name, "Porty[bot]" ]
    header["lang"] = "de-DE"
    # estimate solution size by size of exercise text
    header["solution-size"] = len(body.splitlines())
    header["id"] = str(uuid.uuid4())
    header["keywords"] = []

    # call suggest_tags script to get a set of tags
    temp_head = io.StringIO()
    yaml.dump(header, temp_head)
    tempfile = Path(".portys_tempfile_dont_touch")
    tempfile.write_text(os.linesep.join(["---", temp_head.getvalue(), "---", body]), encoding="utf-8")
    suggest = Path(__file__).parent.parent / "metadata" / "suggest_tags.py"
    try:
        res = subprocess.run(["python3", suggest, tempfile], check=True, capture_output=True, text=True)
        print(res.stdout)
    except subprocess.CalledProcessError as err:
        print(err.stdout, file=sys.stdout)
        print(err.stderr, file=sys.stderr)
        raise
    tags = Path("tags_to_add.txt").read_text("utf-8")
    tags = [x.split(":", maxsplit=1) for x in tags.splitlines()]
    tags = [{ k.strip(): v.strip()} for k,v in tags]
    header["keywords"] = tags
    text = io.StringIO()
    yaml.dump(header, text)
    return text.getvalue()

def create_pr(event, github_token, dry=False):
    """
    Creates a pull request from the content of the issue that triggered
    this function call.
    """
    title = event["issue"]["title"]
    name, email = gh_userinfo(event)
    login = event["issue"]["user"]["login"]
    number = event['issue']['number']
    body = event["issue"]["body"]
    header = create_header(title, name, body)
    body = os.linesep.join(["---", header, "---", body])
    issue_url = event["issue"]["html_url"]
    exdir = (
        Path("exercises")
        / str(datetime.date.today().year)
        / login
        / "_".join([str(number).rjust(3, '0'), fs_sanitize(title)])
    )
    if not dry:
        exdir.mkdir(exist_ok=True, parents=True)
        (exdir / "exercise.md").write_text(body,"utf-8")
    else:
        print(f"mkdir -p {exdir}")
        print(f"touch {exdir / 'exercise.md'}")
        print(body)
    gh_env = {
        "GITHUB_TOKEN": github_token,
        "PATH": os.environ["PATH"]
    }
    maybe_run(["git", "config", "user.name", "Porty[bot]"], dry=dry)
    maybe_run([
        "git", "config", "user.email",
        "41898282+github-actions[bot]@users.noreply.github.com"
    ], dry=dry)
    branch_name = f"import#{number}"
    maybe_run(["git", "checkout", "-b", branch_name], dry=dry)
    maybe_run(["git", "add", "."], dry=dry)
    maybe_run([
        'git', 'commit',
        "--author", f"{name} <{email}>",
        '-m', f"import {title}"
    ], dry=dry)
    maybe_run(["git", "push", "origin", branch_name], dry=dry)

    msg = textwrap.dedent(f"""
        Hey, Porty the import bot here. I have created this pull \
        request from issue #{number} for you. Currently you can \
        only accept it as is, but in the future I will learn to \
        do some updates if you are not happy right away. :student:
    """)
    pr_url = maybe_run([
        "gh", "pr", "create", "-d", "--title", f"Import: {title}",
        "--body", msg
    ], dry=dry, env=gh_env, capture_output=True)

    msg = textwrap.dedent(f"""
        Hi, I am Porty, your friendly import bot. :wave: \
        I have created the branch {branch_name} for you! :muscle:

        See you at the corresponding pull request: {pr_url.strip()}. :smile:
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
    print(gh_userinfo(event))
