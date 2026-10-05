package com.alin.datapipeline;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionRepository {
    public void save(Transaction transaction) {
        try{
            Connection connection = DatabaseConnection.getConnection();
            String sql = """
                    INSERT INTO transactions
                    (id, user_id, amount, country, timestamp
                    VALUES (?, ?, ?, ?, ?)
                    """;

            /*
            The PreparedStatement lets you
            1) Prepare the SQL
            2) Put Java values into the placeholders
            3) Execute the SQL against PostgreSQL */
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        }
        catch (SQLException e){
            System.out.println("Database connection error: " + e.getMessage());
        }
    }
}
