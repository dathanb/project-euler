/*
Project Euler
Problem 79

A common security method used for online banking is to ask the user for three random characters
from a passcode.  For example, if the passcode was 531278, they may ask for the 2nd, 3rd, and
5th characters; the expected reply would be: 317.

The text file, keylog.txt, contains fifty successful login attempts.

Given that the three characters are always asked for in order, analyse the file so as to
determine the shortest possible secret passcode of unknown length.
*/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace Problem_079
{
    class Program
    {
        static void Main(string[] args)
        {
            // load keylog
            List<IList<int>> attempts = new List<IList<int>>();
            using (FileStream ifile = new FileStream("keylog.txt", FileMode.Open))
            {
                using (StreamReader reader = new StreamReader(ifile))
                {
                    while (!reader.EndOfStream)
                    {
                        string line = reader.ReadLine();
                        int[] nums = new int[3];
                        nums[0] = Int32.Parse(line.Substring(0, 1));
                        nums[1] = Int32.Parse(line.Substring(1, 1));
                        nums[2] = Int32.Parse(line.Substring(2, 1));
                        attempts.Add(nums);
                    }
                }
            }

            // get the list of all numbers used in all attempts
            List<int> master_candidates = new List<int>();
            foreach (int[] array in attempts)
            {
                foreach (int num in array)
                {
                    if (!master_candidates.Contains(num))
                        master_candidates.Add(num);
                }
            }

            List<int> code = new List<int>();
            // get the first element in the code
            List<int> candidates = new List<int>(master_candidates);
            foreach (int[] array in attempts)
            {
                if (candidates.Contains(array[1]))
                    candidates.Remove(array[1]);
                if (candidates.Contains(array[2]))
                    candidates.Remove(array[2]);
            }
            int next = Resolve(candidates, attempts);
            code.Add(next);
            master_candidates.Remove(next);

            while (master_candidates.Count > 1)
            {
                // now get the rest of the code
                candidates = new List<int>(master_candidates);
                foreach (int[] array in attempts)
                {
                    if ((array[0] == code[code.Count - 1]) && (candidates.Contains(array[2])))
                        candidates.Remove(array[2]);
                }
                next = Resolve(candidates, attempts);
                code.Add(next);
                master_candidates.Remove(candidates.Single());
            }

            code.Add(master_candidates[0]);

            Console.WriteLine(String.Format("***** {0} *****", String.Join("", code.Select(n => n.ToString()).ToArray())));
            Console.ReadLine();

        }

        static int Resolve(IList<int> candidates, IList<IList<int>> attempts)
        {
            while (candidates.Count > 1)
            {
                foreach (IList<int> attempt in attempts)
                {
                    // if the second candidate comes after the first, remove it.
                    if (((attempt[0] == candidates[0]) && ((attempt[1] == candidates[1]) || (attempt[2] == candidates[1])))
                        || ((attempt[1] == candidates[0]) && (attempt[2] == candidates[1])))
                    {
                        candidates.Remove(candidates[1]);
                        break;
                    }
                    // else if the second comes before the first, remove the first
                    else if (((attempt[0] == candidates[1]) && ((attempt[1] == candidates[0]) || (attempt[2] == candidates[0])))
                        || ((attempt[1] == candidates[1]) && (attempt[2] == candidates[0])))
                    {
                        candidates.Remove(candidates[0]);
                        break;
                    }
                }
            }

            return candidates.Single();
        }
    }
}
