def answer(M, F):
    # your code here
    m = int(M)
    f = int(F)
    if m*f ==0:
        return "impossible"
    g=gcd(m,f)
    if g!=1 and (abs(m-f)%g==0):
        return "impossible"
    return str(ans_gen(m,f))
def ans_gen(m,f):
    if m==1:
        return f-1
    elif f==1:
        return m-1
    else:
        if m<f:
            return ans_gen(f,m)
        else:
            return (m/f)+ans_gen(m-m/f*f,f)

def gcd(x,y):
    if(y==0):
        return x
    else:
        return  gcd(y,x%y)


