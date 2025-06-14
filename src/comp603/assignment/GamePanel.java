/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package comp603.assignment;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

/**
 * @author alina, joel
 * This class is the main gameplay screen where the questions are displayed.
 * The player answers the questions displayed from this class to win money.
 * Includes lifelines: 50:50, Phone a Friend, and Ask the Audience.
 */
public class GamePanel extends JPanel {

    private MillionaireGUI gui;
    private JLabel questionLabel;
    private JButton[] answerButtons;
    private JButton endGameButton;
    private JButton lifeline5050Button;
    private JButton phoneFriendButton;
    private JButton askAudienceButton;

    private boolean lifelineUsed = false;
    private boolean phoneUsed = false;
    private boolean audienceUsed = false;

    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int prize = 0;

    public GamePanel(MillionaireGUI gui) {
        this.gui = gui;
        setupPanel();
    }

    private void setupPanel() {
        setLayout(new BorderLayout());

        questionLabel = new JLabel("Question will appear here", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(questionLabel, BorderLayout.NORTH);

        JPanel answersPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        answerButtons = new JButton[4];

        for (int i = 0; i < 4; i++) {
            answerButtons[i] = new JButton("Answer " + (i + 1));
            int finalI = i;
            answerButtons[i].addActionListener(e -> handleAnswer(finalI));
            answersPanel.add(answerButtons[i]);
        }

        add(answersPanel, BorderLayout.CENTER);

        // Lifeline buttons
        lifeline5050Button = new JButton("50:50 Lifeline");
        lifeline5050Button.addActionListener(e -> use5050Lifeline());

        phoneFriendButton = new JButton("📞 Phone a Friend");
        phoneFriendButton.addActionListener(e -> usePhoneAFriend());

        askAudienceButton = new JButton("📊 Ask the Audience");
        askAudienceButton.addActionListener(e -> useAskAudience());

        // End game button
        endGameButton = new JButton("End Game (Demo)");
        endGameButton.addActionListener(e -> gui.endGame(prize));

        // Bottom panel for buttons
        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.add(lifeline5050Button);
        bottomPanel.add(phoneFriendButton);
        bottomPanel.add(askAudienceButton);
        bottomPanel.add(endGameButton);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    public void startGame(String playerName) {
        questions = QuestionDAO.getAllQuestions();
        for (int i = 0; i < questions.size(); i++) {
    System.out.println("Q" + (i + 1) + ": " + questions.get(i).getQuestionText());
}

        currentQuestionIndex = 0;
        prize = 0;
        lifelineUsed = false;
        phoneUsed = false;
        audienceUsed = false;

        askAudienceButton.setEnabled(true);
        lifeline5050Button.setEnabled(true);
        phoneFriendButton.setEnabled(true);

        if (questions.isEmpty()) {
            questionLabel.setText("No questions found in database.");
            for (JButton btn : answerButtons) {
                btn.setEnabled(false);
            }
            return;
        }

        JOptionPane.showMessageDialog(this, "Welcome " + playerName + "! Let's play Millionaire!");
        displayQuestion(questions.get(currentQuestionIndex));
    }

private void displayQuestion(Question q) {
    System.out.println("🔍 Showing question #" + (currentQuestionIndex + 1) + ": " + q.getQuestionText());

    questionLabel.setText(q.getQuestionText());
    answerButtons[0].setText("A. " + q.getOptionA());
    answerButtons[1].setText("B. " + q.getOptionB());
    answerButtons[2].setText("C. " + q.getOptionC());
    answerButtons[3].setText("D. " + q.getOptionD());

    for (JButton btn : answerButtons) {
        btn.setEnabled(true);
    }

    revalidate();
    repaint();
}



   private void handleAnswer(int choiceIndex) {
    if (questions == null || questions.isEmpty()) return;

    Question currentQuestion = questions.get(currentQuestionIndex);
    char selected = (char) ('A' + choiceIndex);

    if (selected == currentQuestion.getCorrectAnswer()) {
        prize += 1000;

        // Show correct message first, then move to next question
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(this, "✅ Correct! Your prize is now $" + prize);

            currentQuestionIndex++;
            if (currentQuestionIndex < questions.size()) {
                displayQuestion(questions.get(currentQuestionIndex));
            } else {
                JOptionPane.showMessageDialog(this, "You have completed all questions!");
                gui.endGame(prize);
            }
        });

    } else {
        JOptionPane.showMessageDialog(this, "❌ Incorrect. The correct answer was: " + currentQuestion.getCorrectAnswer());
        gui.endGame(prize);
    }
}


    private void use5050Lifeline() {
        if (lifelineUsed) {
            JOptionPane.showMessageDialog(this, "You have already used the 50:50 lifeline!");
            return;
        }

        lifelineUsed = true;
        lifeline5050Button.setEnabled(false);

        Question current = questions.get(currentQuestionIndex);
        char correct = current.getCorrectAnswer();
        int hidden = 0;

        for (int i = 0; i < 4; i++) {
            char option = (char) ('A' + i);
            if (option != correct && hidden < 2) {
                answerButtons[i].setEnabled(false);
                hidden++;
            }
        }
    }

    private void useAskAudience() {
        if (audienceUsed) {
            JOptionPane.showMessageDialog(this, "You have already asked the audience!");
            return;
        }

        audienceUsed = true;
        askAudienceButton.setEnabled(false);

        Question current = questions.get(currentQuestionIndex);
        char correct = current.getCorrectAnswer();

        int total = 100;
        int correctPercent = 60 + (int)(Math.random() * 21);
        total -= correctPercent;

        List<Character> wrongOptions = new ArrayList<>(List.of('A', 'B', 'C', 'D'));
        wrongOptions.remove(Character.valueOf(correct));

        int wrong1 = (int)(Math.random() * (total + 1));
        int wrong2 = (int)(Math.random() * (total - wrong1 + 1));
        int wrong3 = total - wrong1 - wrong2;

        int[] distribution = new int[4];
        for (int i = 0; i < 4; i++) {
            char option = (char) ('A' + i);
            if (option == correct) {
                distribution[i] = correctPercent;
            } else if (option == wrongOptions.get(0)) {
                distribution[i] = wrong1;
            } else if (option == wrongOptions.get(1)) {
                distribution[i] = wrong2;
            } else {
                distribution[i] = wrong3;
            }
        }

        String message = "📊 Audience poll:\n" +
                "A: " + distribution[0] + "%\n" +
                "B: " + distribution[1] + "%\n" +
                "C: " + distribution[2] + "%\n" +
                "D: " + distribution[3] + "%";

        JOptionPane.showMessageDialog(this, message);
    }

    private void usePhoneAFriend() {
        if (phoneUsed) {
            JOptionPane.showMessageDialog(this, "You have already called your friend!");
            return;
        }

        phoneUsed = true;
        phoneFriendButton.setEnabled(false);

        Question current = questions.get(currentQuestionIndex);
        char correct = current.getCorrectAnswer();

        boolean guessCorrectly = Math.random() < 0.8;
        char guess = guessCorrectly ? correct : getRandomWrongAnswer(correct);

        JOptionPane.showMessageDialog(this, "📞 Friend thinks the answer is: " + guess);
    }

    private char getRandomWrongAnswer(char correct) {
        List<Character> options = new ArrayList<>(List.of('A', 'B', 'C', 'D'));
        options.remove(Character.valueOf(correct));
        return options.get((int)(Math.random() * options.size()));
    }
}
