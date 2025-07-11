package com.acton.module1.d4Enumerations;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<TwoDShape> shapes = new ArrayList<>();
        shapes.add(new Circle(5.00));
        shapes.add(new Circle(15.00, Colour.BLUE));
        shapes.add(new Triangle(9,6,6));
        shapes.add(new Triangle(10,5, Colour.RED));
        shapes.add(new Triangle(7,8));
        shapes.add(new Triangle(10,6,4, Colour.GREEN));
        for (TwoDShape shape : shapes) {
            System.out.println(shape.getArea());
            System.out.println(shape.toString());
        }
    }
}
