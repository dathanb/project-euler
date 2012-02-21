package org.dathan.euler.problem054;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.dathan.euler.problem054.hands.Hand;

public class HandReader {
	private List<Hand> player1Hands;
	private List<Hand> player2Hands;
	int index;

	public HandReader(String filename) {
		readHands(filename);
		index = -1;
	}
	
	private void readHands(String filename) {
		player1Hands = new ArrayList<Hand>();
		player2Hands = new ArrayList<Hand>();
		
		try {
			Scanner scanner = new Scanner(new File(filename));
			scanner.useDelimiter(" ");
			String token;
			while (scanner.hasNext()) {
				token = scanner.next();
				Card player1Card1 = new Card(token.charAt(0), token.charAt(1));
				token = scanner.next();
				Card player1Card2 = new Card(token.charAt(0), token.charAt(1));
				token = scanner.next();
				Card player1Card3 = new Card(token.charAt(0), token.charAt(1));
				token = scanner.next();
				Card player1Card4 = new Card(token.charAt(0), token.charAt(1));
				token = scanner.next();
				Card player1Card5 = new Card(token.charAt(0), token.charAt(1));
				token = scanner.next();
				Card player2Card1 = new Card(token.charAt(0), token.charAt(1));
				token = scanner.next();
				Card player2Card2 = new Card(token.charAt(0), token.charAt(1));
				token = scanner.next();
				Card player2Card3 = new Card(token.charAt(0), token.charAt(1));
				token = scanner.next();
				Card player2Card4 = new Card(token.charAt(0), token.charAt(1));
				token = scanner.next();
				Card player2Card5 = new Card(token.charAt(0), token.charAt(1));
				player1Hands.add(Hand.newHand(player1Card1, player1Card2, player1Card3, player1Card4, player1Card5));
				player2Hands.add(Hand.newHand(player2Card1, player2Card2, player2Card3, player2Card4, player2Card5));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean hasNext() {
		return index < player1Hands.size()-1;
	}
	
	public void moveNext() {
		++index;
	}
	
	public Hand getPlayer1Hand() {
		return player1Hands.get(index);
	}
	
	public Hand getPlayer2Hand() {
		return player2Hands.get(index);
	}
}
