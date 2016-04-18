package org.dathan.numeric;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class LazyRepeatedFractionTests {

    @Test
    public void smokeTestRepeatedFractions() {
        assertThat(runRepeatedFraction(2, 10), equalTo(Arrays.asList(1,2,2,2,2,2,2,2,2,2)));
        assertThat(runRepeatedFraction(3, 10), equalTo(Arrays.asList(1,1,2,1,2,1,2,1,2,1)));
        assertThat(runRepeatedFraction(5, 10), equalTo(Arrays.asList(2,4,4,4,4,4,4,4,4,4)));
        assertThat(runRepeatedFraction(6, 10), equalTo(Arrays.asList(2,2,4,2,4,2,4,2,4,2)));
        assertThat(runRepeatedFraction(23, 10), is(equalTo(Arrays.asList(4,1,3,1,8,1,3,1,8,1))));
    }

    private List<Integer> runRepeatedFraction(int num, int numEntries) {
        List<Integer> digits = new ArrayList<>();
        LazyRepeatedFraction frac = new LazyRepeatedFraction(num);
        for (int i=0; i<numEntries; i++) {
            digits.add(frac.next());
        }
        return digits;
    }
}
