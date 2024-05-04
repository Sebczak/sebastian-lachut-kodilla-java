package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {

    private PizzaOrder pizzaOrder;

    @BeforeEach
    public void setUp() {
        pizzaOrder = new BasicPizzaOrder();
    }

    @Test
    void testBasicPizzaOrderGetPrice() {
        //Given

        //When
        BigDecimal price = pizzaOrder.getPrice();

        //Then
        assertEquals(new BigDecimal("15.00"), price);
    }

    @Test
    void testBasicPizzaOrderDescription() {
        //Given

        //When
        String description = pizzaOrder.description();

        //Then
        assertEquals("Classic dough, tomato sauce, cheese", description);
    }

    @Test
    public void testPizzaOrderAddChickenGetPrice() {
        //Given
        pizzaOrder = new ChickenDecorator(pizzaOrder);

        //When
        BigDecimal theCost = pizzaOrder.getPrice();

        //Then
        assertEquals(new BigDecimal("20.00"), theCost);
    }

    @Test
    void testBasicPizzaOrderAddChickenDescription() {
        //Given
        pizzaOrder = new ChickenDecorator(pizzaOrder);
        //When
        String description = pizzaOrder.description();

        //Then
        assertEquals("Classic dough, tomato sauce, cheese ,chicken", description);
    }

    @Test
    public void testPizzaOrderAddChickenAndSalamiGetPrice() {
        //Given
        pizzaOrder = new ChickenDecorator(pizzaOrder);
        pizzaOrder = new SalamiDecorator(pizzaOrder);

        //When
        BigDecimal theCost = pizzaOrder.getPrice();

        //Then
        assertEquals(new BigDecimal("22.00"), theCost);
    }

    @Test
    void testBasicPizzaOrderAddChickenAndSalamiDescription() {
        //Given
        pizzaOrder = new ChickenDecorator(pizzaOrder);
        pizzaOrder = new SalamiDecorator(pizzaOrder);
        //When
        String description = pizzaOrder.description();

        //Then
        assertEquals("Classic dough, tomato sauce, cheese ,chicken ,salami", description);
    }

    @Test
    public void testPizzaOrderAddChickenSalamiAndSausageGetPrice() {
        //Given
        pizzaOrder = new ChickenDecorator(pizzaOrder);
        pizzaOrder = new SalamiDecorator(pizzaOrder);
        pizzaOrder = new SausageDecorator(pizzaOrder);

        //When
        BigDecimal theCost = pizzaOrder.getPrice();

        //Then
        assertEquals(new BigDecimal("24.00"), theCost);
    }

    @Test
    void testBasicPizzaOrderAddChickenSalamiAndSausageDescription() {
        //Given
        pizzaOrder = new ChickenDecorator(pizzaOrder);
        pizzaOrder = new SalamiDecorator(pizzaOrder);
        pizzaOrder = new SausageDecorator(pizzaOrder);
        //When
        String description = pizzaOrder.description();

        //Then
        assertEquals("Classic dough, tomato sauce, cheese ,chicken ,salami ,sausage", description);
    }
}
