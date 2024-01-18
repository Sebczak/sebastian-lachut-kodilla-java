package com.kodilla.testing.shapes;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapes;

    public ShapeCollector() {
        this.shapes = new ArrayList<>();
    }

    public void addFigure(Shape shape) {
        shapes.add(shape);

    }

    public boolean removeFigure(Shape shape) {
        boolean result = false;
        if (shapes.contains(shape)) {
            shapes.remove(shape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int n) {
        if(n >= 0 && n < shapes.size()) {
            return shapes.get(n);
        }

        return null;
    }

    public void showFigures() {
        for (Shape shape : shapes) {
            System.out.println("Shape: " + shape.getShapeName() + ", Field: " + shape.getField());
        }

    }


}

