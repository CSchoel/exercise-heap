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
import io
import traceback
import re
from typing import Tuple

import yaml
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

def gh_userinfo(user):
    """
    Retrieves name of user that triggered an event from GitHub API
    """
    url = user["url"]
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
    yaml.safe_dump(header, temp_head)
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
    yaml.safe_dump(header, text)
    return text.getvalue()

def git_setuser(dry=False):
    """
    Sets the username and email used for Porty commits
    """
    maybe_run(["git", "config", "user.name", "Porty[bot]"], dry=dry)
    maybe_run([
        "git", "config", "user.email",
        "41898282+github-actions[bot]@users.noreply.github.com"
    ], dry=dry)

def git_commit_as(name, email, remote_branch, message, dry=False):
    """
    Commits and pushes all changed files on behalf of a given user
    """
    maybe_run(["git", "add", "."], dry=dry)
    maybe_run([
        'git', 'commit',
        "--author", f"{name} <{email}>",
        '-m', message
    ], dry=dry)
    maybe_run(["git", "push", "origin", remote_branch], dry=dry)

def create_pr(event, github_token, dry=False):
    """
    Creates a pull request from the content of the issue that triggered
    this function call.
    """
    title = event["issue"]["title"]
    name, email = gh_userinfo(event["issue"]["user"])
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
    branch_name = f"import#{number}"
    maybe_run(["git", "checkout", "-b", branch_name], dry=dry)
    git_setuser(dry=dry)
    git_commit_as(name, email, branch_name, f"import {title}")
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

def find_exfile(event, dry=False) -> Tuple[Path, str]:
    """
    Finds newly committed exercise file from git logs
    """
    if not "pull_request" in event:
        raise ValueError("This issue is not a pull request!")
    pullurl = event["pull_request"]["url"]
    pull = requests.get(pullurl).json()

    base = pull["base"]["ref"]
    head = pull["head"]["ref"]
    maybe_run(["git", "fetch"], dry=dry)
    maybe_run(["git", "checkout", head], dry=dry)
    out = maybe_run(["git", "diff", f"{base}..{head}", "--name-only"], dry=dry, capture_output=True)
    if dry:
        out = "exercises/this/is_a/dry/run.md"
    filename = [x for x in out.splitlines() if re.match(r"exercises\/.+\/.+\/.+\/.+\.md", x)]
    if len(filename) == 0:
        raise ValueError(f"Could not find exercise name in changed files: {','.join(out.splitlines())}")
    return Path(filename[0]), head

def porty_comment(msg: str, issue_url: str, gh_token: str, dry: bool=False):
    """
    Creates a comment by porty with the given message
    """
    gh_env = {
        "GITHUB_TOKEN": gh_token,
        "PATH": os.environ["PATH"]
    }
    maybe_run(["gh", "issue", "comment", issue_url, "-b", msg], env=gh_env, dry=dry)


def update(event, github_token, dry=False):
    """
    Updates YAML metadata based on comment
    """
    name, email = gh_userinfo(event["sender"])
    issue_url = event["issue"]["issue_url"]
    try:
        exfile, branch = find_exfile(event["issue"], dry=dry)
    except ValueError:
        msg = textwrap.dedent(f"""
            There is something wrong with the pull request you are \
            sending this update request from:

            ```
            {traceback.format_exc()}
            ```
        """)
        porty_comment(msg, issue_url, github_token, dry=dry)
        return
    # extract quoted lines
    new_header = [x.strip() for x in event["comment"]["body"] if x.startswith(">")]

    # check if the comment contains a quoted block
    if len(new_header) == 0:
        msg = textwrap.dedent("""
            Sorry, I did not find a quoted passage in your comment. \
            Maybe you forgot to add `> ` in front of the code block \
            for the YAML or markdown content that I should update?
        """)
        porty_comment(msg, issue_url, github_token, dry=dry)
        return
    # check if the quoted block contains a code block
    if not new_header[0].startswith("```") or new_header[0][3:] not in ["yaml"]:
        msg = textwrap.dedent("""
            Sorry, the quoted block in your comment does not start \
            with a code block of the correct type. Please make sure \
            that you put `` ```yaml `` before the content that \
            you want me to update.
        """)
        porty_comment(msg, issue_url, github_token, dry=dry)
        return
    try:
        new_header = new_header[1:new_header.index("```")]
    except ValueError:
        msg = textwrap.dedent("""
            Hmm... something is wrong with your markdown. The \
            quoted block I found contains the start of a code block \
            but the closing `` ``` `` seems to be missing.
        """)
        porty_comment(msg, issue_url, github_token, dry=dry)
        return
    # check if the content of the code block is valid yaml
    try:
        sio = io.StringIO(os.linesep.join(new_header))
        data = yaml.safe_load(sio)
    except yaml.parser.ParserError:
        msg = textwrap.dedent(f"""
            You know, I'm just a simple bot, but that YAML content \
            does not look right to me. Here is what the parser has \
            to say about that:

            ```
            {traceback.format_exc()}
            ```
        """)
        porty_comment(msg, issue_url, github_token, dry=dry)
        return
    # check that mandatory fields are present in the new header
    mandatory = [
        "id",
        "author",
        "title",
        "keywords",
        "lang",
        "solution-size"
    ]
    missing = [k for k in mandatory if k not in data]
    if len(missing) > 0:
        msg = textwrap.dedent(f"""
            I can almost accept this update, but not quite. The \
            following keys are missing in the YAML header: \
            {','.join(missing)}.
        """)
        porty_comment(msg, issue_url, github_token, dry=dry)
        return
    new_header = ["---"] + new_header + ["---"]

    # switch to the correct branch
    maybe_run(["git", "fetch"], dry=dry)
    maybe_run(["git", "checkout", branch], dry=dry)

    # actually swap header content
    if not dry:
        old_content = exfile.read_text("utf-8").splitlines()
        hstart = old_content.index("---")
        hend = old_content.index("---", hstart + 1)
        new_content = old_content[:hstart] + new_header + old_content[hend+1:]
        exfile.write_text(os.linesep.join(new_content), encoding="utf-8")
    else:
        print(f"touch {str(exfile)}")

    # commit changes
    git_commit_as(name, email, branch, "updates YAML header")
    # message success
    msg = textwrap.dedent("""\
        Thanks for the correction. :bow: I have updated the \
        YAML header as you requested. :+1: \
    """)
    porty_comment(msg, issue_url, github_token, dry=dry)

if __name__ == "__main__":
    parser = argparse.ArgumentParser(prog="Porty", description="Your friendly import bot")
    parser.add_argument("--dry", "-d", action="store_true", help="do a dry run printing system calls instead of actuall performing them")
    subparsers = parser.add_subparsers(dest="action")

    # ./porty.py import
    import_parser = subparsers.add_parser("import")

    # ./porty.py update
    update_parser = subparsers.add_parser("update")

    args = parser.parse_args(sys.argv[1:])

    # save event data
    event = json.loads(Path(os.environ["GITHUB_EVENT_PATH"]).read_text("utf-8"))

    if args.action == "import":
        create_pr(event, os.environ["GITHUB_TOKEN"], dry=args.dry)
    elif args.action == "update":
        update(event, os.environ["GITHUB_TOKEN"], dry=args.dry)
