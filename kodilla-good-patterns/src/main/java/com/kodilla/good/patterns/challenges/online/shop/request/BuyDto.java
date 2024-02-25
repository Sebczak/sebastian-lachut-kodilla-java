package com.kodilla.good.patterns.challenges.online.shop.request;


import com.kodilla.good.patterns.challenges.online.shop.user.User;

public class BuyDto {

    private User user;
    private boolean isBought;

    public BuyDto(final User user, final boolean isBought) {
        this.user = user;
        this.isBought = isBought;
    }

    public User getUser() { return user; }

    public boolean isBought() { return isBought; }
}
