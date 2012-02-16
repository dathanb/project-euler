#include <iostream>

int main (void)
{
	long x = 0;
	
	for (int i=1; i<1000; ++i)
	{
		if ((i % 3 == 0) || (i % 5 == 0))
		{
			x += i;
		}
	}

	std::cout << x << std::endl;
	return 0;
}