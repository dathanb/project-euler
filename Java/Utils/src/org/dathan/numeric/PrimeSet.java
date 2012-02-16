package org.dathan.numeric;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrimeSet {
	private List<Integer> primeList;
	private Set<Integer> primeSet;
	
	public PrimeSet() {
		this(2);
	}
	
	public PrimeSet(int maxPrime) {
		primeList = new ArrayList<Integer>();
		primeSet = new HashSet<Integer>();
		primeList.add(2);
		primeSet.add(2);
		populatePrimesUpTo(maxPrime);
	}
	
	public void populatePrimesUpTo(int max) {
		for (int i=primeList.get(primeList.size()-1) + 1; primeList.get(primeList.size()-1) < max; ++i) {
			boolean isPrime = true;
			for (Integer prime: primeList) {
				if (i % prime == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primeList.add(i);
				primeSet.add(i);
			}
		}
	}
	
	public boolean isPrime(int i) {
		populatePrimesUpTo(i);
		return primeSet.contains(i);
	}
	
	public List<Integer> getPrimeList() {
		return primeList;
	}
}
