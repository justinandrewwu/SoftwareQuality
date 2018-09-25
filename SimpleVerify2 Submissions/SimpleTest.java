import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.*;

/**
 * This is the first version of SimpleTest that will eventually be able to establish quality
 * of a class using the Simple API
 * @Matthew Sawaged
 * @version 0.0.1
 */

public class SimpleTest {

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

    @After
    public void tearDown(){
    }

    @Test
    public void logicStatus(){
        assertEquals(true,testObject.truth());
    }
    @Test
    public void flipLogicStatus(){
        testObject.flip();
        assertEquals(false,testObject.truth());
        testObject.flip();
        assertEquals(true,testObject.truth());
    }
    @Test
    public void textStatus(){
        assertEquals(testObject.text(), "HI");
    }
    @Test
    public void integerStatus(){
     assertEquals(testObject.number(), 21);
    }
    @Test
    public void testNextInSequence() {
        assertEquals(testObject.ia[0], testObject.nextInSequence());
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
    @Test
    public void toStringTest(){
        assertThat(testObject.toString(), is("Simple true 21 HI"));
    }
}