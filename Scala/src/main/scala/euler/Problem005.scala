package euler

// Project Euler
// Problem 5
//
// 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without
// any remainder.
//
// What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

object Problem005 {
	def nums(x: Int): Stream[Int] = {
		return Stream.cons(x, nums(x+1))
	}

	def isMultiple(x: Int, items: List[Int]): Boolean = {
		items.forall(i => x%i==0)
	}

	def main(args: Array[String]) = {
		println(nums(2).filter(x => isMultiple(x, List.range(2, 21))) take 1)
	}
}
