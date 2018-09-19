import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.*;
import java.util.Arrays;

public class SimpleVerification {

    public static void main(String[] args) {

        /* Manual examination:
             Compiles and runs
             No public methods except:
                flip()
                nextInSequence()
                number()
                text()
                toString()
                truth() */

        // Test constructor with and without arguments passed
 //       Simple defaultSimple = new Simple();
        Simple defaultSimple = new Simple("defined text", 42, true, new Integer[]{0, 1}, 2);
        Simple definedSimple = new Simple("defined text", 42, true, new Integer[]{0, 1}, 2);

        // Let's try to break stuff
        newSimple("Zero Values", "",0,false, new Integer[]{},0);
        newSimple("Negative Values", "",-1,false, new Integer[]{-1, -2, -3},-1);
        newSimple("Big Text", new String(new char[100000000]).replace("\0", "*"),0,false,new Integer[]{},0); // Integer.MAX_VALUE exceeds my memory limit
        newSimple("Symbol Text", "!@#$%^&*(){}-=+`~",0,false,new Integer[]{},0);
        newSimple("Big Depth", "",0,false, new Integer[]{},250000000);  // Integer.MAX_VALUE exceeds my memory limit
        newSimple("Negative Depth", "",0,false, new Integer[]{},Integer.MIN_VALUE);
        newSimple("Long Array", "",0,false, new Integer[500],0);

        newSimple("AtomicInteger Number", "",new AtomicInteger(Integer.MAX_VALUE),false, new Integer[]{},0);
        newSimple("AtomicInteger Number (Negative)", "",new AtomicInteger(Integer.MIN_VALUE),false, new Integer[]{},0);

        newSimple("AtomicLong Number", "",new AtomicLong(9223372036854775807L),false, new Integer[]{},0);
        newSimple("AtomicLong Number (Negative)", "",new AtomicLong(-9223372036854775807L),false, new Integer[]{},0);

        newSimple("BigDecimal Number", "",new BigDecimal("1238126387123"),false, new Integer[]{},0);
        newSimple("BigDecimal Number (Negative)", "",new BigDecimal("-1238126387123"),false, new Integer[]{},0);

        newSimple("BigInteger Number", "",new BigInteger("123456789123456789"),false, new Integer[]{},0);
        newSimple("BigInteger Number (Negative)", "",new BigInteger("-123456789123456789"),false, new Integer[]{},0);

        newSimple("Byte Number", "",(byte)127,false, new Integer[]{},0);
        newSimple("Byte Number (Negative)", "", (byte)-128,false, new Integer[]{},0);

        newSimple("Double Number", "",new Double(1.7976931348623157E308),false, new Integer[]{},0);
        newSimple("Double Number (Negative)", "",new Double(	4.9E-324),false, new Integer[]{},0);

        newSimple("Float Number", "",3.4028235E38F,false, new Integer[]{},0);
        newSimple("Float Number (Negative)", "",1.4E-45F,false, new Integer[]{},0);

        newSimple("Integer Number", "",Integer.MAX_VALUE,false, new Integer[]{},0);
        newSimple("Integer Number (Negative)", "",Integer.MIN_VALUE,false, new Integer[]{},0);

        newSimple("Long Number", "",9223372036854775807L,false, new Integer[]{},0);
        newSimple("Long Number (Negative)", "",-9223372036854775807L,false, new Integer[]{},0);

        newSimple("Short Number", "",(short)32767,false, new Integer[]{},0);
        newSimple("Short Number (Negative)", "", (short)-32768,false, new Integer[]{},0);


        // Simple.truth() is a Boolean and matches argument 3 if provided.
        verifyType(defaultSimple.truth(), "Boolean", "defaultSimple.truth()");
        verifyType(definedSimple.truth(), "Boolean", "definedSimple.truth()");
        if (definedSimple.truth().equals(true)) {}
        else {
            System.out.println("definedSimple.truth does not match argument 3");
        }


        // Simple.number() is a Number and matches argument 2 if provided.
        verifyType(defaultSimple.number(), "Number", "defaultSimple.number()");
        verifyType(definedSimple.number(), "Number", "definedSimple.number()");
        if (definedSimple.number().equals(42)) {}
        else {
            System.out.println("definedSimple.number does not match argument 2");
        }

        System.out.println(">>>>>>> number() tested <<<<<<<<");


        // Simple.text() is a String and matches argument 1 if provided.
        verifyType(defaultSimple.text(), "String", "defaultSimple.text()");
        verifyType(definedSimple.text(), "String", "definedSimple.text()");
        if (definedSimple.text().equals("defined text")) {}
        else {
            System.out.println("definedSimple.text does not match argument 1");
        }


        System.out.println(">>>>>>> text() tested <<<<<<<<");

        // Simple.toString() is a public String that returns a representation of Simple in the format of Simple[<truth>, <number>, "<text>"]
        verifyToString(definedSimple.toString(), "Simple[true, 42, \"defined text\"]");
        verifyToString(defaultSimple.toString(), "Simple[" + defaultSimple.truth() + ", " + defaultSimple.number() + ", \"" + defaultSimple.text() + "\"]");


        System.out.println(">>>>>>> tostring() tested <<<<<<<<");

        // Simple.flip() is a public void which inverts Simple.truth value
        boolean oldDefaultTruth = defaultSimple.truth();
        boolean oldDefinedTruth = definedSimple.truth();
        defaultSimple.flip();
        definedSimple.flip();
        verifyFlip(oldDefaultTruth, defaultSimple.truth());
        verifyFlip(oldDefinedTruth, definedSimple.truth());


        System.out.println(">>>>>>> flip() tested <<<<<<<<");


        // Simple.nextInSequence() is a public Integer which iterates through the initVals array and then returns the sum of its last <depth> returns.
        verifyType(defaultSimple.nextInSequence(), "Integer", "defaultSimple.nextInSequence()");
        verifySequence(new Integer[]{4,9,12},0,"[4, 9, 12, 0, 0, 0, 0]");
        verifySequence(new Integer[]{7},1,"[7, 7, 7, 7, 7, 7]");
        verifySequence(new Integer[]{3,8},1,"[3, 8, 8, 8, 8, 8, 8]");
        verifySequence(new Integer[]{2,4},2,"[2, 4, 6, 10, 16, 26, 42, 68]");
        verifySequence(new Integer[]{2,4,6,8},3,"[2, 4, 6, 8, 18, 32, 58, 108]");


        System.out.println(">>>>>>> sequence() tested <<<<<<<<");

    }

