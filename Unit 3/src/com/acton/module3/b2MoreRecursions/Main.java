package com.acton.module3.b2MoreRecursions;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(seq1(i) + "");
        }
        for (int i = 1; i < 10; i++) {
            System.out.println(seq2(i) + "");
        }
        for (int i = 1; i < 10; i++) {
            System.out.println(seq3(i) + "");
        }
        for (int i = 1; i < 10; i++) {
            System.out.println(seq4(i) + "");
        }
        for (int i = 1; i < 10; i++) {
            System.out.println(seq5(i) + "");
        }
    }

    public static int seq1(int x) {
        if (x == 1) return 25;
        return seq1(x-1) - 2;
    }

    public static int seq2(int x) {
        if (x == 1) return 1;
        return seq2(x-1) * 2;
    }

    public static int seq3(int x) {
        if (x == 0) return 0;
        else if (x == 1) return 2;
        return seq3(x-1) + seq3(x-2);
    }

    public static int seq4(int x) {
        if (x == 0) return 0;
        else if (x == 1) return 3;
        return seq4(x-1) + seq4(x-2);
    }

    public static int seq5(int x) {
        if (x == 0) return 1;
        if (x == 1) return 1;
        return x * seq5(x-1);
    }
}
