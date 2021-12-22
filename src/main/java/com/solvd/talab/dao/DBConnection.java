package com.solvd.talab.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;


    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/tacourse", "root", "root");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
