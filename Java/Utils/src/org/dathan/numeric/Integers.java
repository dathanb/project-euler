package org.dathan.numeric;

import java.util.HashSet;
import java.util.Set;

public abstract class Integers {
	public static Set<Integer> getDistinctDigits(int number) {
		Set<Integer> digits = new HashSet<Integer>();
		
		while (number > 0) {
			digits.add(number % 10);
			number/=10;
		}
		return digits;
	}

}
