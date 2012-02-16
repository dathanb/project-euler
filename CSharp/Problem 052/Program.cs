/*
Project Euler
Problem 52

It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.

Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
*/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Diagnostics;

namespace Problem_052
{
    class Program
    {
        static void Main(string[] args)
        {
            // first, the test case
            Debug.Assert(SameDigits(125874, new Int64[] { 2 }));

            // now the actual case
            Int64[] multipliers = new Int64[] {2,3,4,5,6};
            Int64 x;
            for (x = 1; !SameDigits(x, multipliers); ++x)
            {
                if (x % 1000 == 0)
                    Console.WriteLine("Testing " + x);
            }

            Console.WriteLine("****** " + x.ToString() + " *****");
            Console.ReadLine();
        }

        static bool SameDigits(Int64 num, Int64[] multipliers)
        {
            int[] nums = GetNums(num);
            foreach (Int64 coefficient in multipliers)
            {
                int[] other_nums = GetNums(coefficient * num);
                if (!nums.SequenceEqual(other_nums))
                {
                    return false;
                }
            }

            return true;
        }

        static int Magnitude(Int64 num)
        {
            return (int)Math.Floor(Math.Log10(num));
        }

        static int[] GetNums(Int64 num)
        {
            int magnitude = Magnitude(num);
            int[] nums = new int[magnitude + 1];
            int index = 0;
            while (num > 0)
            {
                nums[index++] = (int)(num % 10);
                num /= 10;
            }
            return nums.OrderBy(i => i).ToArray();
        }
    }
}
