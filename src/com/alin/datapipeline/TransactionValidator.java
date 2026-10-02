package com.alin.datapipeline;

public class TransactionValidator {

    public boolean validateTransaction(Transaction transaction) {

        if (transaction.getId() <= 0) {
            return false;
        }

        if (transaction.getUserId() <= 0) {
            return false;
        }

        if (transaction.getAmount() <= 0) {
            return false;
        }

        if (transaction.getCountry() == null) {
            return false;
        }

        if (transaction.getTimestamp() == null) {
            return false;
        }

        return true;
    }
}

// To do:
// Given the transactions extracted from the csv file
// check whether the given structure of a single transaction is valid or not
// extract the valid ones and label the not valid ones
