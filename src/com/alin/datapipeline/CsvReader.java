package com.alin.datapipeline;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CsvReader {
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new FileReader("sample.csv"));

            String line;

            while ((line = br.readLine()) != null){
                String[] values =  line.split(",");
                int id = Integer.parseInt(values[0] );
                int userId = Integer.parseInt(values[1] );
                double money = Double.parseDouble(values[2]);
                String country = values[3];
                LocalDateTime timestamp = LocalDateTime.parse(values[4]);
            }
            br.close();
        }
        catch (Exception e){
            System.out.println("An error occured while reading csv file " + e.getMessage());
        }
    }
}
