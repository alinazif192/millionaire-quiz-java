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
 * @author joel
 * MainMenuPanel - starting screen for the game.
 * Allows the user to start the game, view instructions, and exit.
 */
public class MainMenuPanel extends JPanel {

    private MillionaireGUI gui;

    public MainMenuPanel(MillionaireGUI gui) {
        this.gui = gui;
        setupPanel();
    }

    private void setupPanel() {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Who Wants to Be a Millionaire", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 22));
        add(title, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));

        JButton startButton = new JButton("Begin Game");
        JButton instructionsButton = new JButton("Instructions");
        JButton exitButton = new JButton("Exit");

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(gui, "Enter your name:");
                if (name != null && !name.trim().isEmpty()) {
                    gui.startGame(name.trim()); // Properly start the game with player name
                }
            }
        });

        instructionsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(gui,
                        "Answer the questions right and win money!\nUse lifelines wisely!",
                        "Instructions", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonPanel.add(startButton);
        buttonPanel.add(instructionsButton);
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.CENTER);
    }
}
