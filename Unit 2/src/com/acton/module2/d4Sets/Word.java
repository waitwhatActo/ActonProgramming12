package com.acton.module2.d4Sets;

public class Word {
    private String text;

    public Word(String text) {
        this.text = text.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Word)) return false;
        Word other = (Word) obj;
        return text.equals(other.text);
    }

    public int hashCode() {
        return text.hashCode();
    }
}

