package com.kodilla.testing.shapes;

public class Circle implements Shape{

    private double pi = 3.14;
    private double r;

    public Circle(double r) {
        this.r = r;
    }
    @Override
    public String getShapeName() {
        return "Circle";
    }

    @Override
    public double getField() {
        return (r * pi) * 2;
    }

    public double getPi() {
        return pi;
    }

    public double getR() {
        return r;
    }
}
