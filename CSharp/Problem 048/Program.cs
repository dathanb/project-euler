using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Problem_048
{
    class Program
    {
        static void Main(string[] args)
        {
            Int64 total = 0;

            for (Int64 i = 1; i <= 1000; ++i)
            {
                total += GetPow(i);
                total %= 10000000000;
            }

            Console.WriteLine(total);
        }

        static Int64 GetPow(Int64 i)
        {
            Int64 total = 1;
            for (Int64 counter = 0; counter < i; ++counter)
            {
                total *= i;
                total %= 10000000000;
            }

            return total;
        }
    }
}
