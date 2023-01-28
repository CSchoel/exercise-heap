"""Code for dealing with the description text of an exercise markdown file."""

import io
from typing import Callable

import pypandoc
import panflute as pf


def apply_pandoc_filter(description: str, func: Callable[[pf.Element, pf.Doc], None]):
    """Apply a structure-aware Pandoc filter to a markdown-formatted text.

    Args:
        description (str): Markdown formatted text (without YAML header)
        func (Callable[[pf.Element, pf.Doc], None]): filter that is applied to each element within the Pandoc AST

    Returns:
        str: Markdown text after filter was applied. This may include other changes apart
             from the ones applied by the filter, since it has been parsed and reformatted by Pandoc.
    """
    markdown_format = "markdown+raw_tex"
    data = pypandoc.convert_text(description, to="json", format=markdown_format)
    doc = pf.load(io.StringIO(data))
    doc = pf.run_filter(func, doc=doc)
    output = io.StringIO()
    pf.dump(doc, output)
    json_result = output.getvalue()
    markdown_result = pypandoc.convert_text(json_result, to=markdown_format, format="json")
    return markdown_result
