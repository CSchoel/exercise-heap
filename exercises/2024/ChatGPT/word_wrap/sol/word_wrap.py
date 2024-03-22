from typing import List
import textwrap

def word_wrap(text: str, columns: int) -> List[str]:
    return textwrap.wrap(text, width=columns)