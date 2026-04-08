package com.auction.model;

public abstract class Item {
    protected int itemId;
    protected String name;
    protected double startingPrice;

    public Item(int itemId, String name, double startingPrice) {
        this.itemId = itemId;
        this.name = name;
        this.startingPrice = startingPrice;
    }

    public double getStartingPrice() {
        return startingPrice;
    }
}