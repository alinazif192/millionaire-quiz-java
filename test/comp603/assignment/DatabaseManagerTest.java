/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package comp603.assignment;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author joel
 */

public class DatabaseManagerTest {

    @Before
    public void setUp() {
        DatabaseManager.initializeDatabase();
        DatabaseManager.clearQuestions();
    }

    @Test
    public void testGetConnection() throws SQLException {
        Connection conn = DatabaseManager.getConnection();
        assertNotNull("Connection should not be null", conn);
        assertFalse("Connection should not be closed", conn.isClosed());
        conn.close();
    }

    @Test
    public void testInitializeDatabaseCreatesTable() throws SQLException {
        Connection conn = DatabaseManager.getConnection();
        Statement stmt = conn.createStatement();

        // Check that the table exists by querying metadata
        ResultSet rs = stmt.executeQuery("SELECT * FROM Questions");
        assertNotNull("Should be able to select from Questions", rs);

        conn.close();
    }

    @Test
    public void testClearQuestionsActuallyClearsTable() throws SQLException {
        // fake row inserted
        Connection conn = DatabaseManager.getConnection();
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO Questions (question, optionA, optionB, optionC, optionD, correctAnswer) " +
                "VALUES ('Dummy?', 'A', 'B', 'C', 'D', 'A')");

        // check row is properly inserted
        ResultSet rs1 = stmt.executeQuery("SELECT COUNT(*) FROM Questions");
        rs1.next();
        int countBefore = rs1.getInt(1);
        assertTrue("Should have at least 1 row before clear", countBefore > 0);

        // clear row and check again
        DatabaseManager.clearQuestions();
        ResultSet rs2 = stmt.executeQuery("SELECT COUNT(*) FROM Questions");
        rs2.next();
        int countAfter = rs2.getInt(1);
        assertEquals("Should be 0 rows after clear", 0, countAfter);

        conn.close();
    }
}

