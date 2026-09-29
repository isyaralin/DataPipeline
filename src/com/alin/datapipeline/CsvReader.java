package com.alin.datapipeline;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class CsvReader {
    public ArrayList<Transaction> readCsv(String filePath) {
        ArrayList<Transaction> transactions = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0]);
                int userId = Integer.parseInt(values[1]);
                double money = Double.parseDouble(values[2]);
                String country = values[3];
                LocalDateTime timestamp = LocalDateTime.parse(values[4]);

                Transaction singleTransaction =
                        new Transaction(id, userId, money, country, timestamp);

                transactions.add(singleTransaction);
            }

            int transactionCount = transactions.size();

            System.out.println(
                    "The CSV reader successfully created "
                            + transactionCount + " transactions."
            );

            br.close();
        }
        catch (Exception e) {
            System.out.println(
                    "An error occurred while reading csv file "
                            + e.getMessage()
            );
        }

        return transactions;
    }
}