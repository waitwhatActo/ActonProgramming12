package com.acton.module2.c3Compare;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println(deck.toString());
        deck.shuffle();
        System.out.println(deck.toString());

        ArrayList<Card> hand = deck.drawHand(7);
        for (Card card : hand) {
            System.out.println(card);
        }

        hand.sort(new Comparators.FaceCardComparator());

        for (Card card : hand) {
            System.out.println(card);
        }

    }
}
