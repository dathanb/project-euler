package projecteuler.p003

// Project Euler
// Problem 3
//
// The prime factors of 13195 are 5, 7, 13 and 29.
// 
// What is the largest prime factor of the number 600851475143 ?

object main {
	def primeFactors(n: Long, i: Long): Stream[Long] = {
	  if (n%i==0) return Stream.cons(i, primeFactors(n/i, i))
	  else if (i>n) return Stream.empty
	  else return primeFactors(n, i+1)
	}
  
	def main(args: Array[String]) = {
	  println(primeFactors(600851475143L, 2).max)
	}
}