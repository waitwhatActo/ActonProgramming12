package com.acton.module2.e5Maps;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        CaesarCipher cipher = new CaesarCipher(5);
        String a = cipher.encrypt("now, what happens if i used puncs.?");
        System.out.println(a);
        System.out.println(cipher.decrypt(a));

        CaesarCipher cipher2 = new CaesarCipher(0);
        System.out.println(cipher2.crack(a));
    }
}
