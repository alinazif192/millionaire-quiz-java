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
 * @author joel
 */

public class PlayerTest {

    private Player player;

    @Before
    public void setUp() {
        player = new Player("Joel");
    }

    @Test
    public void testGetName() {
        assertEquals("Joel", player.getName());
    }

    @Test
    public void testInitialPrizeIsZero() {
        assertEquals(0, player.getCurrentPrize());
    }

    @Test
    public void testSetAndGetCurrentPrize() {
        player.setCurrentPrize(32000);
        assertEquals(32000, player.getCurrentPrize());
    }

    @Test
    public void testUse5050() {
        assertFalse(player.hasUsed5050());
        player.use5050();
        assertTrue(player.hasUsed5050());
    }

    @Test
    public void testUseAskAudience() {
        assertFalse(player.hasUsedAskAudience());
        player.useAskAudience();
        assertTrue(player.hasUsedAskAudience());
    }

    @Test
    public void testUsePhoneAFriend() {
        assertFalse(player.hasUsedPhoneAFriend());
        player.usePhoneAFriend();
        assertTrue(player.hasUsedPhoneAFriend());
    }

    @Test
    public void testReset() {
        player.setCurrentPrize(64000);
        player.use5050();
        player.useAskAudience();
        player.usePhoneAFriend();

        player.reset();

        assertEquals(0, player.getCurrentPrize());
        assertFalse(player.hasUsed5050());
        assertFalse(player.hasUsedAskAudience());
        assertFalse(player.hasUsedPhoneAFriend());
    }
}
