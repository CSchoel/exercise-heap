"""Translate exercise text into another language using language models."""

from pathlib import Path
from typing import Dict, Any, Optional

from transformers import AutoModelForSeq2SeqLM, AutoTokenizer

from exercise_heap.header import exercise_editing
from nltk.tokenize import sent_tokenize


class Translator:
    """Translate text from one language into another."""

    def __init__(
        self,
        model_name: str,
        tokenizer_args: Optional[Dict[str, Any]] = None,
        model_args: Optional[Dict[str, Any]] = None,
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
        self.tokenizer = AutoTokenizer.from_pretrained(model_name, **tokenizer_args)
        self.model = AutoModelForSeq2SeqLM.from_pretrained(model_name, **model_args)

    def translate(self, text: str, **extra_args) -> str:
        """Translate a text.

        Args:
            text (str): text that should be translated
            extra_args: arguments passed on to the generate() function

        Returns:
            str: translated text
        """
        inputs = self.tokenizer(text, return_tensors="pt")
        translated_tokens = self.model.generate(**inputs, **extra_args)
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

    def __init__(self, model_name: str = "facebook/nllb-200-distilled-600M", source_lang: str = "ron_Latn"):
        """Create new Translator loading a model for NMT from huggingface.

        Args:
            model_name (str, optional): Name of the model to load \
                from huggingface
            source_lang (str, optional): Language (BCP 47) of source texts \
                that will be translated with this model
        """
        super().__init__(model_name, tokenizer_args={"source_lang": source_lang})

    def translate(self, text: str, **extra_args) -> str:
        """Translate a text to a target language.

        Args:
            text (str): target language as defined in

        Kwargs:
            target_lang (str, optional): target language (BCP 47). Defaults to "deu_Latn".

        Returns:
            str: translated sentence
        """
        target_lang = "deu_Latn" if "target_lang" not in extra_args else extra_args["target_lang"]
        return super().translate(text, forced_bos_token_id=self.tokenizer.lang_code_to_id[target_lang])


def translate_exercise(path: str | Path, translator: Translator, **extra_args):
    """Translate an exercise from one language to another.

    Args:
        path (str | Path): Path to the exercise text.
        from_language (str, optional): Source language. Defaults to "de_Latn".
        to_language (str, optional): Target language. Defaults to "eng_Latn".
    """
    with exercise_editing(Path(path), dry_run=True) as ex:
        ex.header["title"] = translator.translate(ex.header["title"], **extra_args)
        sentences = sent_tokenize(ex.description, language="german")
        for s in sentences:
            translated = translator.translate(s, **extra_args)
            print(translated)
            ex.description = ex.description.replace(s, translated)


if __name__ == "__main__":
    FROM_LANGUAGE = "de_Latn"
    # _translator = NLLBTranslator(model_name="facebook/nllb-200-distilled-600M", source_lang=FROM_LANGUAGE)
    _translator = HelsinkiNLPTranslator(source_lang="de", target_lang="en")
    translate_exercise(
        "exercises/2021/Grundlagen der Informatik (BI Master)/01_01_helloworld/helloworld.md",
        _translator,
        # to_language="eng_Latn",
    )
