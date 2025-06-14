/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603.assignment;

/**
 *
 * @author joel
 */

import java.util.*;

public class FiftyFifty implements Lifeline 
{

    @Override
    public void use(Player player, Question question, boolean[] hiddenlife) 
    {
        
        // gets correct answer
        int correctans = question.getCorrectAnswer() - 1;
        
        //stores list of all wrong answers
        List<Integer> wrongIndices = new ArrayList<>();

        
        // identifies all wrong answer indicies
        for (int i = 0; i < 4; i++) 
        {
            if (i != correctans) 
            {
                wrongIndices.add(i);
            }
        }

        // randomly select wrong answers and mark them has hidden
        Collections.shuffle(wrongIndices);
        hiddenlife[wrongIndices.get(0)] = true;
        hiddenlife[wrongIndices.get(1)] = true;

        
        // display options 
        System.out.println("\n50/50 used! The two wrong answers removed:");
        for (int i = 0; i < 4; i++) 
        {
            if (!hiddenlife[i]) 
            {
                System.out.println((i + 1) + ". " + question.getOptions()[i]);
            }
        }

        
        // notifying player object
        player.use5050();
    }

    @Override
    public String getName() 
    {
        return "50/50";
    }
}
