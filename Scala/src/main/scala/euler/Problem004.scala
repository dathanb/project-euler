package euler

// Project Euler
// Problem 4
//
// A palindromic number reads the same both ways. The largest palindrome made from the product
// of two 2-digit numbers is 9009 = 91  99.
//
// Find the largest palindrome made from the product of two 3-digit numbers.

object Problem004 {
	def reverseString(str: String) = {
		str.foldLeft("")((a, e)=> e+a)
	}

	def isPalindromic(n: Int) = {
		n.toString() == reverseString(n.toString())
	}

	def nums(a: Int, b: Int): Stream[Int] = {
		if (b < 100)
			if (a < 100) return Stream.Empty
			else return Stream.cons(a*b, nums(a-1, 999));
		else return Stream.cons(a*b, nums(a, b-1));
	}

	def main(args: Array[String]) = {
		println(nums(999, 999).filter(x => isPalindromic(x)).max)
	}
}