package com.alin.datapipeline;

import java.time.LocalDateTime;

public class Transaction {
    private int id;
    private int userId;
    private double amount;
    private String country;
    private LocalDateTime timestamp;

    public Transaction(int id, int userId, double amount, String country, LocalDateTime timestamp) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.country = country;
        this.timestamp = timestamp;
    }
}
