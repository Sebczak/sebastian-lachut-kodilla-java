package com.kodilla.testing.shapes;

public class Triangle implements Shape{

    private double a;
    private double h;

    public Triangle(double a, double h) {
        this.a = a;
        this.h = h;
    }
    @Override
    public String getShapeName() {
        return "Triangle";
    }

    @Override
    public double getField() {
        return (a * h) / 2;
    }

    public double getA() {
        return a;
    }

    public double getH() {
        return h;
    }
}
