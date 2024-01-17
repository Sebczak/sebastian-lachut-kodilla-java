package com.kodilla.testing.shapes;

public class Rectangle implements Shape{

    private double a;
    private double b;

    public  Rectangle(double a, double h) {
        this.a = a;
        this.b = b;
    }
    @Override
    public String getShapeName() {
        return null;
    }

    @Override
    public double getField() {
        return a * b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }
}
