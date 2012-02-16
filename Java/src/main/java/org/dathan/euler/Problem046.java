package org.dathan.euler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dathan.numeric.PrimeSet;

/*
It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.

9 = 7 + 2x1^2
15 = 7 + 2x2^2
21 = 3 + 2x3^2
25 = 7 + 2x3^2
27 = 19 + 2x2^2
33 = 31 + 2x1^2

It turns out that the conjecture was false.

What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
 */

public class Problem046 {
	private List<Integer> doubleSquares = new ArrayList<Integer>();
	private PrimeSet primes = new PrimeSet();
	
	public static void main(String[] args) {
		new Problem046().run();
	}
	
	private Problem046() {
		doubleSquares.add(2);
	}
	
	private void run() {
		for (Integer i: oddComposites()) {
			if (!isDecomposable(i)) {
				System.out.println(i);
				System.exit(0);
			}
		}
	}
	
	private Iterable<Integer> oddComposites() {
		return new Iterable<Integer>() {

			@Override
			public Iterator<Integer> iterator() {
				return new OddCompositeIterator();
			}
			
		};
	}
	
	private boolean isDecomposable(int i) {
		populateDoubleSquaresUpTo(i);
		for (Integer doubleSquare: doubleSquares) {
			if (primes.isPrime(i - doubleSquare))
				return true;
		}
		return false;
	}
	
	private void populateDoubleSquaresUpTo(int i) {
		while (doubleSquares.get(doubleSquares.size() - 1) < i) {
			doubleSquares.add(2 * (doubleSquares.size() + 1) * (doubleSquares.size() + 1)); 
		}
	}

	private class OddCompositeIterator implements Iterator<Integer>{
		private Integer i = 7;

		@Override
		public boolean hasNext() {
			return true;
		}

		@Override
		public Integer next() {
			do {
				i += 2;
			} while (primes.isPrime(i));
			return i;
		}

		@Override
		public void remove() {
			// no supported
		}
	}
}
