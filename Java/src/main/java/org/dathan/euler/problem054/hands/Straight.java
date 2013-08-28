package org.dathan.euler.problem054.hands;

import org.dathan.euler.problem054.Card;
import org.dathan.euler.problem054.Cards;

class Straight extends Hand {
    public static Hand newStraight(Card[] cards) {
        Card[] sorted = Cards.getSortedByFace(cards);
        for (int i=1; i<5; ++i) {
            if (sorted[i].getFace() != sorted[i-1].getFace()+1) {
                return null;
            }
        }
        return new Straight(sorted);
    }

    protected Straight(Card[] cards) {
        super(cards);
    }

    @Override
    public int compareTo(Hand o) {
        if ((o instanceof StraightFlush)
                || (o instanceof FourOfAKind)
                || (o instanceof FullHouse)
                || (o instanceof Flush)) {
            return -1;
        } else if (!(o instanceof Straight)) {
            return 1;
        } else {
            for (int i=4; i>=0; i++) {
                if (cards.get(i).compareTo(o.cards.get(i)) != 0) {
                    return cards.get(i).compareTo(o.cards.get(i));
                }
            }
            return 0;
        }
    }
}