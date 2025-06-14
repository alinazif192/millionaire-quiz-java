/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author joel
 */
package comp603.assignment;

import java.util.*;



public class Asktheaudiencelifeline implements Lifeline 
{
    // creates randon number for ask the audience
    private Random random = new Random();

    @Override
    public void use(Player player, Question question, boolean[] hiddenlife) 
    {
        System.out.println("\nThe Audience votes:");
        int correctans = question.getCorrectAnswer() - 1;

        // loops all possible answers
        for (int i = 0; i < 4; i++) 
        {
            if (!hiddenlife[i])
            {
                // generates percent (70-90%) for the correct answers (0-30%) for a incorrect answer
                int percent = (i == correctans) ? 70 + random.nextInt(21) : random.nextInt(31);
                // format
                System.out.println((i + 1) + ". " + question.getOptions()[i] + ": " + percent + "%");
            }
        }

        // sends player object saying this lifeline is gone
        player.useAskAudience();
    }

    @Override
    public String getName() 
    {
        return "Ask The Audience";
    }
}
