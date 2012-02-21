package org.dathan.euler.problem054.hands;

import org.dathan.euler.problem054.Card;

class HighCard extends Hand {
	public static Hand newHighCard(Card[] cards) {
		return new HighCard(cards);
	}
	
	public HighCard(Card... cards) {
		super(cards);
	}

	@Override
	public int compareTo(Hand o) {
		// TODO Auto-generated method stub
		return 0;
	}
}