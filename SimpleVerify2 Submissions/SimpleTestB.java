import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class simpleTest extends simple {

    simple testObj = new simple("Test String", Integer.valueOf(42), Boolean.valueOf(true), new Integer[0], 5);

    /*
    Tests the no arguments constructor for object creation.
     */
    @Test
    public void initializedValueTest() {
        simple testObj = new simple();
    }

    /*
    Tests that the truth method returns a value.
     */
    @Test
    public void truthTest() {
        simple.truth();
    }

    /*
    Tests that the truth method returns true when the simple object when the truth status is set to true.
     */
    @Test
    public void truthTrueTest() {
        Assert.assertTrue(testObj.truth());
    }

    /*
    Tests that the truth method returns false when the simple object when the truth status is set to false.
     */
    @Test
    public void truthFalseTest() {
        simple testObj = new simple("Test String", Integer.valueOf(42), Boolean.FALSE, new Integer[0], 5);
        Assert.assertFalse(testObj.truth());
    }

    /*
    Tests that the number method returns a value.
     */
    @Test
    public void numberTest() {
        simple.number();
    }

    /*
    Tests that the number method returns value 42 in accordance to the simple object setup.
     */
    @Test
    public void number42Test() {
        Assert.assertEquals(Integer.valueOf(42), simple.number());
    }

    /*
    Tests that the number method returns the maximum integer value in accordance to the simple object setup.
     */
    @Test
    public void numberMaxTest() {
        simple testObj = new simple("Test String", Integer.MAX_VALUE, Boolean.valueOf(true), new Integer[0], 5);
        Assert.assertEquals(Integer.MAX_VALUE, simple.number());
    }

    /*
    Tests that the number method returns the minimum integer value in accordance to the simple object setup.
     */
    @Test
    public void numberMinTest() {
        simple testObj = new simple("Test String", Integer.MIN_VALUE, Boolean.valueOf(true), new Integer[0], 5);
        Assert.assertEquals(Integer.MIN_VALUE, testObj.number());
    }

    /*
    Tests that the text method returns "Test String" in accordance with the simple object setup.
     */
    @Test
    public void textTest() {
        Assert.assertEquals("Test String", testObj.text());
    }

    /*
    Tests that the method flip can be called.
     */
    @Test
    public void flipTest() {
        testObj.flip();
    }

    /*
    Test for the flip method to return false when it has a true status.
     */
    @Test
    public void flipTrueTest() {
        simple testObj = new simple("Test String", Integer.valueOf(24), Boolean.valueOf(true), new Integer[0], 5);
        testObj.flip();
        Assert.assertFalse(testObj.truth());
    }

    /*
    Test for the flip method to return true when it has a false status.
    */
    @Test
    public void flipFalseTest() {
        simple testObj = new simple("Test String", Integer.valueOf(24), Boolean.valueOf(false), new Integer[0], 5);
        testObj.flip();
        Assert.assertTrue(testObj.truth());
    }

    /*
    Tests that nextInSequence returns an integer.
    */
    @Test
    public void nextInSequenceTest() {
        testObj.nextInSequence();
    }

    /*
    Tests that nextInSequence returns the value of the initValues field added from the last entry to x
    entries from the last entry where x is defined by the value of depth. In this test depth is equivalent
    to 3 while the intValues are {1, 2, 3}.
     */
    @Test
    public void nextInSequenceAssignedTest() {
        Integer[] intArray = {1, 2, 3};
        simple testObj = new simple("Test String", Integer.valueOf(42), Boolean.valueOf(true), intArray, 3);
        Integer sequenceTotal = 0;
        int depth = 3;
        for(int i = 0; i < depth; i++) {
            sequenceTotal += intArray[i];
        }
        Assert.assertEquals(sequenceTotal, testObj.nextInSequence());
    }

    /*
    Tests that the toString renders a Simple object in the format: Simple[truth, number, "text"] and the
    fields set up to the values specified with the original testObj initialization.
     */
    @Test
    public void toStringTest() {
        String testString = "Simple[true, 42, \"Test String\"]";
        Assert.assertEquals(testString, testObj.toString());
    }
    /*
    Tests that the toString renders a Simple object in the format: Simple[truth, number, "text"] and the
    fields set up to the values specified with the original testObj initialization.
    */
    @Test
    public void toStringVariableTest() {
        String testString = "Simple[false, -100, \"Test\"]";
        simple testObj = new simple("Test", Integer.valueOf(-100), Boolean.valueOf(false), new Integer[0], 5);
        Assert.assertEquals(testString, testObj.toString());
    }


}