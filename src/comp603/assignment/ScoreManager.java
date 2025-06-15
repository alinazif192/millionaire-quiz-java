/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603.assignment;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author joel
 */

/*
 * ScoreManager handles saving the player's final game results to a file.
 */

public class ScoreManager {
    public static void savesScore(String playerName, int finalPrize, boolean used5050, boolean usedAudience, boolean usedPhone) {
        String line = "Name = "+ playerName + "|" + "Money = " + finalPrize + "|" +"Used 50/50 = " + used5050 + "|" + "Used Audience = " + usedAudience + "|" + "Used Phone = " + usedPhone;

        try (FileWriter writer = new FileWriter("scores.txt", true)) {
            writer.write(line + "\n");
        } catch (IOException e) {
        }
    }
}