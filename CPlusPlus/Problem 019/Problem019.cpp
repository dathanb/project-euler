/*
Project Euler
Problem 19
"You are given the following information, but you may prefer to do some research for yourself.

    * 1 Jan 1900 was a Monday.
    * Thirty days has September,
      April, June and November.
      All the rest have thirty-one,
      Saving February alone,
      Which has twenty-eight, rain or shine.
      And on leap years, twenty-nine.
    * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.

How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
"
*/

#include <iostream>

/*
The plan:
Create a function that accepts the month and the year, and returns the number of days in that month.
*/

int
daysInMonth(int month);

int
main (void)
{
	int day = 366;
	int total = 0;

	for (int month = 0; month <= 100 * 12; ++month)
	{
		if (day % 7 == 0)
			++total;

		day += daysInMonth(month);
	}

	std::cout << total << std::endl;
}

int
daysInMonth(int month)
{
	int year = month / 12 + 1901;
	month = (month % 12) + 1;

	switch (month)
	{
	case 9: // September
	case 4: // April
	case 6: // June
	case 11: // November
		return 30;
		break;
	case 1: // January
	case 3: // March
	case 5: // May
	case 7: // July
	case 8: // August
	case 10: // October
	case 12: // December
		return 31;
		break;
	case 2:
		if (year % 400 == 0)
			return 29;
		else if (year % 100 == 0)
			return 28;
		else if (year % 4 == 0)
			return 29;
		else return 28;
	}

	throw -1; // it's an error if the month isn't 1-12
}