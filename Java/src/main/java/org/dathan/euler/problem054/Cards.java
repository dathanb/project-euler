package org.dathan.euler.problem054;

import java.util.Arrays;
import java.util.Comparator;

public class Cards {
    public static Card[] getSortedByFace(Card[] cards) {
        Card[] newCards = cards.clone();
        Arrays.sort(newCards, new Comparator<Card>(){
            @Override
            public int compare(Card arg0, Card arg1) {
                if (arg0.getFace() > arg1.getFace()) {
                    return 1;
                } else if (arg0.getFace() < arg1.getFace()) {
                    return -1;
                } else {
                    return 0;
                }
            }});
        return newCards;
    }
}
