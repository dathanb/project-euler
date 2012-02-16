/*
Project Euler
Problem 005
"What is the smallest number divisible by all of the numbers from 1 to 20?"
*/

/*
Reasoning for an elegant method:
Find the prime factorization of each number 1 to 20.
Get a cound of each time each factor occurs in the factor list for each number.
Look at the overall list.  If the given factor does not occur at least that many times, insert enough copies to make up the difference.
When we're done, we're guaranteed to have the answer.

But to save time...
We're going to start with the product of all unique primes between 1 and 20, and just count up from there.
*/

#include <iostream>
#include <list>

std::list<int>
factor(int num)
{
	std::list<int> local_factors;
	for (int i=2; i<=num/2; ++i)
	{
		if (num % i == 0)
		{
			local_factors.push_back(i);
			num /= i;
			--i;
		}
	}
	if (num != 1)
		local_factors.push_back(num);
	return local_factors;
}

int main (void)
{
	std::list<int> factors;

	for (int i=2; i<=20; ++i)
	{
		std::list<int> tempv = factor(i);
		factors.merge(tempv);
	}

	// now generate a unique list
	factors.unique();

	// now calculate the product of all the elements in that list
	int prod=1;
	for (std::list<int>::iterator a=factors.begin(); a!=factors.end(); ++a)
	{
		if (a != factors.begin())
			std::cout << " * " << *a;
		else
			std::cout << *a;

		prod *= *a;
	}

	// and now start counting up until we find a number that's divisible by 1 thru 20
	while ((prod % 2) || (prod % 3) || (prod % 4) || (prod % 5) || (prod % 6) ||
		   (prod % 7) || (prod % 8) || (prod % 9) || (prod % 10) || (prod %11) ||
		   (prod % 12) || (prod % 13) || (prod % 15) || (prod % 16) || (prod % 17) ||
		   (prod % 18) || (prod % 19) || (prod % 20))
	{
		++prod;
	}

	// now display our answer
	std::cout << " = " << prod << std::endl;
}