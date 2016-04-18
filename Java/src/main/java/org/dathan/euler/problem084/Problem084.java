package org.dathan.euler.problem084;

import java.util.*;

public class Problem084 {
    public static void main(String... args) {
        new Problem084().run();
    }

    private Random random;

    private Problem084() {
        this.random = new Random();
        for(int i=0; i<squares.length; i++) {
            squareMap.put(squares[i], i);
        }
    }

    private Map<String, Integer> visits = new HashMap<>();
    String[] squares = {"GO", "A1", "CC1", "A2", "T1", "R1", "B1", "CH1", "B2", "B3", "JAIL",
            "C1", "U1", "C2", "C3", "R2", "D1", "CC2", "D2", "D3", "FP",
            "E1", "CH2", "E2", "E3", "R3", "F1", "F2", "U2", "F3", "G2J",
            "G1", "G2", "CC3", "G3", "R4", "CH3", "H1", "T2", "H2"};

    String[] chanceCards = {"GO", "JAIL", "C1", "E3", "H2", "R1", "Next R", "Next R", "Next U", "Back 3", "NOP", "NOP", "NOP", "NOP", "NOP", "NOP"};
    String[] communityChestCards = { "GO", "JAIL", "NOP", "NOP", "NOP", "NOP", "NOP", "NOP", "NOP", "NOP", "NOP", "NOP", "NOP", "NOP", "NOP", "NOP"};

    Map<String, Integer> squareMap = new HashMap<>();
    int chanceIndex = 0;
    int communityChestIndex = 0;

    private void run() {

        for (int count=0; count<100000000; count++) {
            getNextSquare();
            String nextSquare = squares[currentPosition];
//            System.out.print(nextSquare);
//            System.out.print("\t");
            visits.put(nextSquare, visits.getOrDefault(nextSquare, 0)+1);
        }

        // Sort the squares by visit count
        List<Map.Entry<String, Integer>> list = new LinkedList<>(visits.entrySet());
        Collections.sort(list, (o1, o2) -> ((Comparable) ((Map.Entry) (o2)).getValue()).compareTo(((Map.Entry) (o1)).getValue()));
        for (Map.Entry<String, Integer> entry: list) {
            System.out.println(String.format("%s: %d", entry.getKey(), entry.getValue()));
        }

        System.out.println(String.format("%02d%02d%02d",
                squareMap.get(list.get(0).getKey()),
                squareMap.get(list.get(1).getKey()),
                squareMap.get(list.get(2).getKey())));
    }

    int doubleCount = 0;
    int currentPosition = 0;

    private void getNextSquare() {
        DieRoll roll = rollDice();
        if (roll.isDouble()) {
            doubleCount += 1;
            if (doubleCount == 3) {
                doubleCount = 0;
                moveTo("JAIL");
                return;
            }
        } else {
            doubleCount = 0;
        }
        currentPosition = (currentPosition + roll.getTotal()) % squares.length;
        if (isGoToJail(currentPosition)) {
            moveTo("JAIL");
        } else if (isCommunityChest(currentPosition)) {
            doCommunityChest();
        } else if (isChance(currentPosition)) {
            doChance();
            if (isCommunityChest(currentPosition)) {
                doCommunityChest();
            }
        }
    }

    private DieRoll rollDice() {
        return new DieRoll(random.nextInt(4) + 1, random.nextInt(4) + 1);
    }

    private boolean isCommunityChest(int position) {
        return squares[position].startsWith("CC");
    }

    private void doCommunityChest() {
        String card = communityChestCards[communityChestIndex];
        communityChestIndex = (communityChestIndex + 1) % communityChestCards.length;
        if (card.equals("NOP")) {
            // do nothing
        } else {
            moveTo(card);
        }
    }

    private boolean isChance(int position) {
        return squares[position].startsWith("CH");
    }

    private void doChance() {
        String card = chanceCards[chanceIndex];
        chanceIndex = (chanceIndex + 1) % chanceCards.length;
        if (card.equals("NOP")) {
            // do nothing
        } else if (card.equals("Next R")) {
            int nextPosition = currentPosition + 1;
            while (!isRailRoad(nextPosition % squares.length)) {
                nextPosition++;
            }
            currentPosition = nextPosition % squares.length;
        } else if (card.equals("Next U")) {
            int nextPosition = currentPosition + 1;
            while (!isUtility(nextPosition % squares.length)) {
                nextPosition++;
            }
            currentPosition = nextPosition % squares.length;
        } else if (card.equals("Back 3")) {
            currentPosition -= 3;
        } else {
            moveTo(card);
        }
    }

    private boolean isRailRoad(int position) {
        return squares[position].startsWith("R");
    }

    private boolean isUtility(int position) {
        return squares[position].startsWith("U");
    }

    private void moveTo(String squareName) {
        currentPosition = squareMap.get(squareName);
//        while (!squares[currentPosition].equals(squareName)) {
//            currentPosition = (currentPosition + 1) % squares.length;
//        }
    }

    private boolean isGoToJail(int position) {
        return squares[position].equals("G2J");
    }
}

class DieRoll {
    private int first;
    private int second;

    public DieRoll(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public boolean isDouble() {
        return first == second;
    }

    public int getTotal() {
        return first+second;
    }
}
