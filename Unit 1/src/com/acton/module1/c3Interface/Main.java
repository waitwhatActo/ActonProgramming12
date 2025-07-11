package com.acton.module1.c3Interface;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<TwoDShape> shapes = new ArrayList<>();
        shapes.add(new Circle(5.00));
        shapes.add(new Triangle(9,6,6));
        for (TwoDShape shape : shapes) {
            System.out.println(shape.getArea());
            System.out.println(shape.toString());
        }
    }
}
