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

public class PhoneAFriend implements Lifeline 
{
    private Random random = new Random();

    @Override
    public void use(Player player, Question question, boolean[] hiddenlife) 
    {
        int correctans = question.getCorrectAnswer() - 1;

        System.out.println("\nYour friend says:");
        if (random.nextInt(100) < 80) 
        {
            System.out.println("I'm sure it's " + (correctans + 1) + ". " + question.getOptions()[correctans]);
        } else 
        {
            List<Integer> available = new ArrayList<>();
            for (int i = 0; i < 4; i++) 
            {
                if (!hiddenlife[i]) available.add(i + 1);
            }
            Collections.shuffle(available);
            System.out.println("Maybe " + available.get(0) + "? I'm not sure.");
        }

        player.usePhoneAFriend();
    }

    @Override
    public String getName() 
    {
        return "Phone A Friend";
    }
}
