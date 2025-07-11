package com.acton.module1.d4Enumerations;

public class Triangle extends TwoDShape implements Rotate {
    private double side1;
    private double side2;
    private double side3;
    private double rotation = 0;
    // constrcutors
    public Triangle(double width, double height) {
        super(width, height);
    }

    public Triangle(double width, double height, Colour colour) {
        super(width, height, colour);
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        setWidth(side1);
        setHeight(heronsHeight(side1, side2, side3));
    }

    public Triangle(double side1, double side2, double side3, Colour colour) {
        super(side1, heronsHeight(side1, side2, side3), colour);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    } //end of contrsucotrs

    public double getArea() {
        if (side1 > 0 && side2 > 0 && side3 > 0) {                  // If all sides are not 0
            return side1 * heronsHeight(side1, side2, side3) / 2.0; // Then run the equation and divide by 2 to get area
        }
        else if (getWidth() > 0 && getHeight() > 0) {               // Otherwise if width and height isn't 0
            return getWidth() * getHeight() / 2.0;                  // then use width * height / 2 to get area
        }
        else {
            return 0.0;                                             // if everything fails then it's nothing.
        }
    }

    private static double heronsHeight(double a, double b, double c) {
        if (a == 0) return 0.0;                                     // If A (Side1) is 0 then return 0.0
        double s = (a + b + c) / 2.0;                               // S in Heron's Formula
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));   // Area of Triangle
        return (2.0 * area) / a;                                    // Return height using equation Area = 1/2bh
    }
    // Set/Get Sides
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
    // Rotate Triangle
    public void rotate90() {
        if (rotation < 270) {   // If it's under 270 degrees
            rotation += 90;     // Rotate it 90 degrees
        }
        else {                  // Otherwise
            rotation -= 270;    // Rotate it 270 degrees the other way
        }
    }

    public void rotate180() {
        if (rotation < 180) {   // Same here
            rotation += 180;
        }
        else {
            rotation -= 180;
        }
    }

    public void rotate(double degree) {
        if (rotation + degree >= 360) { // If current rotation + new rotation >= 360 degree
            rotation += degree - 360;   // Rotate it by new rotation - 360 degrees
        }
        else {
            rotation += degree;         // Bla
        }
    }

    public double getRotation() {
        return rotation;
    }

    public String toString() {
        return "Triangle[side1=" + side1 + ", side2=" + side2 + ", side3=" + side3 + ", heronsHeight=" + heronsHeight(side1, side2, side3) + ", area=" + getArea() + ", colour=" + getColour() + ", rotation=" + getRotation() + "°]";
    }

}
