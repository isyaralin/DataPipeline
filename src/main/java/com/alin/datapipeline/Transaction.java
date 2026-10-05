package com.alin.datapipeline;

import java.time.LocalDateTime;

public class Transaction {
    private int id;
    private int userId;
    private double amount;
    private String country;
    private LocalDateTime timestamp;

    /*
     * The fields of this class are private, which means other classes
     * cannot access them directly.
     *
     * For example, TransactionValidator cannot directly access:
     * transaction.amount
     *
     * To allow other classes to read these private fields, we define
     * public getter methods.
     *
     * When getId() is called from another class, it returns the id
     * of the Transaction object. The same applies to the other getters.
     */
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
