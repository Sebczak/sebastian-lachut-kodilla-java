package com.kodilla.good.patterns.challenges;

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
