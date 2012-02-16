/*
Project Euler
Problem 30

Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

    1634 = 1^4 + 6^4 + 3^4 + 4^4
    8208 = 8^4 + 2^4 + 0^4 + 8^4
    9474 = 9^4 + 4^4 + 7^4 + 4^4

As 1 = 1^4 is not a sum it is not included.

The sum of these numbers is 1634 + 8208 + 9474 = 19316.

Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
*/

#include <iostream>
#include <vector>

int main (void)
{
	// by analysis, solving this is equivalent to solving
	// n0(n0^4-1)+n1(n1^4-10)+n2(n2^4-100)+n3(n3^4-1000)+...=0
	// The largest maximum number for this is using nx = 9 for all x. (this may not be true, actually...  I'd have to check)
	// it looks like we're stuck with 5-digit numbers
	std::vector<int> nums;

	for (int i=2; i<999999; ++i)
	{
		int sum = 0;
		int temp = i;
		while (temp > 0)
		{
			sum += (temp%10)*(temp%10)*(temp%10)*(temp%10)*(temp%10);
			temp /= 10;
		}
		
		if (sum == i)
		{
			nums.push_back(i);
		}
	}

	// print out all the numbers we found
	int sum = 0;
	for (std::vector<int>::iterator i = nums.begin(); i!=nums.end(); ++i)
	{
		std::cout << *i << '\t';
		sum += *i;
	}
	std::cout << std::endl << "sum = " << sum << std::endl;

	
	return 0;
}