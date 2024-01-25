package com.kodilla.stream.invoice.simple;

public class SimpleItem {

    private final SimpleProduct simpleProduct;
    private final double quantity;

    public SimpleItem(SimpleProduct simpleProduct, double quantity) {
        this.simpleProduct = simpleProduct;
        this.quantity = quantity;
    }

    public double getValue() {
        return simpleProduct.getProductPrice() * quantity;
    }

    public SimpleProduct getSimpleProduct() {
        return simpleProduct;
    }

    public double getQuantity() {
        return quantity;
    }


}
