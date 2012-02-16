/*
Project Euler
Problem 36

The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.

Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.

(Please note that the palindromic number, in either base, may not include leading zeros.)
*/

#include <vector>
#include <iostream>

int is_palindromic_base_10(int n)
{
	// 0 and negative numbers not allowed
	if (n <= 0)
		return false;

	// get the digits of n
	std::vector<int> digits;
	int temp=n;
	while(temp > 0)
	{
		digits.push_back(temp%10);
		temp /= 10;
	}

	// now check to see if it's palindromic
	std::vector<int>::iterator i = digits.begin();
	std::vector<int>::iterator j = digits.end() - 1;

	int palindromic = 1;
	for ( ; j != digits.begin(); ++i, --j)
	{
		if (*j != *i)
			return false;
	}

	return true;
}

int is_palindromic_base_2(int n)
{
	// 0 and negative numbers not allowed
	if (n <= 0)
		return false;

	// get the digits of n
	std::vector<int> digits;
	int temp=n;
	while(temp > 0)
	{
		digits.push_back(temp%2);
		temp /= 2;
	}

	// now check to see if it's palindromic
	std::vector<int>::iterator i = digits.begin();
	std::vector<int>::iterator j = digits.end() - 1;

	int palindromic = 1;
	for ( ; j != digits.begin(); ++i, --j)
	{
		if (*j != *i)
			return false;
	}

	return true;
}

int main (void)
{
	int sum = 0;
	for (int i=1; i<1000000; ++i)
	{
		if (is_palindromic_base_10(i) && is_palindromic_base_2(i))
		{
			std::cout << i << std::endl;
			sum += i;
		}
	}

	std::cout << sum << std::endl;
	return 0;
}