using System;
using System.Collections.Generic;
using System.Text;



namespace Problem_043
{
    /// <summary>
    /// Project Euler
    /// Problem 43
    /// 
    /// The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.
    /// Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:
    /// * d2d3d4=406 is divisible by 2
    /// * d3d4d5=063 is divisible by 3
    /// * d4d5d6=635 is divisible by 5
    /// * d5d6d7=357 is divisible by 7
    /// * d6d7d8=572 is divisible by 11
    /// * d7d8d9=728 is divisible by 13
    /// * d8d9d10=289 is divisible by 17
    /// 
    /// Find the sum of all 0 to 9 pandigital numbers with this property.
    /// </summary>
    /// <remarks>
    /// Much more efficient would be to generate a list of all three-digit numbers that are divisible by 17, then try to match that with elements
    /// from a list of numbers divisilbe by 13, etc.
    /// </remarks>
    class Program
    {
        static void Main(string[] args)
        {
            Int64 sum = 0;

            for (Int64 i = 1023456789; i <= 9876543210; ++i)
            {
                if (isPandigital(i) && hasFunkyProperty(i))
                {
                    Console.Out.WriteLine(i);
                    sum += i;
                }
            }
            Console.Out.WriteLine("Sum of 9-pandigital numbers: {0}", sum);
        }
        static bool isPandigital(Int64 num)
        {
            Int64 temp = num;
            int flag = 0;
            while (temp > 0)
            {
                flag |= (1 << ((int)(temp % 10)));
                temp /= 10;
            }
            if ((flag & 0x3ff) == 0x3ff)
                return true;
            else
                return false;
        }

        static bool hasFunkyProperty(Int64 n)
        {
            string num = n.ToString();
            if ((Int64.Parse(num.Substring(1, 3)) % 2 == 0)
                && (Int64.Parse(num.Substring(2, 3)) % 3 == 0)
                && (Int64.Parse(num.Substring(3, 3)) % 5 == 0)
                && (Int64.Parse(num.Substring(4, 3)) % 7 == 0)
                && (Int64.Parse(num.Substring(5, 3)) % 11 == 0)
                && (Int64.Parse(num.Substring(6, 3)) % 13 == 0)
                && (Int64.Parse(num.Substring(7, 3)) % 17 == 0))
            {
                return true;
            }
            else
                return false;
        }
    }
}
