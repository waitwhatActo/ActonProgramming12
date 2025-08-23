package com.acton.module2.b2List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Deck {
    private LinkedList<Card> deck;

    public Deck() {
        deck = new LinkedList<>();
        createDeck();
    }

    private void createDeck() {
        for (int i = 1; i <= 13; i++) {
            for (Suit suit : Suit.values()) {
                deck.add(new Card(suit, i));
            }
        }
    }

    public void shuffle() {
        ArrayList<Card> shuffleDeck = new ArrayList<Card>(deck);
        for (int i = 0; i < deck.size(); i++) {
            int num = (int) (Math.random() * shuffleDeck.size());
            Card temp = shuffleDeck.get(i);
            shuffleDeck.set(i, shuffleDeck.get(num));
            shuffleDeck.set(num, temp);
        }
        deck.clear();
        deck.addAll(shuffleDeck);
        System.out.println("Shuffled!");
    }

    public Card drawCard() {
        return deck.pop();
    }

    public List<Card> drawHand(int n) {
        List<Card> hand = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            hand.add(drawCard());
        }
        return hand;
    }

    public String toString() {
        String str = "";
        for (Card card : deck) str += card.toString() + "\n";
        return str;
    }
}
