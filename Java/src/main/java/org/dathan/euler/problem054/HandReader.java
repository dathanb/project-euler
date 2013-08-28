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
//            scanner.useDelimiter(" ");
            String token;
            while (scanner.hasNext()) {
                Card[] playerOneCards = new Card[5];
                Card[] playerTwoCards = new Card[5];
                for (int i = 0; i < 5; i++) {
                    playerOneCards[i] = new Card(scanner.next());
                }
                for (int i = 0; i < 5; i++) {
                    playerTwoCards[i] = new Card(scanner.next());
                }
                player1Hands.add(Hand.newHand(playerOneCards));
                player2Hands.add(Hand.newHand(playerTwoCards));
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public boolean hasNext() {
        return index < player1Hands.size() - 1;
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
