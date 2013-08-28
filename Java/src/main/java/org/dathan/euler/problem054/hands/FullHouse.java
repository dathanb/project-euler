package org.dathan.euler.problem054.hands;

import org.dathan.euler.problem054.Card;
import org.dathan.euler.problem054.Cards;

class FullHouse extends Hand {
    private Card threeOfAKind;
    private Card pair;

    public static Hand newFullHouse(Card[] cards) {
        Card[] sortedCards = Cards.getSortedByFace(cards);

        if (sortedCards[0].compareTo(sortedCards[1]) == 0
                && sortedCards[3].compareTo(sortedCards[4]) == 0) {
            if (sortedCards[0].compareTo(sortedCards[2]) == 0) {
                return new FullHouse(sortedCards, sortedCards[0], sortedCards[4]);
            } else if (sortedCards[4].compareTo(sortedCards[2]) == 0) {
                return new FullHouse(sortedCards, sortedCards[4], sortedCards[0]);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    protected FullHouse(Card[] cards, Card threeOfAKind, Card pair) {
        super(cards);
        this.threeOfAKind = threeOfAKind;
        this.pair = pair;
    }

    @Override
    public int compareTo(Hand o) {
        if (o instanceof StraightFlush) {
            return -1;
        } else if (o instanceof FourOfAKind) {
            return -1;
        } else if (!(o instanceof FullHouse)) {
            return 1;
        } else {
            FullHouse otherFullHouse = (FullHouse)o;
            if (threeOfAKind.compareTo(otherFullHouse.threeOfAKind) != 0) {
                return threeOfAKind.compareTo(otherFullHouse.threeOfAKind);
            } else if (pair.compareTo(otherFullHouse.pair) != 0) {
                return pair.compareTo(otherFullHouse.pair);
            } else {
                return 0;
            }
        }
    }
}