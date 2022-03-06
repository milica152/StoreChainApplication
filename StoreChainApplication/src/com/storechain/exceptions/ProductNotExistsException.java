package com.storechain.exceptions;

import com.storechain.model.Shop;

public class ProductNotExistsException extends Exception{
    public ProductNotExistsException(String productName, Shop shop) {
        super("Product " + productName + " doesn't exist in " + shop.getClass()  + " " + shop.getName() + ".");
    }

}
