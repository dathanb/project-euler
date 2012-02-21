package org.dathan.euler.problem054.hands;

import org.dathan.euler.problem054.Card;

class Pair extends Hand {
	private int pairFace;

	
	public static Hand newPair(Card... cards) {
		if (isPair(cards))
			return new Pair(cards);
		else 
			return null;
	}
	
	private static boolean isPair(Card... cards) {
		return false;
	}
	
	public Pair(Card... cards) {
		super(cards);
		int[] faces = new int[15];
		for (int i=0; i<15; ++i) {
			faces[i] = 0;
		}
		for (Card card: cards) {
			faces[card.getFace()]++;
		}
		for (int i=0; i<15; ++i) {
			if (faces[i] == 2)
				pairFace = i;
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