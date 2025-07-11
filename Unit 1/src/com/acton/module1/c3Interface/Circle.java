package com.acton.module1.c3Interface;

public class Circle extends TwoDShape {
    public static final double PI = Math.PI;
    private double radius;

    public Circle(double radius) {
        super(radius * 2, radius * 2);
        this.radius = radius;
    }

    public double getArea() {
        return PI * Math.pow(radius, 2);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String toString() {
        return "com.acton.module1.c3.Circle [radius=" + radius + ", area=" + getArea() + "]";
    }
}
