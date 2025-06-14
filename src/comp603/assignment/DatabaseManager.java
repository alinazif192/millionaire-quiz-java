/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package comp603.assignment;

import java.sql.*;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:derby:MillionaireDB;create=true";

    // Returns a connection to the database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public static void clearQuestions() {
    try (Connection conn = getConnection();
         Statement stmt = conn.createStatement()) {
        stmt.executeUpdate("DELETE FROM Questions");
        System.out.println("🧹 Cleared all questions from database.");
    } catch (SQLException e) {
        System.err.println("❌ Failed to clear questions: " + e.getMessage());
    }
}

    // Initializes the database (creates table if it doesn't exist)
    public static void initializeDatabase() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            String createTableSQL = "CREATE TABLE Questions (" +
                    "id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, " +
                    "question VARCHAR(255), " +
                    "optionA VARCHAR(100), " +
                    "optionB VARCHAR(100), " +
                    "optionC VARCHAR(100), " +
                    "optionD VARCHAR(100), " +
                    "correctAnswer CHAR(1))";

            stmt.executeUpdate(createTableSQL);
            System.out.println("✅ Table created successfully.");

        } catch (SQLException e) {
            if (e.getSQLState().equals("X0Y32")) {
                System.out.println("ℹ️ Table already exists.");
            } else {
                System.err.println("❌ Database init error: " + e.getMessage());
            }
        }
    }
}
