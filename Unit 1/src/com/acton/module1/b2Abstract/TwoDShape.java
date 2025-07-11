package com.acton.module1.b2Abstract;

public abstract class TwoDShape {
    private double width;
    private double height;

    public TwoDShape() {

    }

    public TwoDShape(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public abstract double getArea();

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
}
