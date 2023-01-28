def my_map(func, iterable):
    result = []
    for i in iterable:
         result.append(func(i))
    return result

fun = lambda x: x * 42
l = [1, 2, 3]

result = my_map(fun, l)
