using System;
using System.Collections.Generic;
using System.Text;

/*
Project Euler
Problem 38

Take the number 192 and multiply it by each of 1, 2, and 3:

    192x1 = 192
    192x2 = 384
    192x3 = 576

By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product of 192 and (1,2,3)

The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).

What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n 1?

*/
namespace Problem_038
{
    class Program
    {
        static void Main(string[] args)
        {
            StringBuilder sb = new StringBuilder();
            string max = "";
            int temp;
            for (int i = 1; i < 100000; ++i)
            {
                sb.Remove(0, sb.Length);
                sb.Append(i.ToString());
                for (int c = 2; sb.Length < 9; ++c)
                {
                    temp = i*c;
                    sb.Append(temp.ToString());
                }
                if (sb.Length > 9)
                    continue;

                int flags = 0;
                string str = sb.ToString();
                for (int c = 0; c < sb.Length; ++c)
                {
                    flags |= (1 << int.Parse(str.Substring(c, 1)));
                }
                if (((flags & 0x3fe) == 0x3fe) && (str.CompareTo(max) > 0))
                {
                    max = str;
                }
            }

            Console.Out.WriteLine(max);
        }


    }
}
