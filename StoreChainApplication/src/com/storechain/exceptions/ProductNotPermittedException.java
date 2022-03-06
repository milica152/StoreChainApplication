package com.storechain.exceptions;

import com.storechain.model.Shop;

public class ProductNotPermittedException extends Exception{
    public ProductNotPermittedException(String productName, Shop shop) {
        super("Product " + productName + " cannot be sold in " + shop.getClass() + ".");
    }
}
