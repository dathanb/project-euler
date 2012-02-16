/*
Project Euler
Problem 16
"2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 2^1000?"
*/

#include <iostream>
#include "bigunsigned.h"

int
main(void)
{
	BigUnsigned b = 2;

	for (int i=2; i<=1000; ++i)
		b += b;

	// TODO: get the num of digits
	//std::cout << b.sumDigits() << std::endl;

	return 0;
}
