package com.kodilla.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class SausageDecorator extends AbstractPizzaOrderDecorator{
    protected SausageDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(2));
    }

    @Override
    public String description() {
        return super.description() + " ,sausage";
    }
}
