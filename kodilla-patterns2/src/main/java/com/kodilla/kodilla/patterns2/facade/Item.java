package com.kodilla.kodilla.patterns2.facade;

public class Item {

    private final Long itemId;
    private final double qty;

    public Item(Long itemId, double qty) {
        this.itemId = itemId;
        this.qty = qty;
    }

    public Long getItemId() {
        return itemId;
    }

    public double getQty() {
        return qty;
    }
}
