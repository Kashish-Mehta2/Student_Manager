package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDao {

    // Method to insert student into the database
    public static boolean insertStudenttoDB(Student st, Student student) throws ClassNotFoundException {
        boolean isSuccess = false;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            // Create a connection to the database
            con = ConnectionGenerator.createConnection();

            // Prepare the SQL query for inserting a student
            String query = "INSERT INTO students (name, city) VALUES (?, ?)";

            // Create PreparedStatement
            pstmt = con.prepareStatement(query);

            // Check if the student object is not null
            if (st != null) {
                // Set the values of the parameters from the student object
                pstmt.setString(1, student.getStudentName());  // Setting student name
                pstmt.setString(2, student.getStudentCity());
                // Execute the query to insert the student
                int rowsAffected = pstmt.executeUpdate();

                // If rows were affected, return true (insert successful)
                if (rowsAffected > 0) {
                    isSuccess = true;
                }
            } else {
                System.out.println("Student object is null. Cannot insert data.");
            }

        } catch (Exception e) {
            // Print the SQL exception stack trace for debugging
            System.out.println("Error while inserting student: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Always close resources in the finally block
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isSuccess; // Return true if insertion was successful, false otherwise
    }

    // Method to delete a student from the database
    public static boolean deleteStudentFromDB(int studentId) throws ClassNotFoundException {
        boolean isSuccess = false;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            // Create a connection to the database
            con = ConnectionGenerator.createConnection();

            // Prepare the SQL query for deleting a student by studentId
            String query = "DELETE FROM students WHERE id = ?";

            // Create PreparedStatement
            pstmt = con.prepareStatement(query);

            // Set the studentId parameter
            pstmt.setInt(1, studentId);

            // Execute the query to delete the student
            int rowsAffected = pstmt.executeUpdate();

            // If rows were affected, return true (deletion successful)
            if (rowsAffected > 0) {
                isSuccess = true;
            }

        } catch (SQLException e) {
            // Print the SQL exception stack trace for debugging
            System.out.println("Error while deleting student: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Always close resources in the finally block
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isSuccess; // Return true if deletion was successful, false otherwise
    }

    // Method to retrieve a student by their ID
    public static Student getStudentById(int studentId) throws ClassNotFoundException {
        Student st = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        java.sql.ResultSet rs = null;

        try {
            // Create a connection to the database
            con = ConnectionGenerator.createConnection();

            // Prepare the SQL query for selecting a student by studentId
            String query = "SELECT * FROM students WHERE id = ?";

            // Create PreparedStatement
            pstmt = con.prepareStatement(query);

            // Set the studentId parameter
            pstmt.setInt(1, studentId);

            // Execute the query to get the student details
            rs = pstmt.executeQuery();

            // If the student exists, create a Student object and populate it with the data
            if (rs.next()) {
                String name = rs.getString("name");
                String city = rs.getString("city");
                st = new Student(studentId, name, city); // Create student object
            }

        } catch (SQLException e) {
            // Print the SQL exception stack trace for debugging
            System.out.println("Error while retrieving student: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Always close resources in the finally block
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return st; // Return the student object, or null if not found
    }
}
