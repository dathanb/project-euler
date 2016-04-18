package org.dathan.numeric;

import java.util.Iterator;

public class LazyRepeatedFraction implements Iterable<Integer>, Iterator<Integer> {
    private int rootPart;
    private int numIntPart;
    private int denominator;
    private boolean firstTime = true;

    public LazyRepeatedFraction(int root) {
        this.rootPart = root;
        this.numIntPart = 0;
        this.denominator = 1;
    }

    @Override
    public Iterator<Integer> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        int result;
        if (firstTime) {
            firstTime = false;
            result = (int) Math.sqrt(rootPart);
            numIntPart = -result;
            denominator = 1;
            return result;
        }
        // first invert: consider the new fraction of 1/(denominator/(sqrt(root)+numPart)
        // to move the radical into the numerator, we multiply by (sqrt(root) - numPart)/(sqrt(root)-numPart)
        int newDenominator = rootPart - numIntPart * numIntPart;
        int numeratorCoefficient = denominator;
        int newNumeratorIntPart = -numIntPart;
        // now simplify the new denominator
        newDenominator /= numeratorCoefficient;
        result = (int) ((Math.sqrt(rootPart) + newNumeratorIntPart) / newDenominator);
        newNumeratorIntPart = newNumeratorIntPart - result * newDenominator;
        denominator = newDenominator;
        numIntPart = newNumeratorIntPart;
        return result;
    }

    private double numerator() {
        return Math.sqrt(this.rootPart) + this.numIntPart;
    }

    public State getState() {
        return new State(this.numIntPart, this.denominator, this.rootPart);
    }

    public static class State {
        private int numeratorIntPart;
        private int denominator;
        private int rootPart;

        public State(int numeratorIntPart, int denominator, int rootPart) {
            this.numeratorIntPart = numeratorIntPart;
            this.denominator = denominator;
            this.rootPart = rootPart;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            State state = (State) o;

            if (numeratorIntPart != state.numeratorIntPart) return false;
            if (denominator != state.denominator) return false;
            return rootPart == state.rootPart;

        }

        @Override
        public int hashCode() {
            int result = numeratorIntPart;
            result = 31 * result + denominator;
            result = 31 * result + rootPart;
            return result;
        }
    }
}
