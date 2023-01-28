def sort_by_divisors(lst):
    lst.sort(key=lambda x: len([k for k in range(2,x) if x % k == 0]))

if __name__ == "__main__":
    lst = [1, 2, 12, 15, 13]
    sort_by_divisors(lst)
    print(lst)
    print([len([k for k in range(2,x) if x % k == 0]) for x in lst])
