package com.alin.datapipeline;

import java.util.ArrayList;
import java.util.HashMap;

public class TransactionTransformer {

    public double calculateTotal(ArrayList<Transaction> transactions) {
        double total = 0;
        for (Transaction transaction : transactions){
            total += transaction.getAmount();
        }
        return total;
    }

    public double averageTransaction(ArrayList<Transaction> transactions){

        if (transactions.isEmpty()){
            return 0;
        }

        double total = calculateTotal(transactions);
        int size = transactions.size();
        return total / size;
    }

    public HashMap<String, Integer> countByCountry(ArrayList<Transaction> transactions){
        HashMap<String, Integer> countryByCount = new HashMap<>();

        for (Transaction transaction : transactions){
            String country = transaction.getCountry();
            if (countryByCount.containsKey(country)){
                countryByCount.put(country, countryByCount.get(country) + 1);
            }
            else{
                countryByCount.put(country, 1);
            }
        }
        return countryByCount;
    }
}

