package com.alin.datapipeline;

import java.time.LocalDateTime;

public class Transaction {
    private int id;
    private int userId;
    private double amount;
    private String country;
    private LocalDateTime timestamp;

    // Since the constructor defines everything private
    // When we try to call Transaction transaction in an TransactionValidator or any class that calls and uses transaction instance
    // We will not have access to the instances and it will give errors.
    // So we need to define some public classes that other classes can access and use the instances of the private constructors
    // Thats why we added these return types, when the method getId() is called in any other class,
    // It will have the access to the Id of the transaction, (same for other methods)
    public int getId(){
        return id;
    }

    public int getUserId(){
        return userId;
    }

    public double getAmount(){
        return amount;
    }

    public String getCountry(){
        return country;
    }

    public LocalDateTime getTimestamp(){
        return timestamp;
    }

    public Transaction(int id, int userId, double amount, String country, LocalDateTime timestamp) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.country = country;
        this.timestamp = timestamp;
    }
}
