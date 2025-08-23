package com.acton.module2.c3Compare;

import java.util.Comparator;

public class Comparators {
    public static class SuitComparator implements Comparator<Card> {
        @Override
        public int compare(Card card1, Card card2) {
            if (card1.getSuit().ordinal() > card2.getSuit().ordinal()) return 1;
            else if (card1.getSuit().ordinal() < card2.getSuit().ordinal()) return -1;
            else return 0;
        }
    }

    public static class FaceCardComparator implements Comparator<Card> {
        @Override
        public int compare(Card card1, Card card2) {
            return Boolean.compare(card1.isFaceCard(), card2.isFaceCard());
        }
    }
}

