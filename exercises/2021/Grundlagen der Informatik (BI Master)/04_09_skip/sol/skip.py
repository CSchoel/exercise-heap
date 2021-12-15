from typing import Iterable

def skip(n, iterable: Iterable):
    iterator = iter(iterable)

    # failing solution
    #tuple_iterator = enumerate(iterator)
    #filter_iterator = filter(lambda x: x[0] >= n, tuple_iterator)
    #map_iterator =  map(lambda x: x[1], filter_iterator)
    #return map_iterator

    
    for i in range(n):
        next(iterator)
    for x in iterator:
        yield x