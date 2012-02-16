/*
Project Euler
Problem 25
"The Fibonacci sequence is defined by the recurrence relation:
	Fn = Fn-1 + Fn-2, where F1 = 1 and F2 = 1.

Hence the first 12 terms will be:
	F1 = 1
	F2 = 1
	F3 = 2
	F4 = 3
	F5 = 5
	F6 = 8
	F7 = 13
	F8 = 21
	F9 = 34
	F10 = 55
	F11 = 89
	F12 = 144

The 12th term, F12, is the first term to contain three digits.

What is the first term in the Fibonacci sequence to contain 1000 digits?"
*/

#include <iostream>
#include <cmath>
#include "bigunsigned.h"

int numDigits(BigUnsigned &n);

int
main(void)
{
	BigUnsigned n1 = 1;
	BigUnsigned n2 = 1;
	BigUnsigned t=1;
	int term = 2;

	BigUnsigned max = 1;
	for (int i=0; i<999; ++i)
		max *= 10;

	int numdigits;

	do
	{
		t = n1 + n2;
		n1 = n2;
		n2 = t;
		++term;
//		numdigits = numDigits(t);
		std::cout << term << '\t';
	}while (t < max);

	std::cout << std::endl << term << std::endl;

	return 0;
}

int
numDigits(BigUnsigned &n)
{
	int numdigits = 0;
	BigUnsigned b = n;
	while (b > BigUnsigned(0))
	{
		b /= 10;
		++numdigits;
	}
	return numdigits;
}
