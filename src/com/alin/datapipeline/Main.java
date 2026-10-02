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

            // create a key value pair for valid transactions
            // this is for to handle the county transaction count
            HashMap<String, Integer> countryAndCount = transformer.countByCountry(validTransactions);

            double totalAmount = transformer.calculateTotal(validTransactions);
            double average = transformer.averageTransaction(validTransactions);

            Set<String> countries = countryAndCount.keySet();

            for (String country : countries){
                int count = countryAndCount.get(country);
                System.out.println("Country of Transaction: " + country + " Count of transactions: " + count);
            }

            // Check the reason of the invalid transactions
            // Keep the record to report the amounts per type of error
            int idErrorCount = 0;
            int userIdErrorCount = 0;
            int amountErrorCount = 0;
            int countryErrorCount = 0;
            int timestampErrorCount = 0;

            for (Transaction transaction : transactions){
                ValidationError error = validator.getValidationError(transaction);
                if (error == ValidationError.INVALID_ID){
                    idErrorCount++;
                }
                else if (error == ValidationError.INVALID_USER_ID){
                    userIdErrorCount++;
                }
                else if (error == ValidationError.INVALID_AMOUNT){
                    amountErrorCount++;
                }
                else if (error == ValidationError.INVALID_COUNTRY){
                    countryErrorCount++;
                }
                else if (error == ValidationError.INVALID_TIMESTAMP){
                    timestampErrorCount++;
                }
            }

            // Report: total, valid, invalid
            int invalidTransactions = transactions.size() - validTransactions.size();
            System.out.println("Total transactions read: " + transactions.size());
            System.out.println("Total transactions valid: " + validTransactions.size());
            System.out.println("Total transactions invalid: " + invalidTransactions);

            // Report the reason and its count of the error (why invalid)
            System.out.println("Total transactions with invalid id: " + idErrorCount);
            System.out.println("Total transactions with invalid user id: " + userIdErrorCount);
            System.out.println("Total transactions with invalid amount: " + amountErrorCount);
            System.out.println("Total transactions with invalid country: " + countryErrorCount);
            System.out.println("Total transactions with invalid timestamp: " + timestampErrorCount);


            System.out.println("Total amount of transactions: " + totalAmount);
            System.out.println("Average amount of transactions: " + average);


        }
    }
}