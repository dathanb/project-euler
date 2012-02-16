package org.dathan.euler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.dathan.numeric.Integers;
import org.dathan.numeric.PrimeIterable;
import org.dathan.numeric.PrimeSet;
import org.dathan.numeric.Sets;

/*
By replacing the 1st digit of *3, it turns out that six of the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.

By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the first example having seven primes among the ten generated numbers, yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993. Consequently 56003, being the first member of this family, is the smallest prime with this property.

Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit, is part of an eight prime value family.
 */


public class Problem051 {
	private PrimeSet primeSet = new PrimeSet();
	private PrimeIterable primes = new PrimeIterable(primeSet);
	
	public static void main(String[] args) {
		new Problem051().run();
	}
	
	public Problem051() {
	}
	
	public void run() {
		for (int prime: primes) {
			for (Set<Integer> indices: getReplacementIndices(prime)) {
				List<Integer> generatedNumbers = generateNewNumbersByReplacement(prime, indices);
				if (countPrimes(generatedNumbers) >= 8) {
					System.out.println(generatedNumbers.get(0));
					System.exit(0);
				}
			}
		}
	}

	private Collection<Set<Integer>> getReplacementIndices(Integer prime) {
		Set<Set<Integer>> allPossibleReplacements = new HashSet<Set<Integer>>();
		Set<Integer> distinctDigits = Integers.getDistinctDigits(prime);
		
		for (Integer digit: distinctDigits) {
			allPossibleReplacements.addAll(Sets.powerSet(getIndices(prime, digit)));
		}
		
		return allPossibleReplacements;
	}
	
	private Set<Integer> getIndices(int number, int digit) {
		Set<Integer> indices = new HashSet<Integer>();
		int index = 0;
		while (number > 0) {
			if (number % 10 == digit) {
				indices.add(index);
			}
			++index;
			number /= 10;
		}
		return indices;
	}
	
	
	private List<Integer> generateNewNumbersByReplacement(int prime, Set<Integer> indices) {
		List<Integer> generatedNums = new ArrayList<Integer>();
		
		List<Integer> digits = new ArrayList<Integer>();
		int temp = prime;
		while (temp > 0) {
			digits.add(temp % 10);
			temp /= 10;
		}

		for (int i = indices.contains(digits.size()-1) ? 1 : 0; i<=9; ++i) {
			for (int index: indices) {
				digits.set(index, i);
			}
			generatedNums.add(arrayToInteger(digits));
		}
		return generatedNums;
	}
	
	private int arrayToInteger(List<Integer> digits) {
		int num = 0;
		for (int i=digits.size()-1; i>=0; --i) {
			num *= 10;
			num += digits.get(i);
		}
		return num;
	}
	
	private int countPrimes(Collection<Integer> numbers) {
		int count = 0;
		for (Integer number: numbers) {
			if (primeSet.isPrime(number))
				++count;
		}
		return count;
	}
}
