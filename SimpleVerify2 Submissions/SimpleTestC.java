

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SimpleTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SimpleTest
{
    Integer[] num = {1,2,3,4,5};
    Simple testObject = new Simple("text",42,true,num,1);
    
    /**
     * Default constructor for test class SimpleTest
     */
    public SimpleTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void constructorTest()
    {
        Simple simple1 = new Simple();
        Simple simple2 = new Simple(null, null, null, null, 1);
    }

    @Test
    public void flipTest()
    {
        assertEquals(true, testObject.truth());
        testObject.flip();
        assertEquals(false, testObject.truth());
    }

    //To be implented
    @Test
    public void nextInSequenceTest()
    {
    }

    @Test
    public void accessorsTest()
    {
        assertEquals(42, testObject.number());
        assertEquals("text", testObject.text());
        assertEquals(true, testObject.truth());
        Simple simple1 = new Simple("3", 4.5, false, null, 0);
        assertEquals(4.5, simple1.number());
        assertEquals("3", simple1.text());
        assertEquals(false, simple1.truth());
    }

    @Test
    public void toStringTest()
    {
        assertEquals("true, 42,text", testObject.toString());
    }
}






