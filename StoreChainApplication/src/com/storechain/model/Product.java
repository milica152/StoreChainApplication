package com.storechain.model;

public class Product {
    private ProductType type;
    private String name;
    private double price;
    private int quantity;

    public Product() {
    }

    public Product(ProductType type, String name, double price, int quantity) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
