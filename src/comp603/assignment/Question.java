/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603.assignment;

/**
 *
 * @author ali
 */
public class Question 
{
    private String questionText;
    private String[] options;
    private int correctAnswer;
    
    public Question(String questionText, String[] options, int correctAnswer, int difficultyLevel) 
    {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
    
    public String getQuestionText() { return questionText; }
    public String[] getOptions() { return options; }
    public int getCorrectAnswer() { return correctAnswer; }
    
    public boolean isCorrect(int answer) 
    {
        return answer == correctAnswer;
    }
}