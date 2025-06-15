/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603.assignment;

<<<<<<< HEAD
import javax.swing.SwingUtilities;

/**
 * @author joel;
 */

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MillionaireGUI());
    }
}
=======
/**
 *
 * @author joel
 */

import java.util.Scanner;

public class Main 
{
    
    
    
    public static void printrules(String text) 
    {
        for (char c : text.toCharArray()) 
        {
            System.out.print(c);
            try { Thread.sleep(5); } catch (Exception e) {}
        }
        System.out.println();
    }
    
    
    public static void printRules() 
    {
        printrules("\n-------------------------------------------------------------------");
        printrules("Who Wants to Be a Millionaire!");
        printrules("-------------------------------------------------------------------");
        printrules("\nRULES");
        
        printrules("\nThe Goal:");
        printrules("Goal is to answer 15 multiple-choice questions correctly in a row to gain the $1 million prize.");
        
        printrules("\nQuestions:");
        printrules("The questions are each multiple choice answers, which has to be selected from the numbers 1-4.");
        printrules("The questions get progressively harder as the most questions you answer.");
        
        printrules("\nSafe Levels:");
        printrules("There are two safe levels, where you are guaranteed the money when you get to that certain");
        printrules("money level, which in this case it is $1,000, and $32,000");
        
        printrules("\nLifelines:");
        printrules("There are 3 different lifelines, that are useable only once:");
        printrules("1. 50/50: Eliminates two wrong answers out of the 4 possible answers");
        printrules("2. Phone a Friend: Get help from a knowledgeable friend");
        printrules("3. Ask the Audience: See what the audience thinks is correct\n");
    }
    
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        
        while (playAgain) 
        {
            printRules();
            
            System.out.print("Enter your name: ");
            String playerName = scanner.nextLine();
            
            Player player = new Player(playerName);
            Game game = new Game(player);
            
            game.startGame();
            
            
            System.out.print("\nWould you like to play again? (yes/no): ");
            String response = scanner.nextLine().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }
        
        printrules("\nThanks for playing!");
        scanner.close();
    }
}
>>>>>>> d01528b133eec3051a122fbb534110e3b77cff28
