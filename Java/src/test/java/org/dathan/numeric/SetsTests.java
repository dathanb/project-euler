package org.dathan.numeric;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class SetsTests {
	@Test
	public void smokeTest() {
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		
		System.out.println(Sets.powerSet(set));
	}
}
