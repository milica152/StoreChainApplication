package com.storechain.helper;

import java.util.Date;

public class Logger {
    // maybe to move this to bill class or somewhere else
    public void logProductPurchase(String storeType, String productType, String price, double amountBefore, double amountAfter, Date creationTime){
        StringBuilder sb = new StringBuilder();
        sb.append(storeType)
                .append(", ")
                .append(productType)
                .append(", ")
                .append(price)
                .append(", ")
                .append(amountBefore)
                .append(", ")
                .append(amountAfter)
                .append(", ")
                .append(creationTime);
        System.out.println(sb.toString());
    }
}
