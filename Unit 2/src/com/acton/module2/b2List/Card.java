package com.acton.module2.b2List;

public class Card {
    private Suit suit;
    private int rank;
    private boolean faceCard = false;

    public Card(Suit suit, int rank) {
        this.suit = suit;
        this.rank = rank;
        if (rank > 10) faceCard = true;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String toString() {
        String rankStr = switch (rank) {
            case 1 -> "Ace";
            case 11 -> "Jack";
            case 12 -> "Queen";
            case 13 -> "King";
            default -> Integer.toString(rank);
        };
        return rankStr + " of " + suit;
    }
}
