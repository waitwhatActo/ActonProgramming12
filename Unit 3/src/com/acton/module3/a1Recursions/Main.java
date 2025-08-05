package com.acton.module3.a1Recursions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.print("Give N: ");
            Scanner sc = new Scanner(System.in);
            System.out.println(Integer.toString(fibonacciNumberFinder(sc.nextInt())));
        }
    }

    public static int fibonacciNumberFinder(int n) {
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (n == 0) return 0;
            else if (n == 1) return 1;
            else total = fibonacciNumberFinder(n-1) + fibonacciNumberFinder(n-2);
            System.out.println("wow");
        }
        return total;
    }
}
