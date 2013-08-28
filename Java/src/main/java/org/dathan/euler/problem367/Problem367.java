package org.dathan.euler.problem367;

public class Problem367 {
	public static void main(String[] args) {
		new Problem367().run(4);
	}
	
	public Problem367() {
	}
	
	public void run(int arraySize) {
		int numPermutations = factorial(arraySize); // 11!
		long totalShuffles = 0;
		
		for (int i=0; i<numPermutations; ++i) {
			NumberArray array = new NumberArray(arraySize, i);
			int numShuffles = 0;
			while (!array.isSorted()) {
				array.randomShuffle();
				numShuffles++;
			}
			totalShuffles += numShuffles;
		}
		
		System.out.println(totalShuffles / numPermutations);
	}
	
	private int factorial(int i) {
		int total = 1;
		while (i > 0) {
			total *= i;
			i--;
		}
		return total;
	}
}
