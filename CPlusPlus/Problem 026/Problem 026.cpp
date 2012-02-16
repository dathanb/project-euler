/*
Project Euler
Problem 026
"A unit fraction contains 1 in the numerator.  The decimal representation of the unit fractions with denominators 2 to 10 are:
1/2  = 0.5
1/3  = 0.(3)
1/4  = 0.25
1/5  = 0.2
1/6  = 0.1(6)
1/7  = 0.(142857)
1/8  = 0.125
1/9  = 0.(1)
1/10 = 0.1
Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle.  It can be seen that 1/7 has a 6-digit recurring cycle.

Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part."
*/

#include <iostream>
#include <string>
#include <vector>

int
main (void)
{
	// No precision problems.  We just simulate long division.
	int max = 0;
	int max_len = 0;

	for (int d=2; d < 1000; ++d)
	{
		std::vector<int> nums;
		int n=1;
		int len = 0;
		
		while(len == 0)
		{
			do
			{
				nums.push_back(n);
				n*=10;
			} while (n < d);

			// now n >= d, so we can calculate the quotient and remainder
			n = n%d;
			
			if (n == 0)
			{
				len = -1; // if the decimal string terminates, it's not eligible
				break;
			}
				
			// see if this dividend exists in the list so far
			for (std::vector<int>::iterator i=nums.begin(); i!=nums.end(); ++i)
			{
				if (*i == n)
				{
					len = static_cast<int>(nums.end() - i);
					break;
				}
			}

			if (len > 0)
			{
				// meaning we've found a repeating pattern
				if (len > max_len)
				{
					max_len = len;
					max = d;
				}
			}
		}		
	}
	
	std::cout << max << std::endl;

	return 0;
}
