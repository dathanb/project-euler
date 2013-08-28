package org.dathan.euler.problem054.hands;

import org.dathan.euler.problem054.Card;
import org.dathan.euler.problem054.Cards;
import org.dathan.numeric.Integers;

class StraightFlush extends Hand {
    public static Hand newStraightFlush(Card[] cards) {
        Hand flush = Flush.newFlush(cards);
        if (flush == null)
            return null;

        // if we get here, it's at least a flush
        Card[] sortedByFace = Cards.getSortedByFace(cards);
        for (int i=1; i<cards.length; ++i) {
            if (cards[i].getFace() != cards[i-1].getFace()+1) {
                return null;
            }
        }

        return new StraightFlush(sortedByFace);
    }

    public StraightFlush(Card[] cards) {
        super(Cards.getSortedByFace(cards));
    }

    @Override
    public int compareTo(Hand o) {
        if (!(o instanceof StraightFlush)) {
            return 1;
        }

        return compareCards(this, o);
    }
}