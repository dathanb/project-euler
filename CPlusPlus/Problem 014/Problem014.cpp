/*
Project Euler
Problem 14
"The following iterative sequence is defined for the set of positive integers:

n n/2 (n is even)
n 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:
13 40 20 10 5 16 8 4 2 1

It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million."
*/


#include <iostream>
#include <windows.h> // for INT64


INT64
getChainLength(INT64 num)
{
	INT64 len = 1;
	INT64 n = num;
	while (n != 1)
	{
		n = ((n % 2) ? (3 * n + 1) : (n/2));
		++len;
	}
	return len;
}

int
main (void)
{
	INT64 max=0;
	INT64 maxnum=0;
	for (INT64 i=1; i<1000000; ++i)
	{
		INT64 len = getChainLength(i);
		if (len > max)
		{
			max = len;
			maxnum = i;
		}
		if (!(i % 1000))
			std::cout << "Processing " << i << ": max currently " << max << std::endl;
	}

	std::cout << "Max chain: " << max << std::endl;
	std::cout << "Staring point: " << maxnum << std::endl;
	return 0;
}
