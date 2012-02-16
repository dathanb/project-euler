/*
Project Euler
Problem 3
"Find the largest prime factor of 317584931803"
*/

#include <iostream>
#include <vector>
#include <climits>
#include <windows.h>	// for declaration of INT64, because 32-bit numbers aren't big enough to hold 317

#define ORIGINAL_NUM	317584931803
//#define ORIGINAL_NUM	4000000000

int main (void)
{
	INT64 cur = ORIGINAL_NUM;
	
	std::vector<INT64> factors;

	for (INT64 i=2; i<=cur/2; ++i)
	{
		if (cur % i == 0)
		{
			factors.push_back(i);
			cur /= i;
			--i;
		}
	}
	factors.push_back(cur);

	for (std::vector<INT64>::iterator i = factors.begin(); i != factors.end(); ++i)
	{
		std::cout << *i << std::endl;
	}

	return 0;
}
