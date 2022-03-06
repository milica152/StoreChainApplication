package com.storechain.model;

public class PurchaseRequest {
    private String productName;
    private ProductType productType;
    private int quantity;

    public PurchaseRequest() {
    }

    public PurchaseRequest(String productName, ProductType productType, int quantity) {
        this.productName = productName;
        this.productType = productType;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
