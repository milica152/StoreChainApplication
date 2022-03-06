package com.storechain;

import com.storechain.exceptions.ProductNotPermittedException;
import com.storechain.model.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        StoreChain storeChain = StoreChain.getInstance();
        Product cigarette1 = new Product(ProductType.CIGARETTES, "PalMal Cigarette", 350.00, 4);
        Product cigarette2 = new Product(ProductType.CIGARETTES, "Camel Cigarette", 450.00, 1);
        Product drink1 = new Product(ProductType.DRINK, "Coca Cola", 135.00, 4);
        Product drink2 = new Product(ProductType.DRINK, "Lemonade", 120.00, 1);
        Product food1 = new Product(ProductType.FOOD, "Sandwich", 500.00, 3);
        Product food2= new Product(ProductType.FOOD, "Chips", 100.00, 2);
        Product medicine = new Product(ProductType.MEDICINE, "Ibuprophen", 600.00, 10);
        Product toys1 = new Product(ProductType.TOYS, "Barbie", 1200.00, 2);
        Product toys2 = new Product(ProductType.TOYS, "Batman", 1400.00, 4);
        Product parkingTicket = new Product(ProductType.PARKING_TICKETS, "Parking ticket", 500.00, 2);

        Shop cornerShop = new CornerShop("Corner Shop");
        Shop pharmacy = new Pharmacy("Benu Pharmacy");
        Shop supermarket = new Supermarket("Maxi Supermarket");

        try {
            cornerShop.addProduct(cigarette1);
            cornerShop.addProduct(cigarette2);
            cornerShop.addProduct(toys1);
            pharmacy.addProduct(toys2);
            pharmacy.addProduct(food2);
            pharmacy.addProduct(medicine);
            supermarket.addProduct(parkingTicket);
            supermarket.addProduct(drink2);
            supermarket.addProduct(drink1);
            supermarket.addProduct(food1);
        } catch (ProductNotPermittedException e) {
            e.printStackTrace();
        }

        storeChain.addShop(pharmacy);
        storeChain.addShop(supermarket);
        storeChain.addShop(cornerShop);

        // orders
        PurchaseRequest purchaseRequest1 = new PurchaseRequest(toys2.getName(), toys2.getType(), 1);
        PurchaseRequest purchaseRequest2 = new PurchaseRequest(food2.getName(), food2.getType(), 1);
        PurchaseRequest purchaseRequest3 = new PurchaseRequest(medicine.getName(), medicine.getType(), 2);
        PurchaseRequest purchaseRequest4 = new PurchaseRequest(medicine.getName(), medicine.getType(), 1);
        PurchaseRequest purchaseRequest5 = new PurchaseRequest(food1.getName(), food1.getType(), 3);
        PurchaseRequest purchaseRequest6 = new PurchaseRequest(drink1.getName(), drink1.getType(), 1);
        PurchaseRequest purchaseRequest8 = new PurchaseRequest(drink2.getName(), drink2.getType(), 1);
        PurchaseRequest purchaseRequest9 = new PurchaseRequest(parkingTicket.getName(), parkingTicket.getType(), 1);
        PurchaseRequest purchaseRequest10 = new PurchaseRequest(toys1.getName(), toys1.getType(), 2);
        PurchaseRequest purchaseRequest11 = new PurchaseRequest(cigarette2.getName(), cigarette2.getType(), 2);  //should throw exception
        PurchaseRequest purchaseRequest12 = new PurchaseRequest(cigarette1.getName(), cigarette1.getType(), 2);

        ArrayList<PurchaseRequest> pharmacyBill1 = new ArrayList<PurchaseRequest>(){
            {
                add(purchaseRequest1);
                add(purchaseRequest2);
                add(purchaseRequest3);
            }
        };

        ArrayList<PurchaseRequest> pharmacyBill2 = new ArrayList<PurchaseRequest>(){
            {
                add(purchaseRequest4);
            }
        };

        ArrayList<PurchaseRequest> supermarketBill1 = new ArrayList<PurchaseRequest>(){
            {
                add(purchaseRequest5);
                add(purchaseRequest6);
            }
        };


        ArrayList<PurchaseRequest> supermarketBill2 = new ArrayList<PurchaseRequest>(){
            {
                add(purchaseRequest8);
                add(purchaseRequest9);
            }
        };

        ArrayList<PurchaseRequest> cornerShopBill1 = new ArrayList<PurchaseRequest>(){
            {
                add(purchaseRequest10);
            }
        };

        ArrayList<PurchaseRequest> cornerShopBill2 = new ArrayList<PurchaseRequest>(){
            {
                add(purchaseRequest11);
                add(purchaseRequest12);
            }
        };

        pharmacy.sell(pharmacyBill1);
        pharmacy.sell(pharmacyBill2);
        supermarket.sell(supermarketBill1);
        supermarket.sell(supermarketBill2);
        cornerShop.sell(cornerShopBill1);
        cornerShop.sell(cornerShopBill2);

    }
}
