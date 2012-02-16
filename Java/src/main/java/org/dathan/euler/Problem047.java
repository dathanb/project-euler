package org.dathan.euler;

import java.util.Map;

import org.dathan.numeric.Factorizer;

/*
The first two consecutive numbers to have two distinct prime factors are:

14 = 2 x 7
15 = 3 x 5

The first three consecutive numbers to have three distinct prime factors are:

644 = 2² x 7 x 23
645 = 3 x 5 x 43
646 = 2 x 17 x 19.

Find the first four consecutive integers to have four distinct primes factors. What is the first of these numbers?
 */



public class Problem047 {
	private Factorizer factorizer = new Factorizer();
	
	public static void main(String[] args) {
		new Problem047().run();
	}
	
	public Problem047() {
	}
	
	public void run() {
		for (int i=2; ; ++i) {
			if (getPrimeFactors(i).size() == 4 
					&& getPrimeFactors(i+1).size() == 4 
					&& getPrimeFactors(i+2).size() == 4
					&& getPrimeFactors(i+3).size() == 4) {
				System.out.println(i);
				System.exit(0);
			}
		}
	}
	
	private Map<Integer, Integer> getPrimeFactors(int i) {
		return factorizer.getPrimeFactorMap(i);
	}
}
