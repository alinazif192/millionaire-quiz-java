/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package comp603.assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


/**
 *
 * @author alina
 * This panel is displayed at the end of the game to show the final prize and what is won
 * Gives two options to restart or exit.
 */

public class GameOverPanel extends JPanel {
    private MillionaireGUI gui;
    private JLabel prizeLabel;
    private JButton restartButton;
    private JButton exitButton;

    public GameOverPanel(MillionaireGUI gui) {
        this.gui = gui;
        setupPanel();
    }

    private void setupPanel() {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Game Over!", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        prizeLabel = new JLabel("", SwingConstants.CENTER);
        prizeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        add(prizeLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        restartButton = new JButton("Play Again");
        exitButton = new JButton("Exit");

        restartButton.addActionListener((ActionEvent e) -> gui.showMainMenu());
        exitButton.addActionListener((ActionEvent e) -> System.exit(0));

        buttonPanel.add(restartButton);
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void setFinalPrize(int prize) {
        prizeLabel.setText("You won: $" + prize);
    }
}
