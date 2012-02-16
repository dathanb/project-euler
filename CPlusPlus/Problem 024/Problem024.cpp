/*
Project Euler
Problem 24
"A permutation is an ordered arrangement of objects. For example, 3124 is one possible 
permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed 
numerically or alphabetically, we call it lexicographic order. The lexicographic 
permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?"
*/

#include <iostream>
#include <vector>

void getPermutation(std::vector<int> set, std::vector<int> &perm, int count, int total=1);
int factorial(int);

int
main (void)
{
	// setup the set
	std::vector<int> set;
	for (int i=0; i<10; ++i)
	{
		set.push_back(i);
	}

	// and get the permutation
	std::vector<int> perm;
	getPermutation(set, perm, 1000000);

	// and print it out
	for (int i=0; i<perm.size(); ++i)
	{
		std::cout << perm[i];
	}
	std::cout << std::endl;

	return 0;
}

void
getPermutation(std::vector<int> set, std::vector<int> &perm, int count, int total)
{
	int temp = 0;
	for (int i=0; i<set.size(); ++i)
	{
		if (total + factorial(set.size() - 1) > count)
		{
			perm.push_back(set[i]);
			set.erase(set.begin() + i);
			getPermutation(set, perm, count, total);
			break;
		}
		else
		{
			total += factorial(set.size() - 1);
		}
	}
}

int
factorial(int n)
{
	int total = 1;
	for (int i=2; i<=n; ++i)
		total *= i;
	return total;
}