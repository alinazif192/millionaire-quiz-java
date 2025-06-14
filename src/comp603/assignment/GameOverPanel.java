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
 * This panel is displayed at the end of the game to show the final prize and what is won
 * Gives two options to restart or exit.
 */
public class GameOverPanel extends JPanel   {

    private MillionaireGUI gui;
    private JLabel finalPrizeLabel;

    public GameOverPanel(MillionaireGUI gui)    {
        this.gui = gui;
        setupPanel();
    }

    private void setupPanel()   {
        // setup of end screen
        setLayout(new BorderLayout()) ;

        JLabel gameOverTitle = new JLabel("Game Over!", SwingConstants.CENTER);
        gameOverTitle.setFont(new Font("Serif", Font.BOLD, 26));
        add(gameOverTitle, BorderLayout.NORTH);

        finalPrizeLabel = new JLabel("You walked away with nothing!", SwingConstants.CENTER);
        
        finalPrizeLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        
        add(finalPrizeLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        
            JButton restartButton = new JButton("Back to Menu");
            JButton exitButton = new JButton("Exit");

        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.showMainMenu();
            }
        });

        exitButton.addActionListener(e -> System.exit(0));

            buttonPanel.add(restartButton) ;
         buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    // called when game ends
    public void setFinalPrize(int prize)    {
        finalPrizeLabel.setText("You just won $" + prize + "! Good Job!");
    }
}
