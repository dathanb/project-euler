using System;
using System.Collections.Generic;
using System.Text;
using System.IO;

/*
Project Euler
Problem 42

The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value. 
For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we shall call the word a triangle word.

Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, how many are triangle words?
*/

namespace Problem_042
{
    class Program
    {
        static void Main(string[] args)
        {
            int num_triangles = 0;
            using (FileStream ifile = new FileStream("C:\\documents and settings\\owner\\my documents\\projects\\project euler\\data\\words.txt", FileMode.Open, FileAccess.Read))
            {
                using (StreamReader reader = new StreamReader(ifile))
                {
                    string str = reader.ReadToEnd();
                    string new_str = str.Replace("\"", "");
                    char[] delimiter = new char[1];
                    delimiter[0] = ',';
                    string[] strings = new_str.Split(delimiter);

                    foreach (string word in strings)
                    {
                        int value = 0;
                        // calculate the value of the string
                        for (int i = 0; i < word.Length; ++i)
                        {
                            switch (word.Substring(i, 1))
                            {
                                case "A": value += 1;break;
                                case "B": value += 2; break;
                                case "C": value += 3; break;
                                case "D": value += 4; break;
                                case "E": value += 5; break;
                                case "F": value += 6; break;
                                case "G": value += 7; break;
                                case "H": value += 8; break;
                                case "I": value += 9; break;
                                case "J": value += 10; break;
                                case "K": value += 11; break;
                                case "L": value += 12; break;
                                case "M": value += 13; break;
                                case "N": value += 14; break;
                                case "O": value += 15; break;
                                case "P": value += 16; break;
                                case "Q": value += 17; break;
                                case "R": value += 18; break;
                                case "S": value += 19; break;
                                case "T": value += 20; break;
                                case "U": value += 21; break;
                                case "V": value += 22; break;
                                case "W": value += 23; break;
                                case "X": value += 24; break;
                                case "Y": value += 25; break;
                                case "Z": value += 26; break;
                            }
                        }

                        // now see if it's a triangle number
                        int sum = 1;
                        int inc = 2;
                        while (sum < value)
                        {
                            sum += inc;
                            ++inc;
                        }
                        if (sum == value)
                        {
                            Console.Out.WriteLine(word);
                            ++num_triangles;
                        }
                    }
                }
            }
            Console.Out.WriteLine(String.Format("Number of triangle words: {0}", num_triangles));
        }
    }
}
