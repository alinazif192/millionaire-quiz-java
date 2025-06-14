/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603.assignment;

/**
 *
 * @author ali
 */

public class Player 
{
    private String name;
    private int currentPrize;
    private boolean used5050;
    private boolean usedAskAudience;
    private boolean usedPhoneAFriend;

    public Player(String name) 
    {
        this.name = name;
        this.currentPrize = 0;
        this.used5050 = false;
        this.usedAskAudience = false;
        this.usedPhoneAFriend = false;
    }

    // Getters
    public String getName() { return name; }
    public int getCurrentPrize() { return currentPrize; }
    public boolean hasUsed5050() { return used5050; }
    public boolean hasUsedAskAudience() { return usedAskAudience; }
    public boolean hasUsedPhoneAFriend() { return usedPhoneAFriend; }

    // Setters
    public void setCurrentPrize(int prize) { this.currentPrize = prize; }

    // Lifelines
    public void use5050() { used5050 = true; }
    public void useAskAudience() { usedAskAudience = true; }
    public void usePhoneAFriend() { usedPhoneAFriend = true; }

    // Reset
    public void reset() 
    {
        this.currentPrize = 0;
        this.used5050 = false;
        this.usedAskAudience = false;
        this.usedPhoneAFriend = false;
    }
}