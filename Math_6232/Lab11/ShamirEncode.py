import random
import functools

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

_RINT = functools.partial(random.SystemRandom().randint, 0)
_PRIME = Validation("Enter a prime number: ", 1000, 2000)
_SECRET = Validation("Enter secret: ", 0, _PRIME - 1)
_NUMBER_SHARES = Validation("Enter number of shares: ", 1, 100)
_THRESHOLD = Validation("Enter threshold: ", 1, _NUMBER_SHARES)

def _eval_at(poly, x, prime):
    accumulate = 0
    for i in reversed(poly):
        accumulate *= x
        accumulate += i
        accumulate %= prime
    return accumulate

def Make_random_shares(secret, min, number_shares, prime=_PRIME):
    if(min > number_shares):
        raise ValueError("Pool secret would be irrecoverable.")
    poly = [secret]+[_RINT(prime-1)for i in range(min-1)]
    shares = [(i, _eval_at(poly, i, prime)) for i in range(1, number_shares+1)]
    return shares, poly

_SHARES, _POLYNOMIAL = Make_random_shares(_SECRET, _THRESHOLD, _NUMBER_SHARES)

print("Shares:", _SHARES)
print("Polynomial:", _POLYNOMIAL)
