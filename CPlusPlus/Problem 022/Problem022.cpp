/*
Project Euler
Problem 21
"Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?"
*/

#include <iostream>
#include <fstream>
#include <vector>
#include <string>

std::vector<std::string> names;

int
main (void)
{
	std::ifstream ifile;
	ifile.open("names.txt");

	// read in the names
	std::string temp;
	ifile >> temp;
	while (!ifile.eof())
	{
		names.push_back(temp);
		ifile >> temp;
	}

	// sort the list
	// a faster algorithm would be better, but this'll work
	for (int i=0; i<names.size(); ++i)
	{
		for (int j=i+1; j<names.size(); ++j)
		{
			if (names[j] < names[i])
			{
				temp = names[j];
				names[j] = names[i];
				names[i] = temp;
			}
		}
	}

	// now go through each and calculate its score
	int total  = 0;
	for (int i=0; i<names.size(); ++i)
	{
		temp = names[i];
		int temp_total = 0;
		for (int j=0; j<temp.length(); ++j)
		{
			temp_total += temp[j] - 'A' + 1;
		}
		temp_total *= (i+1);
		total += temp_total;
	}

	std::cout << total << std::endl;

	return 0;
}

