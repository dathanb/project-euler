package org.dathan.euler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.dathan.numeric.PrimeSet;

/*
The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways: (i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.

There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there is one other 4-digit increasing sequence.

What 12-digit number do you form by concatenating the three terms in this sequence?
 */

public class Problem049 {
	public static void main(String[] args) {
		new Problem049().run();
	}
	
	public Problem049() {
	}
	
	public void run() {
		Set<Integer> fourDigitPrimes = getFourDigitPrimes();
		Map<Integer, Collection<Integer>> permutationBuckets = bucketPermutations(fourDigitPrimes);
		Map<Integer, Collection<Integer>> allCandidateBuckets = discardBucketsSmallerThanThree(permutationBuckets);
		
		for (Integer key: allCandidateBuckets.keySet()) {
			Collection<Integer> candidateBucket = allCandidateBuckets.get(key);
			SortedSet<Integer> sortedCandidates = new TreeSet<Integer>();
			sortedCandidates.addAll(candidateBucket);
			List<Integer> candidates = new ArrayList<Integer>();
			candidates.addAll(sortedCandidates);
			for (int i = 0; i<candidates.size()-2; ++i) {
				int first = candidates.get(i);
				for (int j = i+1; j<candidates.size()-1; ++j) {
					int second = candidates.get(j);
					int third = 2 * second - first;
					if (sortedCandidates.contains(third)) {
						System.out.print(first);
						System.out.print(second);
						System.out.println(third);
						System.exit(0);
					}
				}
			}
		}
		
	}
	
	private Set<Integer> getFourDigitPrimes() {
		Set<Integer> fourDigitPrimes = new HashSet<Integer>();
		PrimeSet primes = new PrimeSet(10000);
		fourDigitPrimes.addAll(primes.getPrimeList());
		Iterator<Integer> iterator = fourDigitPrimes.iterator();
		while (iterator.hasNext()) {
			Integer value = iterator.next();
			if ((value < 1000) || (value > 9999)) 
				iterator.remove();
		}
		
		return fourDigitPrimes;
	}
	
	private Map<Integer, Collection<Integer>> bucketPermutations(Set<Integer> primes) {
		Map<Integer, Collection<Integer>> buckets = new HashMap<Integer, Collection<Integer>>();
		for (Integer prime: primes) {
			Integer key = getOrderInvariantKey(prime);
			Collection<Integer> primesInBucket = buckets.get(key);
			if (primesInBucket == null) {
				primesInBucket = new ArrayList<Integer>();
			}
			primesInBucket.add(prime);
			buckets.put(key, primesInBucket);
		}
		return buckets;
	}
	
	private int[] digitCoefficients = new int[] { 2, 11, 53, 223, 907, 3631, 14533, 58147, 232591, 930379 };
	private Integer getOrderInvariantKey(Integer prime) {
		int key = 0;
		int temp = prime;
		while (temp > 0) {
			key += digitCoefficients[temp%10];
			temp /= 10;
		}
		return key;
	}
	
	private Map<Integer, Collection<Integer>> discardBucketsSmallerThanThree(Map<Integer, Collection<Integer>> buckets) {
		Map<Integer, Collection<Integer>> newBuckets = new HashMap<Integer, Collection<Integer>>();
		for (Integer key: buckets.keySet()) {
			Collection<Integer> bucket = buckets.get(key);
			if (bucket.size() >= 3) {
				Collection<Integer> newBucket = new ArrayList<Integer>();
				newBucket.addAll(bucket);
				newBuckets.put(key, newBucket);
			}
		}
		return newBuckets;
	}
}
