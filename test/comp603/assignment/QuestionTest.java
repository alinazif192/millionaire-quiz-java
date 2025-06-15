/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package comp603.assignment;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ali
 */

public class QuestionTest   {

    private Question instance;

    @Before
    public void setUp() {
        instance = new Question(
            "What is the capital of New Zealand",
            "Auckland", "Dunedin", "Wellington", "Christchurch",
            'C'
        );
        }

    @Test
    public void testGetQuestionText() {
        assertEquals("What is the capital of New Zealand", instance.getQuestionText());
    }

    @Test
    public void testGetOptionA() {
        assertEquals("Auckland", instance.getOptionA());
    }

    @Test
    public void testGetOptionB() {
        assertEquals("Dunedin", instance.getOptionB());
        }
    

    @Test
    public void testGetOptionC() {
        assertEquals("Wellington", instance.getOptionC());
    }

    
    
    @Test
    public void testGetOptionD() {
        assertEquals("Christchurch", instance.getOptionD());
        }

    
    
    @Test
    public void testGetCorrectAnswer() {
        assertEquals('C', instance.getCorrectAnswer());
    }
}
