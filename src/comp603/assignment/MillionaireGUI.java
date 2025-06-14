/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

    /**
 *
 * @author alina
 */
package comp603.assignment;

import javax.swing.*;
import java.awt.*;

public class MillionaireGUI extends JFrame {
    private CardLayout layout;
    private JPanel cardPanel;
    private MainMenuPanel mainMenuPanel;
    private GamePanel gamePanel;
    private GameOverPanel gameOverPanel;

    public MillionaireGUI() {
        DatabaseManager.initializeDatabase(); // creates database and table
        DatabaseManager.clearQuestions();     // clear existing questions
        QuestionDAO.insertSampleQuestion();   // inserts questions



        setTitle("Millionaire Quiz Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        layout = new CardLayout();
        cardPanel = new JPanel(layout);

        mainMenuPanel = new MainMenuPanel(this);
        gamePanel = new GamePanel(this);
        gameOverPanel = new GameOverPanel(this);

        cardPanel.add(mainMenuPanel, "MainMenu");
        cardPanel.add(gamePanel, "Game");
        cardPanel.add(gameOverPanel, "GameOver");

        add(cardPanel);
        setVisible(true);
    }

    public void showMainMenu() {
        layout.show(cardPanel, "MainMenu");
    }

    public void startGame(String playerName) {
        gamePanel.startGame(playerName);
        layout.show(cardPanel, "Game");
    }

    public void endGame(int finalPrize) {
        gameOverPanel.setFinalPrize(finalPrize);
        layout.show(cardPanel, "GameOver");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MillionaireGUI::new);
    }
}