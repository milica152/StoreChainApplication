package com.storechain.model;

import com.storechain.exceptions.ProductNotPermittedException;

import java.util.ArrayList;

public class CornerShop extends Shop{
    @Override
    public void sell(ArrayList<PurchaseRequest> purchaseRequests) {

    }

    @Override
    public void addProduct(Product product) throws ProductNotPermittedException {  // not permit to add medicine
        if(product.getType() == ProductType.MEDICINE){
            throw new ProductNotPermittedException(product.getType().toString(), this);
        }
        ArrayList<Product> newProducts = this.getProducts();
        newProducts.add(product);
        setProducts(newProducts);
    }

    public CornerShop(String name) {
        super(name);
    }

    public CornerShop() {
        super();
    }
}
