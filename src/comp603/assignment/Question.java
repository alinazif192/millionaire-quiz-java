/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
<<<<<<< HEAD

package comp603.assignment;

 /**
 *
 * @author joel;
 */

/*
 * creates multiple choice option for the questions for the game.
 */

public class Question {
    private String questionText;
    private String optionA, optionB, optionC, optionD;
    private char correctAnswer;

    public Question(String questionText, String optionA, String optionB, String optionC, String optionD, char correctAnswer) {
        this.questionText = questionText;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
    }
    
    // All getters for the options.

    public String getQuestionText() {
        return questionText;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }
}
=======
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
>>>>>>> d01528b133eec3051a122fbb534110e3b77cff28
