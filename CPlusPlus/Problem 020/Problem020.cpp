/*
Project Euler
Problem 20
"n! means nx(nx1) ... 3x2x1

Find the sum of the digits in the number 100!"
*/

#include <iostream>
#include "bigunsigned.h"

unsigned long
getSum(BigUnsigned &num);

int
main (void)
{
	BigUnsigned a = 1;

	for (int i=2; i<= 100; ++i)
	{
		a *= i;
	}

	std::cout << getSum(a) << std::endl;

	return 0;
}

unsigned long
getSum(BigUnsigned &num)
{
	BigUnsigned a(num);
	unsigned long total = 0;
	while (a > BigUnsigned(0))
	{
		unsigned long blk = (a % BigUnsigned(10)).getBlock(0);
		total += blk % 10;
		a /= BigUnsigned(10);
	}
	return total;
}
