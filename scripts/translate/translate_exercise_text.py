"""Translate exercise text into another language using language models."""

from pathlib import Path

from transformers import AutoModelForSeq2SeqLM, AutoTokenizer

from exercise_heap.header import header_editing


class Translator:
    """Translate text from one language into another."""

    def __init__(
        self, model_name: str = "facebook/nllb-200-distilled-600M",
        source_lang: str = "ron_Latn"
    ):
        """Create new Translator loading a model for NMT from huggingface.

        Args:
            model_name (str, optional): Name of the model to load \
                from huggingface
            source_lang (str, optional): Language (BCP 47) of source texts \
                that will be translated with this model
        """
        self.tokenizer = AutoTokenizer.from_pretrained(
            model_name, use_auth_token=True, source_lang=source_lang
        )
        self.model = AutoModelForSeq2SeqLM.from_pretrained(model_name, use_auth_token=True)

    def translate(self, text: str, target_lang="deu_Latn"):
        """Translate a text to a target language.

        Args:
            text (str): target language as defined in
            target_lang (str, optional): _description_. Defaults to "deu_Latn".

        Returns:
            _type_: _description_
        """
        inputs = self.tokenizer(text, return_tensors="pt")

        translated_tokens = self.model.generate(
            **inputs, forced_bos_token_id=self.tokenizer.lang_code_to_id[target_lang], max_length=30
        )
        res = self.tokenizer.batch_decode(translated_tokens, skip_special_tokens=True)[0]
        return res


def translate_exercise(path: str | Path, from_language="de_Latn", to_language="eng_Latn"):
    """Translate an exercise from one language to another.

    Args:
        path (str | Path): Path to the exercise text.
        from_language (str, optional): Source language. Defaults to "de_Latn".
        to_language (str, optional): Target language. Defaults to "eng_Latn".
    """
    translator = Translator(
        model_name="facebook/nllb-200-distilled-600M", source_lang=from_language
    )
    with header_editing(Path(path), dry_run=True) as header:
        header["title"] = translator.translate(header["title"], target_lang=to_language)


if __name__ == "__main__":
    translate_exercise(
        "exercises/2021/Grundlagen der Informatik (BI Master)/01_01_helloworld/helloworld.md",
        from_language="de_Latn",
        to_language="eng_Latn"
    )
