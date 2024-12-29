package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionGenerator {

    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/Student_Manager";

    // Method to establish connection to the database
    public static Connection createConnection() throws SQLException, ClassNotFoundException {
        try {
            // Load the MySQL JDBC driver explicitly (although it's not strictly necessary in modern versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create and return the connection
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection established successfully.");
            return con;
        } catch (SQLException e) {
            System.err.println("Failed to establish connection: " + e.getMessage());
            throw e;  // Rethrow the exception after logging the error message
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL Driver not found: " + e.getMessage());
            throw e;  // Rethrow the exception if the driver is not found
        }
    }

    // Method to close the connection safely
    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
                System.out.println("Connection closed successfully.");
            } catch (SQLException e) {
                System.err.println("Failed to close the connection: " + e.getMessage());
            }
        }
    }
}
