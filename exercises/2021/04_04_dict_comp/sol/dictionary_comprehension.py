from typing import List, Dict

sentence = "the quick brown fox jumps over the lazy dog"

def make_dict(sentence: str) -> Dict[str, int]:
    result = {w: len(w) for w in sentence.split() if w != "the"}
    return result

result = make_dict(sentence)