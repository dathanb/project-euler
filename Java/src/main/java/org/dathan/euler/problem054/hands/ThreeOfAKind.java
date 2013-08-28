package org.dathan.euler.problem054.hands;

import org.dathan.euler.problem054.Card;
import org.dathan.euler.problem054.Cards;

class ThreeOfAKind extends Hand {
    private Card threeCard;

    /**
     * Note: will mistakenly identify four of a kind and full house as three of a kind
     * @param cards
     * @return
     */
    public static Hand newThreeOfAKind(Card[] cards) {
        Card[] sorted = Cards.getSortedByFace(cards);

        if (sorted[0].compareTo(cards[2]) == 0) {
            return new ThreeOfAKind(cards, sorted[0]);
        } else if (sorted[1].compareTo(cards[3]) == 0) {
            return new ThreeOfAKind(cards, sorted[1]);
        } else if (sorted[2].compareTo(cards[4]) == 0) {
            return new ThreeOfAKind(cards, sorted[2]);
        } else {
            return null;
        }
    }

    protected ThreeOfAKind(Card[] cards, Card threeCard) {
        super(cards);
        this.threeCard = threeCard;
    }

    @Override
    public int compareTo(Hand o) {
        if (o instanceof StraightFlush
                || o instanceof FourOfAKind
                || o instanceof FullHouse
                || o instanceof Flush
                || o instanceof Straight) {
            return -1;
        } else if (!(o instanceof ThreeOfAKind)) {
            return 1;
        } else if (threeCard.compareTo(((ThreeOfAKind)o).threeCard) != 0) {
            return threeCard.compareTo(((ThreeOfAKind)o).threeCard);
        } else {
            return compareCards(this, o);
        }
    }
}