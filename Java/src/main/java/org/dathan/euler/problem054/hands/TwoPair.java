package org.dathan.euler.problem054.hands;

import org.dathan.euler.problem054.Card;
import org.dathan.euler.problem054.Cards;

class TwoPair extends Hand {
    public static Hand newTwoPair(Card[] cards) {
        Card[] sorted = Cards.getSortedByFace(cards);
        for (int i = 1; i < 5; i++) {
            if (sorted[i].getFace() == sorted[i - 1].getFace() + 1) {
                return new TwoPair(cards, sorted[i]);
            }
        }
        return null;
    }

    private Card pairCard;

    protected TwoPair(Card[] cards, Card pairCard) {
        super(Cards.getSortedByFace(cards));
        this.pairCard = pairCard;
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
        if (pairCard.compareTo(otherPair.pairCard) != 0) {
            return pairCard.compareTo(otherPair.pairCard);
        }

        return compareCards(this, o);
    }
}