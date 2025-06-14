/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603.assignment;

/**
 *
 * @author ali
 */
public class MoneyLevels 
{
    
    // array for the 15 levels of prize money
    public static final int[] PRIZES = 
    {
        100, 200, 300, 500, 1000,
        2000, 4000, 8000, 16000, 32000,
        64000, 125000, 250000, 500000, 1000000
    };
    
    // setting the safety levels 
    public static final int[] safety_money = {1000, 32000};
    
    // returns prize money for each question
    public static int getPrize(int questionNum) 
    {
        if (questionNum >= 1 && questionNum <= PRIZES.length) 
        {
            return PRIZES[questionNum - 1];
        }
        return 0;
    }
    
    // check if current question level is safety money question
    public static boolean isSafetyNet(int numQuestion) 
    {
        
        // checks array for safety money amount 
        for (int net : safety_money) 
        {
            if (getPrize(numQuestion) == net) 
            {
                return true;
            }
        }
        return false;
    }
}