/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package comp603.assignment;

import javax.swing.*;
import java.awt.*;

<<<<<<< HEAD
 /**
 *
 * @author ali
 */
=======
<<<<<<< HEAD
public class MillionaireGUI extends JFrame {
=======
public class MillionaireGUI extends JFrame  {
>>>>>>> 797db2ba65e5418eeb1f58ace555ddf2e50f0637
//layout manager to switch different panels
    private CardLayout layout;
    //panel that contains the screens
    private JPanel cardPanel;
>>>>>>> d01528b133eec3051a122fbb534110e3b77cff28

/*
 * main run page for who wants to be a millionare.
 */

public class MillionaireGUI extends JFrame {
    private CardLayout layout;
    private JPanel cardPanel;
    private MainMenuPanel mainMenuPanel;
    private GamePanel gamePanel;
    private GameOverPanel gameOverPanel;

<<<<<<< HEAD
    public MillionaireGUI() {
        DatabaseManager.initializeDatabase(); // creates database and table
        DatabaseManager.clearQuestions();     // clear existing questions
        QuestionDAO.insertSampleQuestion();   // inserts questions



        setTitle("Who Wants to Be A Millionare?");
        setSize(800, 600);
=======
<<<<<<< HEAD
    public MillionaireGUI() {
        setTitle("Who Wants to Be a Millionaire!");
        setSize(800, 600);
=======
    public MillionaireGUI()     {
        setTitle("Who Wants to Be a Millionaire!");
        setSize(700, 600);
        
>>>>>>> 797db2ba65e5418eeb1f58ace555ddf2e50f0637
>>>>>>> d01528b133eec3051a122fbb534110e3b77cff28
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        layout = new CardLayout();
        cardPanel = new JPanel(layout);

        mainMenuPanel = new MainMenuPanel(this);
<<<<<<< HEAD
        gamePanel = new GamePanel(this);
        gameOverPanel = new GameOverPanel(this);

        cardPanel.add(mainMenuPanel, "MainMenu");
        cardPanel.add(gamePanel, "Game");
        cardPanel.add(gameOverPanel, "GameOver");
=======
<<<<<<< HEAD
        gamePanel = new GamePanel(this);
        gameOverPanel = new GameOverPanel(this);

        cardPanel.add(mainMenuPanel, "MainMenu");
        cardPanel.add(gamePanel, "Game");
        cardPanel.add(gameOverPanel, "GameOver");
=======
         gamePanel = new GamePanel(this);
         gameOverPanel = new GameOverPanel(this);

        cardPanel.add(mainMenuPanel, "MainMenu");
            cardPanel.add(gamePanel, "Game");
            cardPanel.add(gameOverPanel, "GameOver");
>>>>>>> 797db2ba65e5418eeb1f58ace555ddf2e50f0637
>>>>>>> d01528b133eec3051a122fbb534110e3b77cff28

        add(cardPanel);
        setVisible(true);
    }
<<<<<<< HEAD
    
    // sets main view to the main menu screen
=======
//switches to main menu interface
<<<<<<< HEAD
=======
    
    
>>>>>>> 797db2ba65e5418eeb1f58ace555ddf2e50f0637
>>>>>>> d01528b133eec3051a122fbb534110e3b77cff28
    public void showMainMenu() {
        layout.show(cardPanel, "MainMenu");
    }

    public void startGame(String playerName) {
        gamePanel.startGame(playerName);
<<<<<<< HEAD
        layout.show(cardPanel, "Game");
=======
<<<<<<< HEAD
        layout.show(cardPanel, "Game");
=======
            layout.show(cardPanel, "Game");
>>>>>>> 797db2ba65e5418eeb1f58ace555ddf2e50f0637
>>>>>>> d01528b133eec3051a122fbb534110e3b77cff28
    }

    public void endGame(int finalPrize) {
<<<<<<< HEAD
    String name = gamePanel.getPlayerName();
    boolean used5050 = gamePanel.hasUsed5050();
    boolean usedAudience = gamePanel.hasUsedAudience();
    boolean usedPhone = gamePanel.hasUsedPhone();
=======
        gameOverPanel.setFinalPrize(finalPrize);
<<<<<<< HEAD
        layout.show(cardPanel, "GameOver");
    }

=======
            layout.show(cardPanel, "GameOver");
    }
>>>>>>> d01528b133eec3051a122fbb534110e3b77cff28

    ScoreManager.savesScore(name, finalPrize, used5050, usedAudience, usedPhone);

    gameOverPanel.setFinalPrize(finalPrize);
    layout.show(cardPanel, "GameOver");
}

<<<<<<< HEAD
=======

>>>>>>> 797db2ba65e5418eeb1f58ace555ddf2e50f0637
>>>>>>> d01528b133eec3051a122fbb534110e3b77cff28
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MillionaireGUI::new);
    }
}