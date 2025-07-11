package com.acton.module1.d4Enumerations;

public class Circle extends TwoDShape {
    public static final double PI = Math.PI;
    private double radius;
    // Constructor w/ Radius ONLY
    public Circle(double radius) {
        super(radius * 2, radius * 2); // TwoDShape
        this.radius = radius; // Change local private variable
    }
    // Constructor w/ Radius + Colour
    public Circle(double radius, Colour colour) {
        super(radius * 2, radius * 2, colour); // TwoDShape
        this.radius = radius; // Change local private variable
    }
    // Return Area (πr^2)
    public double getArea() {
        return PI * Math.pow(radius, 2);
    }
    // Return Radius of Circle
    public double getRadius() {
        return radius;
    }
    // Set the Radius of the Circle
    public void setRadius(double radius) {
        this.radius = radius;
    }
    // Return String
    public String toString() {
        return "Circle[radius=" + radius + ", area=" + getArea() + ", colour=" + getColour() +"]";
    }
}
