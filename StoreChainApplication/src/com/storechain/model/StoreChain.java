package com.storechain.model;

import java.util.ArrayList;

public class StoreChain {
    private static StoreChain instance = null;
    private ArrayList<Shop> shops = new ArrayList<>();

    private StoreChain() {
    }

    public static StoreChain getInstance() {
        if(instance == null){
            instance = new StoreChain();
        }
        return instance;
    }

    public ArrayList<Shop> getShops() {
        return shops;
    }

    public void setShops(ArrayList<Shop> shops) {
        this.shops = shops;
    }

    public void addShop(Shop shop){
        ArrayList<Shop> newShops = this.shops;
        newShops.add(shop);
        setShops(newShops);
    }
}
