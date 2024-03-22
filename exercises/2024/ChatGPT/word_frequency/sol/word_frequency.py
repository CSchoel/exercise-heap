def word_frequency(text: str) -> dict:
    word_list = text.lower().split()
    frequency_dict = {}
    for word in word_list:
        frequency_dict[word] = frequency_dict.get(word, 0) + 1
    return frequency_dict