package com.acton.module2.b2List;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println(deck.toString());
        deck.shuffle();
        System.out.println(deck.toString());

        List<Card> hand = deck.drawHand(7);
        for (Card card : hand) {
            System.out.println(card);
        }
    }
}
