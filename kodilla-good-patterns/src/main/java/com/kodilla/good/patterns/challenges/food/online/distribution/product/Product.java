package com.kodilla.good.patterns.challenges.food.online.distribution.product;

public class Product {

    private String name;
    private Integer priceTag;
    private String description;

    public Product(String name, Integer priceTag, String description) {
        this.name = name;
        this.priceTag = priceTag;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public Integer getPriceTag() {
        return priceTag;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", priceTag=" + priceTag +
                ", description='" + description + '\'' +
                '}';
    }
}
