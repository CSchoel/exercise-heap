"""Code that works with YAML headers."""

from pathlib import Path
from typing import Dict, Any, Optional
import io
import os
import re
from contextlib import contextmanager

import ruamel.yaml


def get_header(exfile: Path, and_rest=False) -> str:
    text = exfile.read_text(encoding="utf-8")
    header = re.search(r"^---$(.+?)^---$", text, flags=re.M | re.S)
    if header is None:
        raise Exception(f"{exfile} does not contain a YAML header")
    if header.start() != 0:
        raise Exception(f"{exfile} has a YAML block, which is not at the beginning of the file but at postion {header.start()}")
    if and_rest:
        return header.group(1), text[len(header.group(0))+1:]
    else:
        return header.group(1)


def load_header(exfile: Path, for_editing: bool = False) -> Dict[str, Any]:
    """Load a header as a structured object.

    Returns:
        _type_: _description_
    """
    yaml_engine = ruamel.yaml.YAML(typ="safe", pure=True)
    header_res = get_header(exfile, and_rest=for_editing)
    if for_editing:
        header, rest = header_res
        loaded_header = yaml_engine.load(header)
        return loaded_header, rest, yaml_engine
    else:
        loaded_header = yaml_engine.load(header_res)
        return loaded_header


@contextmanager
def header_editing(exfile: Path, outfile: Optional[Path] = None, dry_run=False):
    if outfile is None:
        outfile = exfile
    header, rest, yaml = load_header(exfile, for_editing=True)
    yield header
    temp = io.StringIO()
    yaml.dump(header, temp)
    new_header = os.linesep.join(["---", str(temp), "---"])
    new_text = new_header + rest
    if dry_run:
        print(new_text)
    else:
        outfile.write_text(new_text)
