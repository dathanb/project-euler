package org.dathan.euler.problem054.hands;

import org.dathan.euler.problem054.Card;
import org.dathan.euler.problem054.Cards;

class Flush extends Hand {
    public static Hand newFlush(Card[] cards) {
        for (Card card: cards) {
            if (card.getSuit() != cards[0].getSuit()) {
                return null;
            }
        }

        Card[] sortedCards = Cards.getSortedByFace(cards);

        return new Flush(sortedCards);
    }

    public Flush(Card[] cards) {
        super(cards);
    }

    @Override
    public int compareTo(Hand o) {
        if (o instanceof StraightFlush) {
            return -1;
        } else if (o instanceof FourOfAKind) {
            return -1;
        } else if (o instanceof FullHouse) {
            return -1;
        } else if (!(o instanceof Flush)) {
            return 1;
        } else {
            Flush otherFlush = (Flush)o;
            for (int i=4; i>=0; --i) {
                if (cards.get(i).compareTo(otherFlush.cards.get(i)) != 0) {
                    return cards.get(i).compareTo(otherFlush.cards.get(i));
                }
            }
            return 0;
        }
    }
}