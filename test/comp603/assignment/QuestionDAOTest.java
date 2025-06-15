/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package comp603.assignment;

import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ali
 */

public class QuestionDAOTest {

    @BeforeClass
    public static void setUpClass() {
        DatabaseManager.initializeDatabase();
        }

    
    
    @Before
    public void setupEachTest() {
        DatabaseManager.clearQuestions();
        QuestionDAO.insertSampleQuestion(); // insert before each test
    }

    
    
    @Test
    public void testInsertSampleQuestion() {
        System.out.println("Running testInsertSampleQuestion");

        List<Question> questions = QuestionDAO.getAllQuestions();
        assertNotNull("Returned list should not be null", questions);
        assertTrue("Expected at least one question in the database", questions.size() >= 1);
        }

    
    @Test
    public void testGetAllQuestionsReturnsValidData() {
        System.out.println("Running testGetAllQuestionsReturnsValidData");

        List<Question> result = QuestionDAO.getAllQuestions();
        assertNotNull("List should not be null", result);
        assertFalse("List should not be empty", result.isEmpty());

        Question q = result.get(0);
        assertNotNull("Question text should not be null", q.getQuestionText());
        assertTrue("Correct answer should be A, B, C or D", "ABCD".indexOf(q.getCorrectAnswer()) >= 0);
    }
}
