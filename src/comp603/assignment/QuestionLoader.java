/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603.assignment;

import java.io.*;
import java.util.*;

/**
 *
 * @author joel
 */

/*
 * QuestionLoader is responsible for reading questions from a text file.
 */

public class QuestionLoader {

    public static List<Question> loadFromFile(String filename) {
        List<Question> questions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            // read each line from questions.txt file
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                // only process lines with 6 parts to ensure all questions function correctly.
                if (parts.length == 6) {
                    String question = parts[0];
                    String a = parts[1];
                    String b = parts[2];
                    String c = parts[3];
                    String d = parts[4];
                    char correct = (char) ('A' + Integer.parseInt(parts[5]) - 1);
                    questions.add(new Question(question, a, b, c, d, correct)); // question object
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Failed to load the questions: " + e.getMessage());
        }

        return questions;
    }
}
