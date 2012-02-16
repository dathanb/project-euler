using System;
using System.Collections.Generic;
using System.Text;

/*
Project Euler
Problem 39

If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.

{20,48,52}, {24,45,51}, {30,40,50}

For which value of p < 1000, is the number of solutions maximised?

*/

namespace Problem_039
{
    class Program
    {
        static void Main(string[] args)
        {
            int max_num = 0;
            int max_solns = 0;
            for (int p = 2; p < 1000; ++p)
            {
                int solns = 0;
                for (int a = 1; a < p; ++a)
                {
                    for (int b = a+1; (a*a)+(b*b) <= (p-a-b)*(p-a-b); ++b)
                    {
                        if (a * a + b * b == (p - a - b) * (p - a - b))
                        {
                            ++solns;
                        }
                    }
                }
                if (solns > max_solns)
                {
                    max_num = p;
                    max_solns = solns;
                }


            }
            Console.Out.WriteLine(max_num);
        }
    }
}
