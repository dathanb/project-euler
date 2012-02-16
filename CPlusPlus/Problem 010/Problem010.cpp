/*
Project Euler
Problem 10
"Find the sum of all the primes below one million."
*/

#include <iostream>
#include <vector>
#include <windows.h>  // for declaration of INT64
#include <cmath>


int
main (void)
{
	std::vector<int> primes;
	primes.push_back(2);

	for (int n=3; n<1000000; n+=2)
	{
		bool is_prime = true;
		for (std::vector<int>::iterator i=primes.begin(); (i!=primes.end())  && (*i <= sqrt((float)n)); ++i)
		{
			if (!(n % *i))
			{
				is_prime = false;
				break;
			}
		}
		if (is_prime)
		{
			primes.push_back(n);
			if (primes.size() % 100 == 0)
				std::cout << n << std::endl;
		}
	}

	INT64 sum = 0;
	for (std::vector<int>::iterator i=primes.begin(); i!=primes.end(); ++i)
	{
		sum += *i;
	}

	std::cout << std::endl << sum << std::endl;

	return 0;
}
