/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603.assignment;

import java.sql.*;
import java.util.*;

/**
 *
 * @author joel
 */

/*
 * Handles database operations related to questions,
 */

public class QuestionDAO {

    public static List<Question> getAllQuestions() {
        List<Question> questions = new java.util.ArrayList<>();

        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Questions")) {
            
            // loops through each record and generates the object for quesiton
            while (rs.next()) {
                Question q = new Question(
                    rs.getString("question"),
                    rs.getString("optionA"),
                    rs.getString("optionB"),
                    rs.getString("optionC"),
                    rs.getString("optionD"),
                    rs.getString("correctAnswer").charAt(0) // converts answer of question to a char A-D
                );
                questions.add(q);
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving questions: " + e.getMessage());
        }

        return questions;
    }

    // reads from text file 
    public static void insertSampleQuestion() {
        List<Question> questions = QuestionLoader.loadFromFile("questions.txt");

        for (Question q : questions) {
            insertIfNotExists(
                q.getQuestionText(),
                q.getOptionA(),
                q.getOptionB(),
                q.getOptionC(),
                q.getOptionD(),
                q.getCorrectAnswer()
            );
        }
    }
    // only inserts if quesiton already not there, checks if it already exists.
    private static void insertIfNotExists(String question, String a, String b, String c, String d, char answer) {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(
                 "SELECT COUNT(*) FROM Questions WHERE question = ?")) {

            checkStmt.setString(1, question);
            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            if (count == 0) {
                try (PreparedStatement insertStmt = conn.prepareStatement(
                     "INSERT INTO Questions (question, optionA, optionB, optionC, optionD, correctAnswer) VALUES (?, ?, ?, ?, ?, ?)")) {
                    insertStmt.setString(1, question);
                    insertStmt.setString(2, a);
                    insertStmt.setString(3, b);
                    insertStmt.setString(4, c);
                    insertStmt.setString(5, d);
                    insertStmt.setString(6, String.valueOf(answer));
                    insertStmt.executeUpdate();
                    System.out.println("Inserted: " + question);
                }
            } else {
                System.out.println("Already exists: " + question);
            }

        } catch (SQLException e) {
            System.err.println("Error inserting question: " + e.getMessage());
        }
    }
}
