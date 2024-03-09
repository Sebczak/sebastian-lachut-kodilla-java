package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class BigMac {

    private BunType bun;
    private int burgers;
    private SauceType sauce;
    private List<IngredientType> ingredients = new ArrayList<>();

    public static class BigMacBuilder {

        private BunType bun;
        private int burgers;
        private SauceType sauce;
        private List<IngredientType> ingredients = new ArrayList<>();

        public BigMacBuilder bun(BunType bun) {
            this.bun = bun;
            return this;
        }

        public BigMacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigMacBuilder sauce(SauceType sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigMacBuilder ingredient(IngredientType ingredient) {
            ingredients.add(ingredient);
            return this;
        }

        public BigMac build() {
            return new BigMac(bun, burgers, sauce, ingredients);
        }

    }

    private BigMac(BunType bun, int burgers, SauceType sauce, List<IngredientType> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public BunType getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public SauceType getSauce() {
        return sauce;
    }

    public List<IngredientType> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "BigMac{" +
                "bun=" + bun +
                ", burgers=" + burgers +
                ", sauce=" + sauce +
                ", ingredients=" + ingredients +
                '}';
    }
}
