package org.dathan.euler.problem054.hands;

import org.dathan.euler.problem054.Card;
import org.dathan.euler.problem054.Cards;

class Pair extends Hand {
    private Card pair;

    /**
     * Note: will incorrectly report two pair, three of a kind, four of a kind, and full house as a pair
     * @param cards
     * @return
     */
    public static Hand newPair(Card... cards) {
        Card[] sortedCards = Cards.getSortedByFace(cards);
        for (int i=1; i<5; ++i) {
            if (sortedCards[i].compareTo(sortedCards[i-1]) == 0) {
                return new Pair(sortedCards, sortedCards[i]);
            }
        }
        return null;
    }

    public Pair(Card[] cards, Card pair) {
        super(cards);
        this.pair = pair;
    }

    @Override
    public int compareTo(Hand other) {
        if (other instanceof HighCard) {
            return 1;
        } else if (! (other instanceof Pair)) {
            return -1;
        } else {
            if (pair.compareTo(((Pair)other).pair) != 0) {
                return pair.compareTo(((Pair)other).pair);
            }
            for (int i=4; i>=0; --i) {
                if (cards.get(i).compareTo(other.cards.get(i)) != 0) {
                    return cards.get(i).compareTo(other.cards.get(i));
                }
            }
            return 0;
        }
    }
}