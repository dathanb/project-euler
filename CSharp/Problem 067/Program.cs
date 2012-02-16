using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace Problem_067
{
    class Program
    {
        static void Main(string[] args)
        {
            new Program().Run();
        }

        public void Run()
        {
            int[,] tree = new int[100, 100];
            using (FileStream ifile = new FileStream("triangle.txt", FileMode.Open))
            {
                using (StreamReader reader = new StreamReader(ifile))
                {
                    for (int row = 0; row < 100; ++row)
                    {
                        string line = reader.ReadLine();
                        string[] nums = line.Split(' ');
                        for (int col = 0; col <= row; ++col)
                        {
                            tree[row, col] = Int32.Parse(nums[col]);
                        }
                    }
                }
            }

            for (int row = 98; row >= 0; --row)
            {
                for (int col = 0; col <= row; ++col)
                {
                    tree[row, col] = tree[row, col] + ((tree[row + 1, col] > tree[row + 1, col + 1]) ? tree[row + 1, col] : tree[row + 1, col + 1]);
                }
            }

            Console.WriteLine(tree[0, 0]);
        }
    }
}
