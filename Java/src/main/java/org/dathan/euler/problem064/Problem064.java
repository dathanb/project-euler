package org.dathan.euler.problem064;

import org.dathan.numeric.LazyRepeatedFraction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem064 {
    public static void main(String... args) {
        new Problem064().run();
    }

    public void run() {
        int count = 0;

        for (int i=2; i<=10000; i++) {
            if (Math.pow(((int)Math.sqrt(i)), 2) == i) {
                continue;
            }
            List<LazyRepeatedFraction.State> entryList = new ArrayList<>();
            Set<LazyRepeatedFraction.State> entrySet = new HashSet<>();
            System.out.print(String.format("%d: ", i));
            LazyRepeatedFraction sequence = new LazyRepeatedFraction(i);
            System.out.print(String.format("%d, ", sequence.next())); // consume the initial integer part
            LazyRepeatedFraction.State newState = sequence.getState();
            while (!entrySet.contains(newState)) {
                entryList.add(newState);
                entrySet.add(newState);
                System.out.print(String.format("%d, ", sequence.next()));
                newState = sequence.getState();
            }


            int cycleLength = entryList.size();
            count += cycleLength % 2;
            System.out.println(String.format("Cycle length %s", cycleLength));
        }

        System.out.println(count);
    }

    int findCycle(List<LazyRepeatedFraction.State> entries) {
        for (int a=entries.size()-2; a>=0; a++) {
            if (entries.get(a) == entries.get(entries.size()-1)) {
                return entries.size() - a;
            }
        }
        throw new RuntimeException("No cycle found!");
    }
}


