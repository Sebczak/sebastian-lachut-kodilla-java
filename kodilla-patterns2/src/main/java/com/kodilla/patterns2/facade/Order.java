package com.kodilla.patterns2.facade;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

public class Order {

    private Long orderId;
    private Long userId;
    private boolean isPaid;
    private boolean isVerified;
    private boolean isSubmitted;
    private final List<Item> items = new ArrayList<>();
    private ItemService itemService;

    public Order(Long orderId, Long userId, ItemService itemService) {
        this.orderId = orderId;
        this.userId = userId;
        this.itemService = itemService;
    }

    public BigDecimal calculateValue() {
        return items.stream()
                .map(item -> itemService.getPrice(item.getItemId()).multiply(BigDecimal.valueOf(item.getQty())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    public List<Item> getItems() {
        return items;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public boolean isSubmitted() {
        return isSubmitted;
    }

    public void setSubmitted(boolean submitted) {
        isSubmitted = submitted;
    }
}
