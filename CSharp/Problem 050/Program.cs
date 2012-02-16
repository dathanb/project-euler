/*
Project Euler
Problem 50

The prime 41, can be written as the sum of six consecutive primes:
41 = 2 + 3 + 5 + 7 + 11 + 13

This is the longest sum of consecutive primes that adds to a prime below one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most consecutive primes?
*/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Diagnostics;
using System.IO;

namespace Problem_050
{
    static class Program
    {
        static IList<int> primeList;
        static IDictionary<int, bool> primeDict;

        static Program()
        {
            primeList = new List<int>();
            primeDict = new Dictionary<int, bool>();
            GetPrimes();
            Trace.Listeners.Add(new TextWriterTraceListener(Console.Out));
        }

        static void Main(string[] args)
        {
            int max = 0;
            int max_num = 0;
            foreach (int num in primeList)
            {
                Debug.WriteLine(String.Format("Processing {0,7}", num));
                int run = GetMaxRun(num);
                if (run > max)
                {
                    max = run;
                    max_num = num;
                }
            }

            Console.WriteLine(String.Format("***** {0} ({1} consecutive primes) *****", max_num, max));
            Console.ReadLine();
        }

        static void GetPrimes()
        {
            IList<int> primes = new List<int>();
            using (FileStream ofile = new FileStream("primes.txt", FileMode.Open))
            {
                using (StreamReader reader = new StreamReader(ofile))
                {
                    while (!reader.EndOfStream)
                    {
                        string str = reader.ReadLine();
                        int i = Int32.Parse(str);
                        primeList.Add(i);
                        primeDict.Add(i, true);
                    }
                }
            }
        }

        static int GetMaxRun(int num)
        {
            int max = 0;
            for (int i = 0; primeList[i] < num; ++i)
            {
                int run = GetRun(num, i);
                if (run > max)
                    max = run;
            }
            return max;
        }

        static int GetRun(int num, int index)
        {
            int sum = 0;
            int i;
            for ( i=index; sum < num; ++i)
            {
                sum += primeList[i];
            }
            if (sum == num)
                return i - index;
            else
                return -1;
        }
    }
}
