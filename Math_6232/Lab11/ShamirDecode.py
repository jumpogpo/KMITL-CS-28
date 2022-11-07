def Validation(message, min, max):
    while True:
        try:
            _INPUT = int(input(message))
            if _INPUT < min or _INPUT > max:
                raise ValueError
            break
        except ValueError:
            print("Invalid input. Please try again.")
            _INPUT = message
    return _INPUT

_PRIME = Validation("Enter a prime number: ", 1000, 2000)
_NUMBER_SHARES = Validation("Enter number of shares: ", 1, 100)
_THRESHOLD = Validation("Enter threshold: ", 1, _NUMBER_SHARES)
_SHARES = []
print("\nFormat shares: (x, y)")

for i in range(_NUMBER_SHARES):
    _SHARE = input(f"Enter share #{i+1}: ")
    _SHARE = _SHARE.split(",")
    _SHARE = [int(i) for i in _SHARE]
    _SHARES.append(_SHARE)

def Extended_GCD(a, b):
    x = 0
    last_x = 1
    y = 1
    last_y = 0
    while b != 0:
        quot = a // b
        a, b = b, a % b
        x, last_x = last_x - quot * x, x
        y, last_y = last_y - quot * y, y
    return last_x, last_y


def DivMod(num, den, p):
    inv, _ = Extended_GCD(den, p)
    return num * inv

def Lagrange_interpolate(x, x_s, y_s, p):
    k = len(x_s)
    assert k == len(set(x_s))

    def PI(vals):
        accumulate = 1
        for v in vals:
            accumulate *= v
        return accumulate
    nums = []
    dens = []
    for i in range(k):
        others = list(x_s)
        cur = others.pop(i)
        nums.append(PI(x-o for o in others))
        dens.append(PI(cur-o for o in others))
    den = PI(dens)
    num = sum([DivMod(nums[i] * den * y_s[i] % p, dens[i], p)
              for i in range(k)])
    return (DivMod(num, den, p)+p) % p

def Reconstruct_secret(shares, prime=_PRIME):
    x_s, y_s = zip(*shares)
    return Lagrange_interpolate(0, x_s, y_s, prime)

_SECRET = Reconstruct_secret(_SHARES)
print(f"\nSecret: {_SECRET}")
