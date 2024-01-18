package com.kodilla.testing.shapes.tdd;

import com.kodilla.testing.shapes.*;
import org.junit.jupiter.api.*;

@DisplayName("TDD: ShapeCollector Test Suite")
public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Tests for Circle")
    class TestCircle {

        @Test
        void testCircleAndField() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle(3);

            //When
            shapeCollector.addFigure(circle);
            Shape retrivedShape = shapeCollector.getFigure(0);

            //Then
            Assertions.assertNotNull(retrivedShape);
            Assertions.assertEquals(circle.getShapeName(), retrivedShape.getShapeName());
            Assertions.assertEquals(circle.getField(), retrivedShape.getField());
        }

        @Test
        void checkCircleInList() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle(3);

            //When
            shapeCollector.addFigure(circle);
            Shape retrivedShape = shapeCollector.getFigure(0);

            //Then
            Assertions.assertEquals(circle,retrivedShape);
        }

        @Test
        void removeCircle() {
            //Given
            Circle circle = new Circle(3);
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            boolean result = shapeCollector.removeFigure(circle);

            //Then
            Assertions.assertFalse(result);
        }

        @Test
        void removeNonExistingCircle() {
            //Given
            Circle circle = new Circle(3);
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            boolean result = shapeCollector.removeFigure(circle);

            //Then
            Assertions.assertFalse(result);
        }
    }

    @Nested
    @DisplayName("Tests for Rectangle")
    class TestRectangle {

        @Test
        void testCircleAndField() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Rectangle rectangle = new Rectangle(3, 4);

            //When
            shapeCollector.addFigure(rectangle);
            Shape retrivedShape = shapeCollector.getFigure(0);

            //Then
            Assertions.assertNotNull(retrivedShape);
            Assertions.assertEquals(rectangle.getShapeName(), retrivedShape.getShapeName());
            Assertions.assertEquals(rectangle.getField(), retrivedShape.getField());
        }



        @Test
        void checkRectangleInList() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Rectangle rectangle = new Rectangle(3, 4);

            //When
            shapeCollector.addFigure(rectangle);
            Shape retrivedShape = shapeCollector.getFigure(0);

            //Then
            Assertions.assertEquals(rectangle,retrivedShape);
        }

        @Test
        void removeRectangle() {
            //Given
            Rectangle rectangle = new Rectangle(3, 4);
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            boolean result = shapeCollector.removeFigure(rectangle);

            //Then
            Assertions.assertFalse(result);
        }

        @Test
        void removeNonExistingRectangle() {
            //Given
            Rectangle rectangle = new Rectangle(3, 4);
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            boolean result = shapeCollector.removeFigure(rectangle);

            //Then
            Assertions.assertFalse(result);
        }
    }

    @Nested
    @DisplayName("Tests for Triangle")
    class TestTriangle {

        @Test
        void testCircleAndField() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Triangle triangle = new Triangle(3, 4);

            //When
            shapeCollector.addFigure(triangle);
            Shape retrivedShape = shapeCollector.getFigure(0);

            //Then
            Assertions.assertNotNull(retrivedShape);
            Assertions.assertEquals(triangle.getShapeName(), retrivedShape.getShapeName());
            Assertions.assertEquals(triangle.getField(), retrivedShape.getField());
        }



        @Test
        void checkTriangleInList() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Triangle triangle = new Triangle(3, 4);

            //When
            shapeCollector.addFigure(triangle);
            Shape retrivedShape = shapeCollector.getFigure(0);

            //Then
            Assertions.assertEquals(triangle,retrivedShape);
        }

        @Test
        void removeTriangle() {
            //Given
            Triangle triangle = new Triangle(3, 4);
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            boolean result = shapeCollector.removeFigure(triangle);

            //Then
            Assertions.assertFalse(result);
        }

        @Test
        void removeNonExistingTriangle() {
            //Given
            Triangle triangle = new Triangle(3, 4);
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            boolean result = shapeCollector.removeFigure(triangle);

            //Then
            Assertions.assertFalse(result);
        }
    }
}
