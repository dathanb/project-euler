using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Problem_053
{
    /// <summary>
    /// Project Euler
    ///Problem 53
    ///
    ///There are exactly ten ways of selecting three from five, 12345:
    ///      123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
    ///      
    ///In combinatorics, we use the notation, 5C3 = 10.
    ///
    /// In general,
    /// 
    /// nCr = n!/(r!(n-r)!), where r &lte; n, n! = x*(n-1)*...*3*2*1, and 0! = 1.
    /// 
    /// It is not until n=23 that a value exceeds one milloin: 23C10 = 1144066.
    /// 
    /// How many, not necessarily distinct, values of nCr for 1 &let; n &lte; 100 are greater than one million?
    /// </summary>
    /// <remarks>
    /// Note that by definition, nCr = nC(n-r), so it suffices to check only values of r up to ceiling(n/2), 
    /// and count each match twice when r != n/2.
    /// 
    /// The only caveat really is dealing with large numbers.  Luckily, 100! &lt; 100^100, which is within the range
    /// of the double data type.  So, we're just going to go ahead and try to calculate all these explicitly first.
    /// </remarks>
    class Program
    {
        static void Main(string[] args)
        {
            int count = 0;
            for (int n = 1; n <= 100; ++n)
            {
                for (int r = 1; r <= n; ++r)
                {
                    if (Factorial(n) / (Factorial(r) * Factorial(n - r)) > 1000000)
                        ++count;
                }
            }

            Console.WriteLine("***** " + count.ToString() + " *****");
            Console.ReadLine();
        }

        static double Factorial(int n)
        {
            double total = 1;
            while (n > 0)
                total *= n--;
            return total;
        }
    }
}
