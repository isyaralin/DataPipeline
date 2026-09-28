package com.alin.datapipeline;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        CsvReader csvReader = new CsvReader();
        // when the csvReader reads the file
        // It also outputs a list of transactions
        // So you need to define them inside the main as received
        ArrayList<Transaction> transactions;

        if (args.length == 0) {
            System.out.println("There is not enough argument to parse.");
        }
        else {
            String filePath = args[0];
            transactions = csvReader.readCsv(filePath);

            System.out.println("Transactions read: " + transactions.size());
        }
    }
}