/*
Project Euler
Problem 34

145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

Find the sum of all numbers which are equal to the sum of the factorial of their digits.

Note: as 1! = 1 and 2! = 2 are not sums they are not included.
*/

#include <iostream>
#include <vector>

int main (void)
{
	// pre-compute factorials
	int factorials[] = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
	// note: because 7*9! < 10^7, we don't need to look at any numbers greater than 7*9! = 2540160
	int grand_sum = 0;
	for (int i=3; i<= 2540160; ++i)
	{
		// calculate the sum of factorials
		int tempi = i;
		int sum = 0;
		while (tempi > 0)
		{
			sum += factorials[tempi % 10];
			tempi/=10;
		}

		if (sum == i)
			grand_sum += i;
	}

	std::cout << grand_sum << std::endl;

	return 0;
}