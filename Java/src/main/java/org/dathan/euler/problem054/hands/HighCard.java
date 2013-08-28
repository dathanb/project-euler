package org.dathan.euler.problem054.hands;

import org.dathan.euler.problem054.Card;
import org.dathan.euler.problem054.Cards;

class HighCard extends Hand {
    public static Hand newHighCard(Card[] cards) {
        return new HighCard(Cards.getSortedByFace(cards));
    }

    public HighCard(Card... cards) {
        super(cards);
    }

    @Override
    public int compareTo(Hand o) {
        if (!(o instanceof HighCard)) {
            return -1;
        }
        for (int i=4; i>=0; --i) {
            if (cards.get(i).compareTo(o.cards.get(i)) != 0) {
                return cards.get(i).compareTo(o.cards.get(i));
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Nuffin: " + getCardsString();
    }
}