package com.alin.datapipeline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        CsvReader csvReader = new CsvReader();
        // when the csvReader reads the file
        // It also outputs a list of transactions
        // So you need to define them inside the main as received
        ArrayList<Transaction> transactions;
        // Create a new instance of the validator to check the valid transactions
        TransactionValidator validator = new TransactionValidator();
        // Create a new ArrayList to store the valid transactions
        ArrayList<Transaction> validTransactions = new ArrayList<>();

        // Add to handle the transactions
        TransactionTransformer transformer = new TransactionTransformer();

        HashMap<String, Integer> countryAndCount = transformer.countByCountry(validTransactions);

        if (args.length == 0) {
            System.out.println("There is not enough argument to parse.");
        }
        else {
            String filePath = args[0];
            transactions = csvReader.readCsv(filePath);

            // For each transaction in the list of transaction
            // Check if a single transaction is valid
            // Only keep the transactions that are valid
            for (Transaction transaction : transactions){
                if (validator.validateTransaction(transaction)){
                    validTransactions.add(transaction);
                }
            }

            double totalAmount = transformer.calculateTotal(validTransactions);
            double average = transformer.averageTransaction(validTransactions);

            Set<String> countries = countryAndCount.keySet();

            for (String country : countries){
                int count = countryAndCount.get(country);
                System.out.println("Country of Transaction: " + country + " Count of transactions: " + count);
            }

            System.out.println("Total amount of transactions: " + totalAmount);
            System.out.println("Average amount of transactions: " + average);

            System.out.println("Total transactions read: " + transactions.size());
            System.out.println("Total transactions valid: " + validTransactions.size());
        }
    }
}