/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// QuestionDAO.java
package comp603.assignment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {

    public static List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();

        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Questions")) {

            while (rs.next()) {
                Question q = new Question(
                    rs.getString("question"),
                    rs.getString("optionA"),
                    rs.getString("optionB"),
                    rs.getString("optionC"),
                    rs.getString("optionD"),
                    rs.getString("correctAnswer").charAt(0)
                );
                questions.add(q);
            }

        } catch (SQLException e) {
            System.err.println("❌ Error retrieving questions: " + e.getMessage());
        }

        return questions;
    }

    public static void insertSampleQuestion() {
        insertIfNotExists("What is the capital of New Zealand?", "Auckland", "Wellington", "Christchurch", "Dunedin", 'B');
        insertIfNotExists("What planet is known as the Red Planet?", "Earth", "Venus", "Mars", "Jupiter", 'C');
        insertIfNotExists("Who wrote 'Romeo and Juliet'?", "Charles Dickens", "William Shakespeare", "Jane Austen", "Mark Twain", 'B');
    }

    private static void insertIfNotExists(String question, String a, String b, String c, String d, char answer) {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "INSERT INTO Questions (question, optionA, optionB, optionC, optionD, correctAnswer) VALUES (?, ?, ?, ?, ?, ?)");) {

            ps.setString(1, question);
            ps.setString(2, a);
            ps.setString(3, b);
            ps.setString(4, c);
            ps.setString(5, d);
            ps.setString(6, String.valueOf(answer));

            ps.executeUpdate();
            System.out.println("✅ Inserted: " + question);

        } catch (SQLException e) {
            if (e.getSQLState().equals("23505")) {
                System.out.println("ℹ️ Already exists: " + question);
            } else {
                e.printStackTrace();
            }
        }
    }
}
