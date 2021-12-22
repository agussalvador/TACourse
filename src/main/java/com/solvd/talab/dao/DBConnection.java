package com.solvd.talab.dao;

import com.solvd.talab.lecture10.ConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;

public class DBConnection {
    private static Connection connection;


    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/tacourse","root","root");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
