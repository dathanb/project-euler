/*
Project Euler
Problem 4
"Find the largest palindrome made from the product of two 3-digit numbers."
*/

#include <iostream>

long reverseNum(long num)
{
	long t = 0;
	while (num > 0)
	{
		t *= 10;
		t += num % 10;
		num /= 10;
	}
	return t;
}

bool isPalindrome(long num)
{
	 return (reverseNum(num) == num);
}

int main (void)
{
	long largest = 0;
	long prod = 0;
	for (int a = 100; a < 1000; ++a)
	{
		for (int b = 100; b < 1000; ++b)
		{
			prod = a * b;
			if (isPalindrome(prod) && (prod > largest))
			{
				largest = prod;
			}
		}
	}

	std::cout << largest << std::endl;
	return 0;
}