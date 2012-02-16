/*
Project Euler
Problem 56

A googol (10^100) is a masive number; one followed by one-hundred zeros; 100^100 is almost 
unimaginably large: one followed by two-hundred zeros.  Despite their size, the sum of the digits
in each number is only 1.

Considering natural numbers of the form a^b, where a, b<100, what is the masimum digital sum?
*/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Oyster.Math;

namespace Problem_056
{
    class Program
    {
        static void Main(string[] args)
        {
            IntX a = new IntX();
            uint b;

            int max = 1;

            for (a = new IntX(2); a < new IntX(100); ++a)
            {
                for (b = 2; b < 100; ++b)
                {
                    Console.WriteLine(String.Format("{0,3}^{1}", a, b));
                    int sum = SumOfDigits(IntX.Pow(a, b));
                    if (sum > max)
                        max = sum;
                }
            }

            Console.WriteLine("***** " + max.ToString() + " *****");
            Console.ReadLine();
        }

        static int SumOfDigits(IntX num)
        {
            IntX temp = num;
            IntX sum = 0;
            while (temp > 0)
            {
                sum += (temp % 10);
                temp /= 10;
            }
            return int.Parse(sum.ToString()); 
        }
    }
}
