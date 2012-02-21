package org.dathan.euler.problem054.hands;

import java.util.HashMap;
import java.util.Map;

import org.dathan.euler.problem054.Card;

class Pair extends Hand {
	private int pairFace;

	public static Hand newPair(Card... cards) {
		return new Pair(cards);
	}
	
	public Pair(Card... cards) {
		super(cards);
		Map<Integer, Integer> faceCounts = new HashMap<Integer, Integer>();
		for (Card card: cards) {
			int count = faceCounts.get(card);
			
		}
	}

	@Override
	public int compareTo(Hand other) {
		if (other instanceof HighCard) {
			return 1;
		} else if (other instanceof Pair) {
			Pair otherPair = (Pair)other;
			if (pairFace > otherPair.pairFace)
				return 1;
			else if (pairFace < otherPair.pairFace)
				return -1;
			else return compareHighCards(other.cards);
		} else if ((other instanceof TwoPair) ||
				(other instanceof ThreeOfAKind) ||
				(other instanceof Straight) ||
				(other instanceof Flush) ||
				(other instanceof FullHouse) ||
				(other instanceof FourOfAKind) ||
				(other instanceof StraightFlush)) {
			return -1;
		} else {
			throw new RuntimeException("Unknown hand type");
		}
	}
}