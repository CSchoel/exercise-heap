"""Translate exercise text into another language using language models."""

from pathlib import Path
from typing import Dict, Any, Optional

from transformers import AutoModelForSeq2SeqLM, AutoTokenizer
from nltk.tokenize import sent_tokenize
import panflute as pf

from exercise_heap.header import exercise_editing
from exercise_heap.description import apply_pandoc_filter


class Translator:
    """Translate text from one language into another."""

    def __init__(
        self,
        model_name: str,
        tokenizer_args: Optional[Dict[str, Any]] = None,
        model_args: Optional[Dict[str, Any]] = None,
        generate_args: Optional[Dict[str, Any]] = None,
    ):
        """Create a new translator using a huggingface AutoModelForSeq2SeqLM.

        Args:
            model_name: name of the model to load from huggingface
            tokenizer_args: extra arguments to pass to the tokenizer constructor.
            model_args: extra arguments to pass to the model constructor.
        """
        if tokenizer_args is None:
            tokenizer_args = {}
        if model_args is None:
            model_args = {}
        if generate_args is None:
            generate_args = {}
        self.tokenizer = AutoTokenizer.from_pretrained(model_name, **tokenizer_args)
        self.model = AutoModelForSeq2SeqLM.from_pretrained(model_name, **model_args)
        self.generate_args = generate_args

    def translate(self, text: str) -> str:
        """Translate a text.

        Args:
            text (str): text that should be translated
            extra_args: arguments passed on to the generate() function

        Returns:
            str: translated text
        """
        inputs = self.tokenizer(text, return_tensors="pt")
        translated_tokens = self.model.generate(**inputs, **self.generate_args)
        res = self.tokenizer.batch_decode(translated_tokens, skip_special_tokens=True)[0]
        return res


class HelsinkiNLPTranslator(Translator):
    """Translate text from one language into another using an opus-mt model from HelsinkiNLP."""

    def __init__(self, source_lang: str = "de", target_lang: str = "en"):
        """Creates new translator with specified languages.

        Args:
            source_lang (str, optional): Source language. Defaults to "de".
            target_lang (str, optional): Target language. Defaults to "en".
        """
        model_name = f"Helsinki-NLP/opus-mt-{source_lang}-{target_lang}"
        super().__init__(model_name)


class NLLBTranslator(Translator):
    """Translate text from one language into another."""

    def __init__(
        self,
        model_name: str = "facebook/nllb-200-distilled-600M",
        source_lang: str = "ron_Latn",
        target_lang: str = "deu_Latn",
    ):
        """Create new Translator loading a model for NMT from huggingface.

        Args:
            model_name (str, optional): Name of the model to load \
                from huggingface
            source_lang (str, optional): Language (BCP 47) of source texts \
                that will be translated with this model
        """
        generate_args = dict(forced_bos_token_id=self.tokenizer.lang_code_to_id[target_lang])
        super().__init__(model_name, tokenizer_args={"source_lang": source_lang}, generate_args=generate_args)


def translate_exercise(path: str | Path, translator: Translator):
    """Translate an exercise from one language to another.

    Args:
        path (str | Path): Path to the exercise text.
        translator: The translator to use
    """
    with exercise_editing(Path(path), dry_run=True) as ex:
        ex.header["title"] = translator.translate(ex.header["title"])
        sentences = sent_tokenize(ex.description, language="german")
        for s in sentences:
            translated = translator.translate(s)
            print(translated)
            ex.description = ex.description.replace(s, translated)
        translate_description(ex.description, translator)


def translate_description(markdown: str, translator: Translator) -> str:
    """Translate a markdown-formatted exercise text from one language into another.

    This function is aware of the markdown format of the document and will preserve it
    as best as possible using Pandocs JSON-based AST format.

    Args:
        markdown (str): Exercise description as markdown-formatted string.
        translator: The translator to use to switch languages.

    Returns:
        str: Translated exercise description as markdown-formatted string.
    """

    def translator_func(elem: pf.Element, doc: pf.Doc):
        pass
        # translator.translate(elem)

    return apply_pandoc_filter(markdown, translator_func)


if __name__ == "__main__":
    FROM_LANGUAGE = "de_Latn"
    # _translator = NLLBTranslator(model_name="facebook/nllb-200-distilled-600M", source_lang=FROM_LANGUAGE)
    _translator = HelsinkiNLPTranslator(source_lang="de", target_lang="en")
    translate_exercise(
        "exercises/2021/Grundlagen der Informatik (BI Master)/01_01_helloworld/helloworld.md",
        _translator,
        # to_language="eng_Latn",
    )
