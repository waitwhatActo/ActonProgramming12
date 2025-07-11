package com.acton.module1.a1Inheritance;

public class Triangle extends TwoDShape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double width, double height) {
        super(width, height);
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        setWidth(side1);
        setHeight(heronsHeight());
    }

    public double getArea() {
        if (side1 > 0 && side2 > 0 && side3 > 0) {
            return side1 * heronsHeight() / 2.0;
        }
        else if (getWidth() > 0 && getHeight() > 0) {
            return getWidth() * getHeight() / 2.0;
        }
        else {
            return 0.0;
        }
    }

    private double heronsHeight() {
        if (!(side1 > 0)) return 0.0;
        double s = (side1 + side2 + side3) / 2.0;
        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        return (2.0 * area) / side1;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public String toString() {
        return "S1: " + side1 + " S2: " + side2 + " S3: " + side3;
    }
}
