package unit01.assignment01;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class introductory {
    public static void main(String[] args) {
        int coins = 28;
        double value = 0;
        for (int i = 0; i < coins; i++) {
            value += 0.01;
        }
        for (int i = 0; i < coins; i+=2) {
            value += 0.04;
        }
        for (int i = 0; i < coins; i+=3) {
            value += 0.09;
        }
        for (int i = 0; i < coins; i+=4) {
            value += 0.24;
        }
        System.out.println(value);
    }
}

class Question1 {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}

class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many hot dogs would you like to buy? ");
        int hotDogs = sc.nextInt();
        System.out.print("How many drinks would you like to buy? ");
        int drinks = sc.nextInt();

        System.out.println("Your total is $"+ Math.round(1.12d * (3.50d * hotDogs + drinks) * 100.0) / 100.0);
    }
}

class Question4 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 100);
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}

class Question9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the X coordinate: ");
        double x = sc.nextDouble();
        System.out.print("Enter the Y coordinate: ");
        double y = sc.nextDouble();
        if (x > 0) {
            if (y > 0) {
                System.out.println("Quadrant I");
            }
            else {
                System.out.println("Quadrant IV");
            }
        }
        else {
            if (y > 0) {
                System.out.println("Quadrant II");
            }
            else {
                System.out.println("Quadrant III");
            }
        }
    }
}

class Question10 {
    public static void main(String[] args) {
        int happyCount = 0;
        int sadCount = 0;
        try {
            File file = new File("happyorsad.txt");
            Scanner scanner = new Scanner(file);

            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == ':') {
                        if (line.charAt(i + 1) == '-') {
                            if (line.charAt(i + 2) == ')') {
                                happyCount++;
                            } else if (line.charAt(i + 2) == '(') {
                                sadCount++;
                            }
                        }
                    }
                }
            }
            scanner.close();
        }
        catch (FileNotFoundException e) {e.printStackTrace();}

        if (happyCount == sadCount && happyCount != 0) {
            System.out.println("Unsure...");
        }
        else if (happyCount > sadCount) {
            System.out.println("Happy!");
        }
        else if (sadCount > happyCount) {
            System.out.println("Sad.");
        }
        else {
            System.out.println("None?");
        }
    }
}