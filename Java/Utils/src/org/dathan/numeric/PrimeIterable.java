package org.dathan.numeric;

import java.util.Iterator;

public class PrimeIterable implements Iterable<Integer>{
	private final PrimeSet primeSet;

	public PrimeIterable() {
		this(new PrimeSet());
	}
	
	public PrimeIterable(PrimeSet primeSet) {
		this.primeSet = primeSet;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new PrimeIterator(primeSet);
	}
	
	private static class PrimeIterator implements Iterator<Integer> {
		private final PrimeSet primeSet;
		private int index;

		public PrimeIterator(PrimeSet primeSet) {
			this.primeSet = primeSet;
			this.index = 0;
		}

		@Override
		public boolean hasNext() {
			return true;
		}

		@Override
		public Integer next() {
			primeSet.populatePrimesUpTo(primeSet.getPrimeList().get(index)+1);
			++index;
			return primeSet.getPrimeList().get(index);
		}

		@Override
		public void remove() {
			// not supported
		}
		
		
	}
	
}
