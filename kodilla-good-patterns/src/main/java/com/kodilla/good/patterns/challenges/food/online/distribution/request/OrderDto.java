package com.kodilla.good.patterns.challenges.food.online.distribution.request;


import com.kodilla.good.patterns.challenges.food.online.distribution.user.User;

public class OrderDto {

    private User user;
    private boolean isOrdered;

    public OrderDto(final User user, final boolean isOrdered) {
        this.user = user;
        this.isOrdered = isOrdered;
    }

    public User getUser() { return user; }

    public boolean isOrdered() { return isOrdered; }
}
