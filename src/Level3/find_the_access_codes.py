from collections import defaultdict

def divisors(x):
    d = list()
    i = 1
    while i*i <= x:
        if x % i == 0:
            d.append(i);
            if i*i != x: d.append(x//i)
        i += 1
    return sorted(d)
def answer(l):
    # your code here
    F, D = defaultdict(int), defaultdict(int)
    ans = 0
    for x in l:
        for d in divisors(x):
            ans  += D[d]
        for d in divisors(x):
            D[x] += F[d]
        F[x] += 1;
    return ans