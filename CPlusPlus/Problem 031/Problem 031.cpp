/*
Project Euler
Problem 31

In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:

    1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).

It is possible to make £2 in the following way:

    1£1 + 150p + 220p + 15p + 12p + 31p

How many different ways can £2 be made using any number of coins?

*/

#include <iostream>

int main (void)
{
	// to save a gazillion iterations, we note that there are two ways here to make L2: one L2 note; two L1 notes
	int count = 2;

	// first try: nested loops
	for (int p1 = 0; p1<=200; ++p1)
	{
		for (int p2=0; p2<=100; ++p2)
		{
			if (p1 + 2*p2 > 200)
				continue;

			for (int p5=0; p5<=40; ++p5)
			{
				if (p1 + 2*p2 + 5*p5 > 200)
					continue;

				for (int p10=0; p10<=20; ++p10)
				{
					if (p1 + 2*p2 + 5*p5 + 10*p10 > 200)
						continue;

					for (int p20=0; p20<=10; ++p20)
					{
						if (p1 + 2*p2 + 5*p5 + 10*p10 + 20*p20 > 200)
							continue;

						for (int p50=0; p50<=4; ++p50)
						{
							if (p1 + 2*p2 + 5*p5 + 10*p10 + 20*p20 + 50*p50 > 200)
								continue;
							else if (p1 + 2*p2 + 5*p5 + 10*p10 + 20*p20 + 50*p50 == 200)
							{
								++count; 
								continue;
							}
							else if (p1 + 2*p2 + 5*p5 + 10*p10 + 20*p20 + 50*p50 == 100)
							{
								// we can add a 1-pound note to anything that totals 100 to get another combination
								++count;
								continue;
							}
						}
					}
				}
			}
		}
	}

	std::cout << count << std::endl;

	return 0;
}