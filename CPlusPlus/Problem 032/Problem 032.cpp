/*
Project Euler
Problem 32

The product 7254 is unusual, as the identity, 39 x 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.

Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
*/

#include <iostream>

int main (void)
{
	// The number of digits in the multiplicand, multiplier, and product must equal nine
	// therefore, we need not concern ourselves with products greater than 99999
	// will it be faster to go through all products and test factorizations of them?
	// or to try all multiplier/multiplicand pairs that yield results in the given range?
	// I think the products, because that way we don't have to keep track of them

	int sum = 0;

	for (int i=1000; i<9999; ++i)
	{
		for (int a=2; a<i; ++a)
		{
			int b = i/a;
			if (i%a)
				continue; // a isn't a perfect divisor of i, so this value of a won't work

			int tempi = i;
			int tempa = a;
			int tempb = b;
			int flags = 0;
			
			// get the list of digits in i
			while (tempi > 0)
			{
				flags |= (1 << (tempi%10));
				tempi /= 10;
			}

			// and a
			while (tempa > 0)
			{
				flags |= (1 << (tempa%10));
				tempa /= 10;
			}

			// and b
			while (tempb > 0)
			{
				flags |= (1 << (tempb % 10));
				tempb /= 10;
			}

			// and see if it's pandigital
			// 0x3fe = 1111111110
			if ((flags & 0x3fe) == 0x3fe)
			{
				sum += i;
				// and make sure we don't count this product again
				a = i;
			}

		}
	}

	std::cout << sum << std::endl;

	return 0;
}