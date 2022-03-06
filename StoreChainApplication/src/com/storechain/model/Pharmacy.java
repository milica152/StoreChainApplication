package com.storechain.model;

import com.storechain.exceptions.ProductNotPermittedException;

import java.util.ArrayList;

public class Pharmacy extends Shop{
    public Pharmacy(String name) {
        super(name);
    }


    public Pharmacy() {
    }

    @Override
    public void sell(ArrayList<PurchaseRequest> purchaseRequests) {

    }

    @Override
    public void addProduct(Product product) throws ProductNotPermittedException {
        if(product.getType() == ProductType.CIGARETTES){
            throw new ProductNotPermittedException(product.getType().toString(), this);
        }
        ArrayList<Product> newProducts = this.getProducts();
        newProducts.add(product);
        setProducts(newProducts);
    }
}
