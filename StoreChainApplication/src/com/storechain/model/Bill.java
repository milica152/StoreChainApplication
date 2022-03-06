package com.storechain.model;

import java.util.ArrayList;
import java.util.Date;

public class Bill {
    private String billNumber;
    private Date creationTime;
    private Customer customer;
    private ArrayList<ProductPurchase> productPurchases = new ArrayList<>();

    public Bill() {
    }

    public Bill(String billNumber, Date creationTime, Customer customer, ArrayList<ProductPurchase> productPurchases) {
        this.billNumber = billNumber;
        this.creationTime = creationTime;
        this.customer = customer;
        this.productPurchases = productPurchases;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<ProductPurchase> getProductPurchases() {
        return productPurchases;
    }

    public void setProductPurchases(ArrayList<ProductPurchase> productPurchases) {
        this.productPurchases = productPurchases;
    }

    public void addProductPurchase(ProductPurchase productPurchase){
        ArrayList<ProductPurchase> newPurchases = this.productPurchases;
        newPurchases.add(productPurchase);
        setProductPurchases(newPurchases);
    }
}
