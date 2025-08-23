package com.acton.module2.e5Maps;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CaesarCipher {
    Map<Character, Character> encryptMap = new HashMap<Character, Character>();
    Map<Character, Character> decryptMap = new HashMap<Character, Character>();
    public CaesarCipher(int shift) {
        for (int i = 0; i < 26 ; i++) {
            encryptMap.put((char) (i + 'a'), (char) ('a' + (i + shift) % 26));
        }
        for (int i = 0; i < 26; i++) {
            decryptMap.put((char) ('a' + (i + shift) % 26), (char) (i + 'a'));
        }
    }

    public String encrypt(String text) {
        text = text.toLowerCase();
        String newStr = "";
        for (int i = 0; i < text.length(); i++) newStr += encryptMap.containsKey(text.charAt(i)) ? encryptMap.get(text.charAt(i)) : text.charAt(i);
        return newStr;
    }

    public String decrypt(String text) {
        text = text.toLowerCase();
        String newStr = "";
        for (int i = 0; i < text.length(); i++) newStr += decryptMap.containsKey(text.charAt(i)) ? decryptMap.get(text.charAt(i)) : text.charAt(i);
        return newStr;
    }

    public String crack(String text) throws FileNotFoundException {
        Set<String> dict = new HashSet<String>();
        Scanner sc = new Scanner(new File("Unit 2\\src\\com\\acton\\module2\\e5Maps\\words_alpha.txt"));
        while (sc.hasNextLine()) dict.add(sc.nextLine());
        text = text.toLowerCase();
        int shift = 0;
        int count = 0;
        String finalStr = "";
        for (int i = 0; i < 26; i++) {
            String newStr = "";
            int matchCount = 0;
            Map<Character, Character> crackMap = new HashMap<Character, Character>();
            for (int j = 0; j < 26 ; j++) {
                crackMap.put((char) ('a' + (j - i + 26) % 26), (char) (j + 'a'));
            }
            for (int j = 0; j < text.length(); j++) newStr += crackMap.containsKey(text.charAt(j)) ? crackMap.get(text.charAt(j)) : text.charAt(j);
            ArrayList<String> splitString = new ArrayList<String>(List.of(newStr.split(" ")));
            for (String word : splitString) {
                if (dict.contains(word)) matchCount++;
            }
            if (matchCount > count) {
                count = matchCount;
                shift = i;
                finalStr = newStr;
            }
        }
        return finalStr;
    }
}
