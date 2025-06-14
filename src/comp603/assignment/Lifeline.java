/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp603.assignment;

/**
 *
 * @author joel
 */

public interface Lifeline 
{
    void use(Player player, Question question, boolean[] hiddenlife);
    String getName();
}
