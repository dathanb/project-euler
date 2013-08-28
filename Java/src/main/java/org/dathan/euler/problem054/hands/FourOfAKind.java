package org.dathan.euler.problem054.hands;

import org.dathan.euler.problem054.Card;
import org.dathan.euler.problem054.Cards;

class FourOfAKind extends Hand {
    public static Hand newFourOfAKind(Card[] cards) {
        Card[] sortedCards = Cards.getSortedByFace(cards);

        if (sortedCards[0].getFace() == sortedCards[1].getFace()
                && sortedCards[2].getFace() == sortedCards[3].getFace()
                && sortedCards[0].getFace() == sortedCards[3].getFace()) {
            return new FourOfAKind(sortedCards);
        } else if (sortedCards[1].getFace() == sortedCards[2].getFace()
                    && sortedCards[3].getFace() == sortedCards[4].getFace()
                    && sortedCards[1].getFace() == sortedCards[4].getFace()) {
            return new FourOfAKind(sortedCards);
        } else {
            return null;
        }
    }

    private int fourOfAKindFace;
    private int kickerFace;

    public FourOfAKind(Card[] cards) {
        super(cards);

        if (cards[0].getFace() == cards[1].getFace()) {
            fourOfAKindFace = cards[0].getFace();
            kickerFace = cards[4].getFace();
        } else {
            fourOfAKindFace = cards[4].getFace();
            kickerFace = cards[0].getFace();
        }
    }

    @Override
    public int compareTo(Hand o) {
        if (o instanceof StraightFlush) {
            return -1;
        } else if (!(o instanceof FourOfAKind)) {
            return 1;
        } else if (fourOfAKindFace > ((FourOfAKind)o).fourOfAKindFace) {
            return 1;
        } else if (fourOfAKindFace < ((FourOfAKind)o).fourOfAKindFace) {
            return -1;
        } else if (kickerFace > ((FourOfAKind)o).kickerFace) {
            return 1;
        } else if (kickerFace < ((FourOfAKind)o).kickerFace) {
            return -1;
        } else {
            return 0;
        }
    }
}