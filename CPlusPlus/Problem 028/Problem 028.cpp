/*
Project Euler
Problem 28

Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

21 22 23 24 25
20  7  8  9 10
19  6  1  2 11
18  5  4  3 12
17 16 15 14 13

It can be verified that the sum of both diagonals is 101.

What is the sum of both diagonals in a 1001 by 1001 spiral formed in the same way?
*/

/*
	Main here is just a placeholder because I want one project for each problem.  In reality, I reduced the problem
	to a calculable series by hand and figured out the answer on paper.
*/
#include <iostream>
int main (void)
{
	int sum = 1;
	int current = 1;
	for (int width = 3; width <= 1001; width += 2)
	{
		for (int t = 0; t<4; ++t)
		{
			current += width-1;
			sum += current;
		}
	}
	
	std::cout << sum << std::endl;
	return 0;
}

