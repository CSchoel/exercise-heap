"""Translate exercise text into another language using language models."""

from transformers import AutoModelForSeq2SeqLM, AutoTokenizer

class Translator:
    """Translate text from one language into another."""

    def __init__(self, model_name="facebook/nllb-200-distilled-600M", src_lang="ron_Latn"):
        """Create new Translator loading a model for NMT from huggingface transformers.

        Args:
            model_name (str, optional): Name of the model to load from huggingface
            src_lang (str, optional): Language (BCP 47) of source texts that will be translated with this model
        """
        self.tokenizer = AutoTokenizer.from_pretrained(model_name, use_auth_token=True, src_lang="ron_Latn")
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
        

if __name__ == "__main__":
    # run example from https://github.com/facebookresearch/fairseq/tree/nllb
    translator = Translator(model_name="facebook/nllb-200-distilled-600M", src_lang="ron_Latn")

    article = "Şeful ONU spune că nu există o soluţie militară în Siria"
    res = translator.translate(article, target_lang="deu_Latn")
    print(res)
