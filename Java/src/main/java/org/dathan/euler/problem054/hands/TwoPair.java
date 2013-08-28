package org.dathan.euler.problem054.hands;

import org.dathan.euler.problem054.Card;
import org.dathan.euler.problem054.Cards;

class TwoPair extends Hand {
    public static TwoPair newTwoPair(Card[] cards) {
        Card[] sorted = Cards.getSortedByFace(cards);

        if (sorted[0].compareTo(sorted[1]) == 0) {
            if (sorted[2].compareTo(sorted[3]) == 0) {
                return new TwoPair(sorted, sorted[0], sorted[2]);
            } else if (sorted[3].compareTo(sorted[4]) == 0) {
                return new TwoPair(sorted, sorted[0], sorted[3]);
            }
        } else if (sorted[1].compareTo(sorted[2]) == 0
                && sorted[3].compareTo(sorted[4]) == 0) {
            return new TwoPair(sorted, sorted[1], sorted[3]);
        }
        return null;
    }

    private Card higherPairCard;
    private Card lowerPairCard;

    protected TwoPair(Card[] cards, Card firstPair, Card secondPair) {
        super(Cards.getSortedByFace(cards));
        if (firstPair.compareTo(secondPair) > 0) {
            higherPairCard = firstPair;
            lowerPairCard = secondPair;
        } else {
            higherPairCard = secondPair;
            lowerPairCard = firstPair;
        }
    }

    @Override
    public int compareTo(Hand o) {
        if (o instanceof HighCard || o instanceof Pair) {
            return 1;
        }

        if (!(o instanceof TwoPair)) {
            return -1;
        }

        TwoPair otherPair = (TwoPair)o;
        if (higherPairCard.compareTo(otherPair.higherPairCard) != 0) {
            return higherPairCard.compareTo(otherPair.higherPairCard);
        } else if (lowerPairCard.compareTo(otherPair.lowerPairCard) != 0) {
            return lowerPairCard.compareTo(otherPair.lowerPairCard);
        } else {
            return compareCards(this, o);
        }
    }

    @Override
    public String toString() {
        return "Two pair: " + getCardsString();
    }
}