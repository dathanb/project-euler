/*
Project Euler
Problem 97

The first known prime found to excdeed 1,000,000 digits was discovered in 1999, and is a
Mersenne prime of the form 2^6972593-1; it contains exactly 2,098,960 digits.  Subsequently other
Mersenne primes, of the form 2^P-1, have been found which contain more digits.

However, in 2004 there was found a massive non-Mersenne prime which contains 2,357,207 digits: 28433*2^7830457+1.

Find the last ten digits of this prime number
*/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Problem_097
{
    class Program
    {
        static void Main(string[] args)
        {
            Int64 num = 1;
            for (int counter = 0; counter < 7830457; ++counter)
            {
                num *= 2;
                num %= 1000000000000;
            }

            num *= 28433;
            num += 1;
            num %= 10000000000;

            Console.WriteLine("***** " + num.ToString() + " *****");
            Console.ReadLine();
        }
    }
}
