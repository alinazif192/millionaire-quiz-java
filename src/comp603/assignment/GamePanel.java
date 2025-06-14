/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603.assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author alina
 * This class is the main gameplay screen where the questions are displayed
 * The player answers the questions displayed from this class to win money.
 */
public class GamePanel extends JPanel {

    private MillionaireGUI gui;
    private JLabel questionLabel;
    private JButton[] answerButtons;
    private JButton endGameButton;

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

        endGameButton = new JButton("End Game (Demo)");
        endGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.endGame(5000); // Jtet va;ue for moeny
            }
        });

        add(endGameButton, BorderLayout.SOUTH);
    }

    // this will be expanded with real question logic
    public void startGame(String playerName) {
        questionLabel.setText("Welcome " + playerName + "! Here is your first question:");
        for (int i = 0; i < 4; i++) {
            answerButtons[i].setText("Option " + (char) ('A' + i));
        }
    }

    private void handleAnswer(int choice) {
        JOptionPane.showMessageDialog(this, "You chose answer " + (char) ('A' + choice));
    }
}
