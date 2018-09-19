

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SimpleTest.
 *
 * @Matthew Sawaged
 * @version (a version number or a date)
 */
public class SimpleTest{
    Simple testObject = new Simple();
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    @Before
    public void setUp(){
        testObject.s = "HI";
        testObject.n = 21;
        testObject.b = true;
        testObject.ia = new Integer[] {3,4,5};
        testObject.depth = 3;
    }
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown(){
    }
    @Test
    public void checkingTruthValue(){
        assertEquals(true, testObject.truth());
    }
    @Test
    public void checkFlipTest(){
        testObject.flip();
        assertEquals(false,testObject.truth());
    }
    @Test
    public void numberStateTest(){
        assertEquals(21, testObject.number());
    }
    @Test
    public void testNextInSequence()
    {
        assertEquals(testObject.ia[0],testObject.nextInSequence());
        
    }
    @Test
    public void testSecondNextInSequence(){
        testObject.nextInSequence();
        assertEquals(testObject.ia[1], testObject.nextInSequence());
    }
    @Test
    public void testThirdNextInSequence(){
        testObject.nextInSequence();
        testObject.nextInSequence();
        assertEquals(testObject.ia[2], testObject.nextInSequence());
    }
}
