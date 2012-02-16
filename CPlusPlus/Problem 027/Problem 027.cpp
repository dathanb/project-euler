/*
Project Euler
Problem 27

"Euler published the remarkable quadratic formula "n^2+n+41".

It turns out that the formula will produce 40 consecutive primes for the consecutive values n = 0 to 39.
However, when n=40, 40^2+40+41 - 40(40+1) + 41 is divisible by 41, and certainly when n = 41, 41^2+41+41
is clearly divisible by 41.

Using computers, the incredible formula n^2-79n+1601 was discovered, which produces 80 primes for the
consecutive values n=0 to 79.  The product of the coefficients, -79 and 1601, is -126479.

Considering quadratics of the form: n^2+an+b, where |a|<1000 and |b|<1000.

Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum
number of primes for consecutive values of n, starting with n=0."
*/

#include <iostream>
#include <vector>

int is_prime(int a);
int fermat_primality_test(int n, int certainty=10);

int main (void)
{
	int max = 0;
	int max_len = 0;

	for (int a=-999; a < 1000; ++a)
	{
		for (int b=-999; b < 1000; ++b)
		{
			int n;
			for (n=0; is_prime(n*n+a*n+b); ++n)
				;// do nothing
			if (n > max_len)
			{
				max_len = n;
				max = a*b;
			}
		}
		std::cout << a << '\t' << max_len << '\t' << max << std::endl;
	}

	std::cout << max << std::endl;
	return 0;
}

