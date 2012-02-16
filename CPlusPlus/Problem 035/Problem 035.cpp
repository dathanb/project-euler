/*
Project Euler
Problem 35

The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.

There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

How many circular primes are there below one million?
*/

#include <iostream>
#include <vector>
#include "primes.h"

int main (void)
{
	// go through numbers and see which ones are circular
	int count = 0;
	for (int i=2; i<1000000; ++i)
	{
		if (i % 10000 == 0)
			std::cout << i << '\t' << count << std::endl;
		if (is_prime(i))
		{
			// calculate the rotations and see if they're all prime
			int log = 0;
			int mult = 1;
			int tempi = i/10;
			while (tempi > 0)
			{
				tempi /= 10;
				++log;
				mult *= 10;
			}

			tempi = i;
			int prime = 1;
			for (int t = 0; t<log; ++t)
			{
				// rotate the digits in tempi
				tempi = (tempi/10) + (tempi%10)*mult;
				if (!is_prime(tempi))
				{
					prime = 0;
					break;
				}
			}

			if (prime)
			{
				++count;
			}
		}
	}

	std::cout << count << std::endl;

	return 0;
}