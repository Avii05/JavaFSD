package com.tracker.connection;

import java.sql.*;

public class ConnectionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/company_db1";
    private static final String USER = "root";
    private static final String PASSWORD = "Root123$";

    public static Connection getConnection1() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
