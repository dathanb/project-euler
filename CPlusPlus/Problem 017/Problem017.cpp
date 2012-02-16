/*
Project Euler
Problem 17
"If the numbers 1 to 5 are written out in words: one, two, three, four, five; there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters."
*/

#include <iostream>

unsigned
countLettersUnderAHundred(unsigned num)
{
	unsigned letters = 0;
	num %= 100;

	if ((num >= 11) && (num <= 19))
	{
		switch (num)
		{
		case 11:
		case 12:
			letters = 6;
			break;
		case 13:
		case 14:
		case 18:
		case 19:
			letters = 8;
			break;
		case 15:
		case 16: 
			letters = 7;
			break;
		case 17: 
			letters = 9;
			break;
		}
	}
	else
	{
		switch (num % 10)
		{
		case 1: 
		case 2:
		case 6:
			letters += 3;
			break;
		case 4:
		case 5:
		case 9:
			letters += 4;
			break;
		case 3:
		case 7:
		case 8:
			letters += 5;
			break;
		default:	// 0
			break;
		}
		switch(num / 10)
		{
		case 1: // ten
			letters += 3;
			break;
		case 4: // forty
		case 5: // fifty
		case 6: // sixty
			letters += 5;
			break;
		case 2: // twenty
		case 3: // thirty
		case 8: // eighty
		case 9: // ninety
			letters += 6;
			break;
		case 7: // seventy
			letters += 7;
			break;
		default: // 0
			break;
		}
	}

	return letters;

}

// this only works for numbers between one and one-thousand, inclusive
unsigned
countLetters (unsigned num)
{
	if (num == 1000)
		return 11;

	unsigned letters = 0;

	letters = countLettersUnderAHundred(num);

	if (num >= 100)
	{
		if (letters)
			letters += 3; // "and"
		letters += 7; // "hundred"
		
	}

	letters += countLettersUnderAHundred(num / 100);

	return letters;

}

int
main(void)
{
	unsigned sum = 0;
	for (unsigned i = 1; i <= 1000; ++i)
	{
		sum += countLetters(i);
	}

	std::cout << sum << std::endl;
	return 0;
}