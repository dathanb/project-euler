package org.dathan.euler.problem367;

import java.util.Random;

public class NumberArray {
	private int[] nums;
	private Random random;
	
	public NumberArray (int arraySize, int permutation) {
		random = new Random();
		nums = new int[arraySize];
		for (int i=11; i>0; i--) {
			nums[i] = permutation % i;
			permutation /= i;
		}
	}
	
	public boolean isSorted() {
		for (int i=0; i<nums.length-1; ++i) {
			if (nums[i+1] < nums[i])
				return false;
		}
		return true;
	}

	public void randomShuffle() {
		int i1, i2, i3;
		i1 = random.nextInt(nums.length);
		do {
			i2 = random.nextInt(nums.length);
		} while (i2 == i1);
		do {
			i3 = random.nextInt(nums.length);
		} while ((i3 == i1) || (i3 == i2));
		int temp = nums[i3];
		nums[i3] = nums[i2];
		nums[i2] = nums[i1];
		nums[i1] = temp;
	}
}
