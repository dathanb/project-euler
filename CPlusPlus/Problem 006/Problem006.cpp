/*
Project Euler
Problem 6
"Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum."
*/

#include <iostream>

int main (void)
{
	// the sum of the numbers 1 through n is (n * (n + 1))/2.  
	// so the square of that sum is (n^2 * (n + 1) ^2)/4
	long square_sum = 100 * 100 * 101 * 101 / 4;

	// calculate the sum of squares iteratively
	long sum_squares = 0;
	for (int i=1; i<=100; ++i)
	{
		sum_squares += i * i;
	}

	std::cout << sum_squares - square_sum << std::endl;
}