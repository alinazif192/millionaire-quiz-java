/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package comp603.assignment;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author joel
 */

public class MoneyLevelsTest {


    @Test
    public void testGetPrize_ValidLevel() {
        int questionNum = 5;
        int expected = 1000;
        int actual = MoneyLevels.getPrize(questionNum);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetPrize_InvalidLowLevel() {
        int questionNum = 0;
        int expected = 0;
        int actual = MoneyLevels.getPrize(questionNum);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetPrize_InvalidHighLevel() {
        int questionNum = 20;
        int expected = 0;
        int actual = MoneyLevels.getPrize(questionNum);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsSafetyNet_True() {
        assertTrue(MoneyLevels.isSafetyNet(5));  // 1000 safetey nets
        assertTrue(MoneyLevels.isSafetyNet(10)); // 32000 safety nets
    }

    @Test
    public void testIsSafetyNet_False() {
        assertFalse(MoneyLevels.isSafetyNet(6)); // 2000 not safety net nubmers
        assertFalse(MoneyLevels.isSafetyNet(9)); // 16000 not safety net numbers
    }
}
