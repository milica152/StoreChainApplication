package com.storechain.exceptions;

public class ProductQuantityExceededException extends Exception{
    public ProductQuantityExceededException(String productName, String shopName) {
        super("There is not enough " + productName + " products in " + shopName + ".");
    }

}