    public static void newSimple(String name, String text, Number number, Boolean truth, Integer[] initVals, int depth) {
        String initValsString = Arrays.toString(initVals);

        try {
            Simple newSimple = new Simple(text, number, truth, initVals, depth);

            if (newSimple.text().equals(text)) {}
            else {
                System.out.print(name + " initialization error: ");
                System.out.println("    " + newSimple.text() + " does not match " + text + ".");
                System.out.println();
            }

            if (newSimple.number().equals(number)) {}
            else {
                System.out.print(name + " initialization error: ");
                System.out.println("    " + newSimple.number() + " does not match " + number + ".");
                System.out.println();
            }

            if (newSimple.truth().equals(truth)) {}
            else {
                System.out.print(name + " initialization error: ");
                System.out.println("    " + newSimple.truth() + " does not match " + truth + ".");
                System.out.println();
            }

            newSimple = null;
        }
        catch (Exception e){
            System.out.print("Exception occurred with " + name +".");
            System.out.println("   (Input: [" + text + ", " + number + ", " + truth + ", " + initValsString + ", " + depth + "])");
            System.out.println();
        }
    }

    public static void verifyFlip(boolean oldTruth, boolean newTruth) {
        if(oldTruth != newTruth) {}
        else {
            System.out.println("Simple.flip() did not invert truth value");
            System.out.println("   " + oldTruth + " - before flip");
            System.out.println("   " + newTruth + " - after flip");
            System.out.println();
        }
    }

    public static void verifyToString(String actual, String expected) {
        if (actual.equals(expected)) {}
        else {
            System.out.println("Simple.toString() does not match expected output");
            System.out.println("   " + expected + " - expected");
            System.out.println("   " + actual + " - actual");
            System.out.println();
        }

    }

    public static void verifySequence(Integer[] array, int depth, String expectedOutput) {

        Simple verifySimple = new Simple("", 0, true, array, depth);
        String[] outputArray = expectedOutput.split(",");
        String actualOutput = "[";

        for (int i = 0; i < outputArray.length; i++) {
            actualOutput += verifySimple.nextInSequence();
            if (i < outputArray.length - 1) {
                actualOutput += ", ";
            }
        }
        actualOutput += "]";

        if (actualOutput.equals(expectedOutput)) {}
        else {
            System.out.println("Simple.nextInSequence does not match expected results");
            System.out.println("   " + expectedOutput + " - expected");
            System.out.println("   " + actualOutput + " - actual");
            System.out.println();
        }
    }

    public static void verifyType(Object object, String type, String name) {
        switch (type) {
            case "String":
                if (object.getClass().equals(String.class)) {}
                else {
                    System.out.println(name + " is not a String.");
                }
                break;
            case "Boolean":
                if (object.getClass().equals(Boolean.class)) {}
                else {
                    System.out.println(name + " is not a Boolean.");
                }
                break;
            case "Integer":
                if (object.getClass().equals(Integer.class)) {}
                else {
                    System.out.println(name + " is not an Integer.");
                }
                break;
            case "Number":
                if (object.getClass().equals(Number.class)) {}
                else if (object.getClass().equals(AtomicInteger.class)) {}
                else if (object.getClass().equals(AtomicLong.class)) {}
                else if (object.getClass().equals(BigDecimal.class)) {}
                else if (object.getClass().equals(BigInteger.class)) {}
                else if (object.getClass().equals(Byte.class)) {}
                else if (object.getClass().equals(Double.class)) {}
                else if (object.getClass().equals(DoubleAccumulator.class)) {}
                else if (object.getClass().equals(DoubleAdder.class)) {}
                else if (object.getClass().equals(Float.class)) {}
                else if (object.getClass().equals(Integer.class)) {}
                else if (object.getClass().equals(Long.class)) {}
                else if (object.getClass().equals(LongAccumulator.class)) {}
                else if (object.getClass().equals(LongAdder.class)) {}
                else if (object.getClass().equals(Short.class)) {}
                else System.out.println(name + " is not a Number.");
                break;
        }
    }
}