#!/usr/bin/env python3
"""Extract exercise from structured ChatGPT response.

Expects the following format:

<exercise>
<description>
Markdown description
</description>
<unittest>

```python
# Code implementing a unit test.
```

</unittest>
<example_solution>

```python
# Code implementing an example solution
```
</example_solution>
</exercise>
"""

import argparse
from pathlib import Path
import re
import textwrap


def parse_file(path: Path, output_directory: Path):
    text = path.read_text("utf-8")
    template = textwrap.dedent(
        r"""
        <exercise>
        <description>
        (?P<description>.*)
        </description>
        <unittest>\s*
        ```python
        (?P<unittest>.*)
        ```\s*
        </unittest>
        <example_solution>\s*
        ```python
        (?P<example_solution>.*)
        ```\s*
        </example_solution>
        </exercise>
        """
    ).strip()
    match = re.match(template, text, re.S)
    if match is None:
        print("------- ERROR: File does not match pattern -------")
        print(text)
        print("--------------------------------------------------")
        return
    exercise_name = path.stem
    if exercise_name.endswith("_raw"):
        exercise_name = exercise_name[: -len("_raw")]
    exercise_dir = output_directory / exercise_name
    exercise_dir.mkdir(parents=True, exist_ok=True)
    (exercise_dir / "test").mkdir(parents=True, exist_ok=True)
    (exercise_dir / "sol").mkdir(parents=True, exist_ok=True)
    parts = match.groupdict()
    (exercise_dir / f"{exercise_name}.md").write_text(
        parts["description"], encoding="utf-8"
    )
    python_file_name = re.search(r"`(\w+)\.py`", parts["description"])
    if python_file_name is None:
        python_file_name = f"{exercise_name}.py"
    else:
        python_file_name = f"{python_file_name.group(1)}.py"
    (exercise_dir / "test" / f"test_{python_file_name}").write_text(
        parts["unittest"], encoding="utf-8"
    )
    (exercise_dir / "sol" / python_file_name).write_text(
        parts["example_solution"], encoding="utf-8"
    )


if __name__ == "__main__":
    parser = argparse.ArgumentParser(prog="chatgpt-extract", description=__doc__)
    parser.add_argument(
        "raw_files", type=Path, help="Raw files with ChatGPT responses as a glob"
    )
    parser.add_argument(
        "--output-directory",
        "-o",
        type=Path,
        default=None,
        help="Directory where to write the exercises to.",
    )
    args = parser.parse_args()
    if args.raw_files.is_absolute():
        base_path = Path("/")
        glob = str(Path(*args.raw_files.parts[1:]))
    else:
        base_path = Path()
        glob = str(args.raw_files)
    for file in base_path.glob(glob):
        parse_file(
            file,
            output_directory=(
                args.output_directory
                if args.output_directory is not None
                else file.parent
            ),
        )
