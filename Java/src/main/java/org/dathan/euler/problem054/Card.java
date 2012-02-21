package org.dathan.euler.problem054;

public class Card implements Comparable<Card> {
	private int face;
	private char suit;
	
	public Card(char face, char suit) {
		this.face = getFace(face);
		this.suit = suit;
	}
	
	private int getFace(char val) {
		switch(val) {
		case '2': return 2;
		case '3': return 3;
		case '4': return 4;
		case '5': return 5;
		case '6': return 6;
		case '7': return 7;
		case '8': return 8;
		case '9': return 9;
		case 'T': return 10;
		case 'J': return 11;
		case 'Q': return 12;
		case 'K': return 13;
		case 'A': return 14;
		default:
			throw new RuntimeException();
		}
	}
	
	public int getFace() {
		return face;
	}
	
	public char getSuit() {
		return suit;
	}

	@Override
	public int compareTo(Card o) {
		return face > o.face ? 1 : (face < o.face ? -1 : 0);
	}
	
	@Override
	public int hashCode() {
		return (face * 31) + suit;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Card))
			return false;
		Card other = (Card)obj;
		return (face == other.face) && (suit == other.suit);
	}
	
	@Override
	public String toString() {
		char face;
		switch(this.face) {
		case 2: face = '2'; break;
		case 3: face = '3'; break;
		case 4: face = '4'; break;
		case 5: face = '5'; break;
		case 6: face = '6'; break;
		case 7: face = '7'; break;
		case 8: face = '8'; break;
		case 9: face = '9'; break;
		case 10: face = 'T'; break;
		case 11: face = 'J'; break;
		case 12: face = 'Q'; break;
		case 13: face = 'K'; break;
		case 14: face = 'A'; break;
		default: face = 'X'; break;
		}
		return String.format("%c%c", face, suit);
	}
	
}
