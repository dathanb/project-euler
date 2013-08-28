package org.dathan.euler.problem054.hands;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.dathan.euler.problem054.Card;

public abstract class Hand implements Comparable<Hand>{
	protected List<Card> cards = new ArrayList<Card>();
	
	public static Hand newHand(Card... cards) {
		Hand hand;
		hand = StraightFlush.newStraightFlush(cards);
		if (hand != null)
			return hand;
		hand = FourOfAKind.newFourOfAKind(cards);
		if (hand != null)
			return hand;
		hand = FullHouse.newFullHouse(cards);
		if (hand != null)
			return hand;
		hand = Flush.newFlush(cards);
		if (hand != null)
			return hand;
		hand = Straight.newStraight(cards);
		if (hand != null)
			return hand;
		hand = ThreeOfAKind.newThreeOfAKind(cards);
		if (hand != null)
			return hand;
		hand = TwoPair.newTwoPair(cards);
		if (hand != null)
			return hand;
		hand = Pair.newPair(cards);
		if (hand != null)
			return hand;
		return HighCard.newHighCard(cards);
	}
	
	protected static int compareCards(Hand a, Hand b) {
        for (int i=4; i>=0; i--) {
            if (a.cards.get(i).compareTo(b.cards.get(i)) != 0) {
                return a.cards.get(i).compareTo(b.cards.get(i));
            }
        }
        return 0;
    }

    public Hand(Card... cards) {
		SortedSet<Card> sortedCards = new TreeSet<Card>();
		for (int i=0; i<cards.length; ++i) {
			sortedCards.add(cards[i]);
		}
		for (Card card: sortedCards) {
			this.cards.add(card);
		}
	}
	
	protected int compareHighCards(List<Card> otherCards) {
		for (int i=cards.size()-1; i>=0; --i) {
			int comparison = cards.get(i).compareTo(otherCards.get(i));
			if (comparison != 0)
				return comparison;
		}
		return 0;
	}
}
