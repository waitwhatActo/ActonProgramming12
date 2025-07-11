package com.acton.module1.d4Enumerations;

public abstract class TwoDShape {
    private double width;
    private double height;
    private Colour colour;
    // constructors
    public TwoDShape() {
        // wow it's so empty in here
    }

    public TwoDShape(double width, double height) {
        this.width = width;
        this.height = height;
        this.colour = Colour.NONE;
    }

    public TwoDShape(double width, double height, Colour colour) {
        this.width = width;
        this.height = height;
        this.colour = colour;
    } // end of constructotsr
    // get set (except you can't set area)
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

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }
}
