/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603.assignment;

/**
 *
 * @author ali
 */

import java.io.*;
import java.util.*;

public class QuestionStorage 
        
        //Note: Quiz Questions were generated via ChatGPT.
{

public static List<Question> loadquestions(String filename) 
{
        // creates empty array list to store questions
        List<Question> questionList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) 
        {
        String currentLine;
        // reading the file
        while ((currentLine = br.readLine()) != null) 
        {
              String[] parts = currentLine.split("\\|");
                if (parts.length == 6) 
                {
                    //extract the question text from file
                    String questionText = parts[0];
                    //extract answer options
                    String[] options = {parts[1], parts[2], parts[3], parts[4]};
                    // extract correct answer
                    int correctAnswer = Integer.parseInt(parts[5]);
                    questionList.add(new Question(questionText, options, correctAnswer, 1)); 
                }
            }
        // catch exception
        } catch (IOException e) 
        {
            System.out.println("Could not load Questions! " + e.getMessage());
        }

        return questionList;
    }
}
