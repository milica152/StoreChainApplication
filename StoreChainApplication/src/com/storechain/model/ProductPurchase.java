package com.storechain.model;

public class ProductPurchase {
    private double totalPrice;
    private Product product;
    private int amount;
    private String serialNumber = null;

    public ProductPurchase() {
    }

    public ProductPurchase(Product product, int amount) {
        this.totalPrice = product.getPrice() * amount;
        this.product = product;
        this.amount = amount;
    }

    // for medicine and parking tikets purchase
    public ProductPurchase(Product product, int amount, String serialNumber) {
        this.totalPrice = product.getPrice() * amount;
        this.product = product;
        this.amount = amount;
        this.serialNumber = serialNumber;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
