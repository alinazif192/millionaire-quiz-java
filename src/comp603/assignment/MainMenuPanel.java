/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603.assignment;

import javax.swing.*;
import java.awt.*;

/**
 * @author joel
 */
/*
 * allows the user to start the game, view instructions, and exit.
 */

public class MainMenuPanel extends JPanel {

    private MillionaireGUI gui;

    public MainMenuPanel(MillionaireGUI gui) {
        this.gui = gui;
        setupPanel();
    }

    private void setupPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(0, 139, 139)); 

        // game title
        JLabel title = new JLabel("Who Wants to Be a Millionaire?", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 32));
        title.setForeground(Color.BLACK); 
        title.setBorder(BorderFactory.createEmptyBorder(40, 10, 30, 10));
        add(title, BorderLayout.NORTH);

        // button panel
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 15, 15));
        buttonPanel.setOpaque(false); 

        JButton startButton = createStyledButton("Begin Game");
        JButton instructionsButton = createStyledButton("Instructions");
        JButton exitButton = createStyledButton("Exit");

        startButton.addActionListener(e -> {
        String name;
        while (true) {
        name = JOptionPane.showInputDialog(gui, "Enter your name:");
        
        if (name == null) {
            return; 
        }

        name = name.trim();

        //  must be only letters and not empty
        if (!name.isEmpty() && name.matches("[A-Za-z ]+")) {
            gui.startGame(name);
            break;
        } else {
            JOptionPane.showMessageDialog(gui, 
                "Please enter a valid name.", 
                "Invalid Name", JOptionPane.WARNING_MESSAGE);
            }
         }
            });

        instructionsButton.addActionListener(e ->
                JOptionPane.showMessageDialog(gui,
                        "Answer 15 questions to win $1,000,000!\n" +
                        "Use your lifelines wisely:\n - 50:50\n - Phone a Friend\n - Ask the Audience",
                        "Game Instructions", JOptionPane.INFORMATION_MESSAGE)
        );

        exitButton.addActionListener(e -> System.exit(0));

        buttonPanel.add(startButton);
        buttonPanel.add(instructionsButton);
        buttonPanel.add(exitButton);

        //ensureed buttons are centered 
        JPanel centerWrapper = new JPanel(new GridBagLayout());
        centerWrapper.setOpaque(false);
        centerWrapper.add(buttonPanel);

        add(centerWrapper, BorderLayout.CENTER);
    }

    // for the buttons and text
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Dialog", Font.BOLD, 18));
        button.setFocusPainted(false);
        button.setBackground(new Color(173, 216, 230)); 
        button.setForeground(Color.BLACK); 
        button.setPreferredSize(new Dimension(250, 50));
        return button;
    }
}
