"""Code that works with YAML headers."""

from pathlib import Path
from typing import Dict, Any, Optional, Tuple
import io
import os
import re
from contextlib import contextmanager
from dataclasses import dataclass

import ruamel.yaml


def get_header(exfile: Path) -> str:
    return get_header_and_rest(exfile)[0]


def get_header_and_rest(exfile: Path) -> (str, str):
    text = exfile.read_text(encoding="utf-8")
    header = re.search(r"^---$(.+?)^---$", text, flags=re.M | re.S)
    if header is None:
        raise Exception(f"{exfile} does not contain a YAML header")
    if header.start() != 0:
        raise Exception(f"{exfile} has a YAML block, which is not at the beginning of the file but at postion {header.start()}")  # noqa: E501
    return header.group(1), text[len(header.group(0)) + 1:]


def load_header(exfile: Path, for_editing: bool = False) -> Dict[str, Any]:
    """Load a header as a structured object.

    Returns:
        _type_: _description_
    """
    yaml_engine = ruamel.yaml.YAML(typ="safe", pure=True)
    yaml_engine.preserve_quotes = True
    header = get_header(exfile)
    loaded_header = yaml_engine.load(header)
    return loaded_header

@dataclass
class ExerciseWithHeader:
    header: ruamel.yaml.YAMLObject
    description: str
    yaml_engine: ruamel.yaml.YAML

    def __str__(self):
        temp = io.StringIO()
        self.yaml_engine.dump(self.header, temp)
        return os.linesep.join(["---", temp.getvalue(), "---"]) + self.description


def load_header_for_editing(exfile: Path) -> ExerciseWithHeader:
    yaml_engine = ruamel.yaml.YAML(typ="safe", pure=True)
    yaml_engine.preserve_quotes = True
    header, rest = get_header_and_rest(exfile)
    loaded_header = yaml_engine.load(header)
    return ExerciseWithHeader(loaded_header, rest, yaml_engine)


@contextmanager
def exercise_editing(exfile: Path, outfile: Optional[Path] = None, dry_run=False):
    if outfile is None:
        outfile = exfile
    ex = load_header_for_editing(exfile)
    yield ex
    new_text = str(ex)
    if dry_run:
        print(new_text)
    else:
        outfile.write_text(new_text)



@contextmanager
def header_editing(exfile: Path, outfile: Optional[Path] = None, dry_run=False):
    with exercise_editing(exfile, outfile=outfile, dry_run=dry_run) as ex:
        yield ex.header