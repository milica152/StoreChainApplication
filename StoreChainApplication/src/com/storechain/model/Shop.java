package com.storechain.model;

import com.storechain.exceptions.ProductNotExistsException;
import com.storechain.exceptions.ProductNotPermittedException;
import com.storechain.exceptions.ProductQuantityExceededException;

import java.util.ArrayList;

public abstract class Shop {
    private int nextBillId = 1;
    private String name;
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Bill> bills = new ArrayList<>();

    public void sell(ArrayList<PurchaseRequest> purchaseRequests) {
        for(PurchaseRequest purchaseRequest : purchaseRequests){
            try {
                hasEnoughtProducts(purchaseRequest.getProductName(), purchaseRequest.getProductType(), purchaseRequest.getQuantity());
            } catch (ProductQuantityExceededException e) {
                e.printStackTrace();
            } catch (ProductNotExistsException e) {
                e.printStackTrace();
            }
        }
        createBill(purchaseRequests);
    }

    public abstract void addProduct(Product product) throws ProductNotPermittedException;

    public void createBill(ArrayList<PurchaseRequest> purchaseRequests) {
        Bill bill = new Bill();
        for(PurchaseRequest purchaseRequest : purchaseRequests){
            for (Product product : products){
                if(product.getName().equals(purchaseRequest.getProductName()) && product.getType().equals(purchaseRequest.getProductType())){
                    bill.addProductPurchase(new ProductPurchase(product, purchaseRequest.getQuantity()));
                }
            }
        }
    }

    public boolean hasEnoughtProducts(String productName, ProductType productType, int amount) throws ProductNotExistsException, ProductQuantityExceededException {
        boolean exists = false;

        for(Product product : products){
            if(product.getName().equals(productName) && product.getType().equals(productType)){
                exists = true;
                if(product.getQuantity() < amount){
                    throw new ProductQuantityExceededException(productName, this.getName());
                }
            }
        }
        if(!exists){
            throw new ProductNotExistsException(productName, this);
        }
        return true;
    }

    public Shop(String name) {
        this.name = name;
    }

    public Shop() {
    }

    public int getNextBillId() {
        return nextBillId;
    }

    public void setNextBillId(int nextBillId) {
        this.nextBillId = nextBillId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Bill> getBills() {
        return bills;
    }

    public void setBills(ArrayList<Bill> bills) {
        this.bills = bills;
    }
}
