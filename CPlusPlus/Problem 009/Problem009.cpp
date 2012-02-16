/*
Project Euler
Problem 9
"There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc."
*/

#include <iostream>
#include <cmath>

int
main (void)
{
	// we're constrained by a < b < c

	int a=0, b=0, c=0;
	for (a=1; a < 1000; ++a)
	{
		for (b=a+1; b < 1000; ++b)
		{
			if (a + b + sqrt((double)(a*a + b*b)) == 1000)
				goto end;
		}
	}

end:
	c = sqrt((double)(a*a + b*b));
	std::cout << a * b * c << std::endl;
	return 0;
}