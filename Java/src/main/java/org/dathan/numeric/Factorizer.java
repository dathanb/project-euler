package org.dathan.numeric;

import java.util.HashMap;
import java.util.Map;

public class Factorizer {
	private PrimeSet primes = new PrimeSet();
	
	public Factorizer() {
	}
	
	public Map<Integer, Integer> getPrimeFactorMap(int num) {
		Map<Integer, Integer> primeFactorMap = new HashMap<Integer, Integer>();
		
		primes.populatePrimesUpTo(num);
		
		int temp = num;
		for (Integer prime: primes.getPrimeList()) {
			while (temp % prime == 0) {
				Integer count = primeFactorMap.get(prime);
				if (count == null) {
					count = 0;
				}
				++count;
				primeFactorMap.put(prime, count);
				temp /= prime;
			}
		}
		
		return primeFactorMap;
	}
}
