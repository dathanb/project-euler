package euler

// Project Euler
// Problem 6
//
// The sum of the squares of the first ten natural numbers is,
//
// 1^2 + 2^2 + ... + 10^2 = 385
// The square of the sum of the first ten natural numbers is,
//
// (1 + 2 + ... + 10)^2 = 552 = 3025
// Hence the difference between the sum of the squares of the first ten natural numbers and the
// square of the sum is 3025  385 = 2640.
//
// Find the difference between the sum of the squares of the first one hundred natural numbers and
// the square of the sum.

object Problem006 {
	def main (args: Array[String]) = {
		val nums = List.range(1L, 101L);
		val squares = nums.map(x => x*x);
		val sum = nums.sum;
		val sum_of_squares = squares.sum;
		val square_of_sum = sum*sum;
		println(square_of_sum - sum_of_squares);
	}
}