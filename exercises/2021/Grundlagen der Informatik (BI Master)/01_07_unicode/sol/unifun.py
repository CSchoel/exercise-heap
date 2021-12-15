text = "100€ Öcken"

code_utf8 = text.encode("utf-8")
code_win = text.encode("cp1252")
code_mac = text.encode("macroman")
text_broken = text.encode("cp1252").decode("macroman")