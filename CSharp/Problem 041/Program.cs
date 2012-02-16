using System;
using System.Collections.Generic;
using System.Text;
using System.IO;

/*
Project Euler
Problem 41

We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is also prime.

What is the largest n-digit pandigital prime that exists?
*/

namespace Problem_041
{
    class Program
    {
        static int[] flags = { 0x0, 0x2, 0x6, 0xe, 0x1e, 0x3e, 0x7e, 0xfe, 0x1fe, 0x3fe };
        static List<int> pandigitals;

        static void Main(string[] args)
        {
            // I'm thinking there are fewer n-digit pandigital numbers than there are primes, (for 1 thru 9, there are none; for 10 thru 99, there are none; etc.)
            // so we should try to generate the odd n-pandigital numbers for each n in 3 thru 9 and then just test those for primality
            // we'll try that version later.  For now, just read in all the primes from the various prime number lists I have and output the largest pandigital one
            int max = 2143;

            DirectoryInfo dir = new DirectoryInfo("c:\\documents and settings\\owner\\my documents\\projects\\project euler\\data");
            FileInfo[] files = dir.GetFiles();

            foreach (FileInfo f in files)
            {
                if (f.FullName.ToLower().EndsWith("txt"))
                {
                    using (FileStream ifile = new FileStream(f.FullName, FileMode.Open, FileAccess.Read))
                    {
                        using (StreamReader r = new StreamReader(ifile))
                        {
                            string str = r.ReadLine();
                            while (str != null)
                            {
                                int i = int.Parse(str);
                                if (isNDigitPandigital(i) && (i > max))
                                {
                                    Console.Out.WriteLine(i);
                                    max = i;
                                }
                                str = r.ReadLine();
                            }
                        }
                    }
                }
            }
            Console.Out.WriteLine(max);
        }

        static bool isNDigitPandigital(int num)
        {
            int temp = num;
            int flag = 0;
            int n = num.ToString().Length;
            while (temp > 0)
            {
                flag |= (1 << (temp % 10));
                temp /= 10;
            }
            if ((flag & flags[n]) == flags[n])
                return true;
            else
                return false;
        }

        static void generatePandigitals(int len)
        {
            
        }


    }
}
