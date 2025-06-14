/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603.assignment;


/**
 *
 * @author alina
 * Main GUI class for the game.
 * This class sets up the JFrame window and also controls the switching between
 * the screens : Main menu, game screen and Game Over

 */

import javax.swing.*;
import java.awt.*;

<<<<<<< HEAD
public class MillionaireGUI extends JFrame {
=======
public class MillionaireGUI extends JFrame  {
>>>>>>> 797db2ba65e5418eeb1f58ace555ddf2e50f0637
//layout manager to switch different panels
    private CardLayout layout;
    //panel that contains the screens
    private JPanel cardPanel;

    private MainMenuPanel mainMenuPanel;
    private GamePanel gamePanel;
    private GameOverPanel gameOverPanel;

<<<<<<< HEAD
    public MillionaireGUI() {
        setTitle("Who Wants to Be a Millionaire!");
        setSize(800, 600);
=======
    public MillionaireGUI()     {
        setTitle("Who Wants to Be a Millionaire!");
        setSize(700, 600);
        
>>>>>>> 797db2ba65e5418eeb1f58ace555ddf2e50f0637
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
         gamePanel = new GamePanel(this);
         gameOverPanel = new GameOverPanel(this);

        cardPanel.add(mainMenuPanel, "MainMenu");
            cardPanel.add(gamePanel, "Game");
            cardPanel.add(gameOverPanel, "GameOver");
>>>>>>> 797db2ba65e5418eeb1f58ace555ddf2e50f0637

        add(cardPanel);
        showMainMenu();
    }
//switches to main menu interface
<<<<<<< HEAD
=======
    
    
>>>>>>> 797db2ba65e5418eeb1f58ace555ddf2e50f0637
    public void showMainMenu() {
        layout.show(cardPanel, "MainMenu");
    }

    public void startGame(String playerName) {
        gamePanel.startGame(playerName);
<<<<<<< HEAD
        layout.show(cardPanel, "Game");
=======
            layout.show(cardPanel, "Game");
>>>>>>> 797db2ba65e5418eeb1f58ace555ddf2e50f0637
    }
//
    public void endGame(int finalPrize) {
        gameOverPanel.setFinalPrize(finalPrize);
<<<<<<< HEAD
        layout.show(cardPanel, "GameOver");
    }

=======
            layout.show(cardPanel, "GameOver");
    }

public void showGamePanel()  {
    layout.show(cardPanel, "Game"); 
}


>>>>>>> 797db2ba65e5418eeb1f58ace555ddf2e50f0637
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MillionaireGUI().setVisible(true);
        });
    }
}
