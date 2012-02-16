using System;
using System.Collections.Generic;
using System.Text;

/*
Project Euler
Problem 40

An irrational decimal fraction is created by concatenating the positive integers:

0.123456789101112131415161718192021...

It can be seen that the 12th digit of the fractional part is 1.

If dn represents the nth digit of the fractional part, find the value of the following expression.

d1 d10 d100 d1000 d10000 d100000 d1000000
*/

namespace Problem_040
{
    class Program
    {
        static void Main(string[] args)
        {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; sb.Length < 1000000; ++i)
            {
                sb.Append(i);
            }

            string str = sb.ToString();

            int prod = int.Parse(str.Substring(0, 1))
                     * int.Parse(str.Substring(9, 1))
                     * int.Parse(str.Substring(99, 1))
                     * int.Parse(str.Substring(999, 1))
                     * int.Parse(str.Substring(9999, 1))
                     * int.Parse(str.Substring(99999, 1))
                     * int.Parse(str.Substring(999999, 1));

            Console.Out.WriteLine(prod);
            
        }
    }
}
