/*
Project Euler
Problem 33

The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.

If the product of these four fractions is given in its lowest common terms, find the value of the denominator.

*/

#include <iostream>
#include <vector>

int main (void)
{
	// we know both have two digits.
	// and we know that, when we remove the common digit and re-calculate the value, it is unchanged
	std::vector<int> tops;
	std::vector<int> bottoms;
	
	for (int numerator = 10; numerator <= 99; ++numerator)
	{
		// get digits in numerator
		int n1 = numerator % 10;
		int n2 = numerator / 10;
		for (int denominator = numerator+1; denominator <= 99; ++denominator)
		{
			if ((denominator % 10 == 0) && (numerator % 10 == 0))
				continue; // don't consider the so-called trivial fractions

			// get the digits
			int d1 = denominator % 10;
			int d2 = denominator / 10;

			// see if we have digits in common
			if ((n1 == d1) && ((double) n2 / (double) d2 == (double)numerator/(double)denominator))
			{
				tops.push_back(numerator);
				bottoms.push_back(denominator);
			}
			else if ((n1 == d2) && ((double) n2 / (double) d1 == (double)numerator/(double)denominator))
			{
				tops.push_back(numerator);
				bottoms.push_back(denominator);
			}			
			else if ((n2 == d1) && ((double) n1 / (double) d2 == (double)numerator/(double)denominator))
			{
				tops.push_back(numerator);
				bottoms.push_back(denominator);
			}			
			else if ((n2 == d2) && ((double) n1 / (double) d1 == (double)numerator/(double)denominator))
			{
				tops.push_back(numerator);
				bottoms.push_back(denominator);
			}
		}
	}

	// now calculate the product of the fraction
	int top = 1;
	for (std::vector<int>::iterator i = tops.begin(); i != tops.end(); ++i)
	{
		top *= *i;
	}
	int bottom = 1;
	for (std::vector<int>::iterator i = bottoms.begin(); i != bottoms.end(); ++i)
	{
		bottom *= *i;
	}

	// now reduce this fraction
	for (int i=2; (i<= top) && (i<=bottom); ++i)
	{
		if ((top % i == 0) && (bottom % i == 0))
		{
			top /= i;
			bottom /= i;
			--i;
		}
	}

	std::cout << bottom << std::endl;

	return 0;
}