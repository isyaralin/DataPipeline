package com.alin.datapipeline;

import java.util.ArrayList;

public class TransactionTransformer {

    public double calculateTotal(ArrayList<Transaction> transactions) {
        double total = 0;
        for (Transaction transaction : transactions){
            total += transaction.getAmount();
        }
        return total;
    }
}
