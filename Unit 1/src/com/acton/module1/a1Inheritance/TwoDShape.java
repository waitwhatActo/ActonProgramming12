package com.acton.module1.a1Inheritance;

public class TwoDShape {
    private double width;
    private double height;

    public TwoDShape() {

    }

    public TwoDShape(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String toString() {
        return width + "x" + height;
    }
}
