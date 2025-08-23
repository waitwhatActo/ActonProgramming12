package com.acton.module2.b2List;

public enum Suit {
    HEARTS, DIAMONDS, CLUBS, SPADES;

    @Override
    public String toString() {
        return name().substring(0,1).toUpperCase() + name().substring(1).toLowerCase();
    }
}
