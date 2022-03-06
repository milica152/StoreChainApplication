package com.storechain.model;

import com.storechain.exceptions.ProductNotExistsException;
import com.storechain.exceptions.ProductNotPermittedException;
import com.storechain.exceptions.ProductQuantityExceededException;

import java.util.ArrayList;

public class Supermarket extends Shop{
    public Supermarket(String name) {
        super(name);
    }

    public Supermarket() {
    }

    @Override
    public void addProduct(Product product) throws ProductNotPermittedException {
        if(product.getType() == ProductType.CIGARETTES || product.getType() == ProductType.MEDICINE){
            throw new ProductNotPermittedException(product.getType().toString(), this);
        }
        ArrayList<Product> newProducts = this.getProducts();
        newProducts.add(product);
        setProducts(newProducts);
    }
}
