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

public class MillionaireGUI extends JFrame {
//layout manager to switch different panels
    private CardLayout layout;
    //panel that contains the screens
    private JPanel cardPanel;

    private MainMenuPanel mainMenuPanel;
    private GamePanel gamePanel;
    private GameOverPanel gameOverPanel;

    public MillionaireGUI() {
        setTitle("Who Wants to Be a Millionaire!");
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
        showMainMenu();
    }
//switches to main menu interface
    public void showMainMenu() {
        layout.show(cardPanel, "MainMenu");
    }

    public void startGame(String playerName) {
        gamePanel.startGame(playerName);
        layout.show(cardPanel, "Game");
    }
//
    public void endGame(int finalPrize) {
        gameOverPanel.setFinalPrize(finalPrize);
        layout.show(cardPanel, "GameOver");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MillionaireGUI().setVisible(true);
        });
    }
}
