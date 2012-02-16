/*
Project Euler
Problem 2
"Find the sum of all the even-valued terms in the Fibonacci sequence which do not exceed one million"

*/

#include <iostream>

long nextFibo()
{
	static long prev1 = 0;
	static long current = 1;

	long next = current + prev1;
	prev1 = current;
	current = next;

	return next;
}

int main (void)
{
	long sum = 0;
	for (long i=1; i < 1000000; i = nextFibo())
	{
		if (i % 2 == 0)
			sum += i;
	}

	std::cout << sum << std::endl;
	return 0;
}