
def generate(x: int):
    result = (x*2 for x in range(x))
    return result


result = generate(265)