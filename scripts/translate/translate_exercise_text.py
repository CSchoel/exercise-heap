"""Translate exercise text into another language using language models."""

from pathlib import Path
from typing import Dict, Any, Optional
import shutil
import uuid

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
        target_lang: str,
        tokenizer_args: Optional[Dict[str, Any]] = None,
        model_args: Optional[Dict[str, Any]] = None,
        generate_args: Optional[Dict[str, Any]] = None,
    ):
        """Create a new translator using a huggingface AutoModelForSeq2SeqLM.

        Args:
            model_name: name of the model to load from huggingface
            target_lang: IETF language tag with subtag of language to translate into.
            tokenizer_args: extra arguments to pass to the tokenizer constructor.
            model_args: extra arguments to pass to the model constructor.
            generate_args: extra arguments to pass to the huggingface generate() method
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
        self.target_lang = target_lang

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

    def __init__(self, source_lang: str = "de-DE", target_lang: str = "en-US"):
        """Creates new translator with specified languages.

        Args:
            source_lang (str, optional): Source language (IETF with subtag, e.g. de-DE)
            target_lang (str, optional): Target language (IETF with subtag, e.g. en-US)
        """
        model_name = f"Helsinki-NLP/opus-mt-{source_lang.split('-')[0]}-{target_lang.split('-')[0]}"
        super().__init__(model_name, target_lang=target_lang)


class NLLBTranslator(Translator):
    """Translate text from one language into another."""

    IETF_TO_BCP47 = {"de-DE": "deu_Latn", "ro": "ron_Latn", "en-US": "eng_Latn"}

    def __init__(
        self,
        model_name: str = "facebook/nllb-200-distilled-600M",
        source_lang: str = "de-DE",
        target_lang: str = "en-US",
    ):
        """Create new Translator loading a model for NMT from huggingface.

        Args:
            model_name (str, optional): Name of the model to load \
                from huggingface
            source_lang (str, optional): Language (IETF with subtag) of source texts \
                that will be translated with this model
            target_lang (str, optional): Language (IETF with subtag) into which the
                model should translate its inputs
        """
        generate_args = dict(forced_bos_token_id=self.tokenizer.lang_code_to_id[target_lang])
        super().__init__(
            model_name,
            target_lang=NLLBTranslator.IETF_TO_BCP47[target_lang],
            tokenizer_args={"source_lang": source_lang},
            generate_args=generate_args,
        )


def translate_exercise(path: str | Path, translator: Translator):
    """Translate an exercise from one language to another.

    Args:
        path (str | Path): Path to the exercise text.
        translator: The translator to use
    """
    path = Path(path)
    translated_folder = path.parents[1] / f"{path.parent.name}_{translator.target_lang}"
    # if translated_folder.exists():
    #    raise ValueError(f"Path {translated_folder} alreay exists, I wont overwrite the files there.")
    shutil.rmtree(translated_folder)
    shutil.copytree(path.parent, translated_folder)
    translated_file = translated_folder / path.name

    with exercise_editing(Path(translated_file), dry_run=True) as ex:
        ex.header["title"] = translator.translate(ex.header["title"])
        ex.header["lang"] = translator.target_lang
        ex.header["keywords"].append({"translated-from": ex.header["id"]})
        ex.header["id"] = str(uuid.uuid4())
        sentences = [sent for line in ex.description.splitlines() for sent in sent_tokenize(line, language="german")]
        translate_description(ex.description, translator)
        for s in sorted(sentences, key=len, reverse=True):
            translated = translator.translate(s)
            ex.description = ex.description.replace(s.strip(), translated.strip())


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
    # TODO should we do this with a pandoc filter or use a different library for parsing markdown?
    # TODO do we even need this?

    def translator_func(elem: pf.Element, doc: pf.Doc):
        # if isinstance(elem.content, pf.ListContainer):
        #     count_str = sum(1 for x in elem.content.list if isinstance(x, pf.Str))
        #     if count_str > len(elem.content.list) / 2:
        #         pass
        # translator.translate(elem)
        pass

    return apply_pandoc_filter(markdown, translator_func)


if __name__ == "__main__":
    FROM_LANGUAGE = "de_Latn"
    # _translator = NLLBTranslator(model_name="facebook/nllb-200-distilled-600M", source_lang="de_Latn", target_lang="en_Latn")
    _translator = HelsinkiNLPTranslator(source_lang="de-DE", target_lang="en-US")
    translate_exercise(
        "exercises/2021/Grundlagen der Informatik (BI Master)/01_01_helloworld/helloworld.md",
        _translator,
        # to_language="eng_Latn",
    )
