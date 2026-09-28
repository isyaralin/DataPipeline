package com.alin.datapipeline;

public class Main {
    public static void main(String[] args) {
        CsvReader csvReader = new CsvReader();

        if (args.length == 0) {
            System.out.println("not enough arguments tp process the input");
        }
        else{
            csvReader(args[0]);
        }


    }
}
