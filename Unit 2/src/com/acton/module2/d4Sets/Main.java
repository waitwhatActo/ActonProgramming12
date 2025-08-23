package com.acton.module2.d4Sets;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        HashSet<Word> uniqueWords = new HashSet<>();

        Scanner scanner = new Scanner(new File("Unit 2\\src\\com\\acton\\module2\\d4Sets\\illiad.txt"));
        while (scanner.hasNext()) {
            uniqueWords.add(new Word(scanner.next()));
        }
        scanner.close();

        System.out.println("Unique words: " + uniqueWords.size());
    }
}
