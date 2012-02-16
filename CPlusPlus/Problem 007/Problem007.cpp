/*
Project Euler
Problem 7
"Find the 10001st prime."
*/

#include <vector>
#include <iostream>

int main (void)
{
	std::vector<int> primes;
	primes.push_back(2);

	bool is_prime;
	for (int n=3; primes.size() < 10001; ++n)
	{
		is_prime = true;
		for (std::vector<int>::iterator i=primes.begin(); (i!=primes.end()) && (*i<=n/2); ++i)
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

			// this just here for informational purposes
			if (!(primes.size() % 100))
			{
				std::cout << "primes[" << primes.size() << "] = " << primes[primes.size() - 1] << std::endl;
			}
		}
	}

	std::cout << primes[10000] << std::endl;
	return 0;
}
