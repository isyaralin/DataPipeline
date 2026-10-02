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

    public ValidationError getValidationError(Transaction transaction){

        if (transaction.getId() <= 0) {
            return ValidationError.INVALID_ID;
        }
        if (transaction.getUserId() <= 0) {
            return ValidationError.INVALID_ID;
        }
        if (transaction.getAmount() <= 0){
            return ValidationError.INVALID_AMOUNT;
        }
        if (transaction.getCountry() == null) {
            return ValidationError.INVALID_COUNTRY;
        }
        if (transaction.getTimestamp() == null) {
            return ValidationError.INVALID_TIMESTAMP;
        }
        return null;
    }
}

// To do:
// Given the transactions extracted from the csv file
// check whether the given structure of a single transaction is valid or not
// extract the valid ones and label the not valid ones
