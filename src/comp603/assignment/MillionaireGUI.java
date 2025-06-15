/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package comp603.assignment;

import javax.swing.*;
import java.awt.*;

 /**
 *
 * @author ali
 */

/*
 * main run page for who wants to be a millionare.
 */

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



        setTitle("Who Wants to Be A Millionare?");
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
    
    // sets main view to the main menu screen
    public void showMainMenu() {
        layout.show(cardPanel, "MainMenu");
    }

    public void startGame(String playerName) {
        gamePanel.startGame(playerName);
        layout.show(cardPanel, "Game");
    }

    public void endGame(int finalPrize) {
    String name = gamePanel.getPlayerName();
    boolean used5050 = gamePanel.hasUsed5050();
    boolean usedAudience = gamePanel.hasUsedAudience();
    boolean usedPhone = gamePanel.hasUsedPhone();

    ScoreManager.savesScore(name, finalPrize, used5050, usedAudience, usedPhone);

    gameOverPanel.setFinalPrize(finalPrize);
    layout.show(cardPanel, "GameOver");
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MillionaireGUI::new);
    }
}