import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Tests for Simple class.
 *
 * @author Dr. Jody Paul
 * @version Fall 2018 1.2.0
 */
public class SimpleTest {
    @Test
    public void textStatus() {
        Simple simple0 = new Simple("Some TEXT", 0, true, new Integer[]{}, 0);
        assertThat(simple0.text(), is("Some TEXT"));
    }

    @Test
    public void numericIntStatus() {
        Simple simple0 = new Simple("More TEXT", 42, true, new Integer[]{}, 0);
        assertThat(simple0.number(), is(42));
    }

    @Test
    public void numericIntegerStatus() {
        Integer myInteger = Integer.valueOf(9182734);
        Simple simple0 = new Simple("More TEXT",
                myInteger,
                true,
                new Integer[]{}, 0);
        assertThat(simple0.number().intValue(), is(myInteger.intValue()));
    }

    @Test
    public void numericDoubleStatus() {
        Simple simple0 = new Simple("More TEXT", 42.000975, true, new Integer[]{}, 0);
        assertThat(simple0.number(), is(42.000975));
    }

    @Test
    public void logicStatus() {
        Simple simple0 = new Simple("TEXT", 42, true, new Integer[]{}, 0);
        assertThat(simple0.truth(), is(true));
        Simple simple1 = new Simple("Other TEXT", 42, false, new Integer[]{}, 0);
        assertThat(simple1.truth(), is(false));
    }

    @Test
    public void flipTest() {
        Simple simple0 = new Simple("TXT", 42, true, new Integer[]{}, 0);
        assertThat(simple0.truth(), is(true));
        simple0.flip();
        assertThat(simple0.truth(), is(false));
        simple0.flip();
        assertThat(simple0.truth(), is(true));
    }

    @Test
    public void arbitrarySequence() {
        Simple simple0 = new Simple();
        assertThat(simple0.nextInSequence(), notNullValue());
    }

    @Test
    public void depthZeroSequences() {
        Simple simple0 = new Simple("A", 0, true, new Integer[]{}, 0);
        for (int i = 0; i < 100; i++) {
            assertThat(simple0.nextInSequence(), is(0));
        }
        simple0 = new Simple("A", 1, true, new Integer[]{0, 0, 0}, 0);
        for (int i = 0; i < 100; i++) {
            assertThat(simple0.nextInSequence(), is(0));
        }
        simple0 = new Simple("A", 2, true, new Integer[]{42, -3, 86}, 0);
        assertThat(simple0.nextInSequence(), is(42));
        assertThat(simple0.nextInSequence(), is(-3));
        assertThat(simple0.nextInSequence(), is(86));
        for (int i = 0; i < 100; i++) {
            assertThat(simple0.nextInSequence(), is(0));
        }
    }

    @Test
    public void depthOneSequences() {
        Simple simple1 = new Simple("B", 0, true, new Integer[]{42}, 1);
        for (int i = 0; i < 100; i++) {
            assertThat(simple1.nextInSequence(), is(42));
        }
        simple1 = new Simple("B", 1, true, new Integer[]{42, -3, 86}, 1);
        assertThat(simple1.nextInSequence(), is(42));
        assertThat(simple1.nextInSequence(), is(-3));
        for (int i = 0; i < 100; i++) {
            assertThat(simple1.nextInSequence(), is(86));
        }
    }

    @Test
    public void depthTwoSequences() {
        Simple simple2 = new Simple("C", 0, true, new Integer[]{1, 1}, 2);
        assertThat(simple2.nextInSequence(), is(1));
        assertThat(simple2.nextInSequence(), is(1));
        for (int i = 1, j = 1, k = 1, t = 0; i < 100; i++) {
            t = j + k;
            j = k;
            k = t;
            assertThat(simple2.nextInSequence(), is(k));
        }
        simple2 = new Simple("C", 1, true, new Integer[]{42, -3, 0}, 2);
        assertThat(simple2.nextInSequence(), is(42));
        assertThat(simple2.nextInSequence(), is(-3));
        assertThat(simple2.nextInSequence(), is(0));
        assertThat(simple2.nextInSequence(), is(-3));
        for (int i = 1, j = 0, k = -3, t = 0; i < 100; i++) {
            t = j + k;
            j = k;
            k = t;
            assertThat(simple2.nextInSequence(), is(k));
        }
    }

    @Test
    public void depthThreeSequences() {
        Simple simple3 = new Simple("D", 0, true, new Integer[]{0, 1, 2}, 3);
        assertThat(simple3.nextInSequence(), is(0));
        assertThat(simple3.nextInSequence(), is(1));
        assertThat(simple3.nextInSequence(), is(2));
        for (int i = 1, j = 0, k = 1, m = 2, t = 0; i < 100; i++) {
            t = j + k + m;
            j = k;
            k = m;
            m = t;
            assertThat(simple3.nextInSequence(), is(m));
        }
        simple3 = new Simple("D", 1, true, new Integer[]{42, -3, 0}, 3);
        assertThat(simple3.nextInSequence(), is(42));
        assertThat(simple3.nextInSequence(), is(-3));
        assertThat(simple3.nextInSequence(), is(0));
        assertThat(simple3.nextInSequence(), is(39));
        assertThat(simple3.nextInSequence(), is(36));
        assertThat(simple3.nextInSequence(), is(75));
        assertThat(simple3.nextInSequence(), is(150));
        assertThat(simple3.nextInSequence(), is(261));
    }

    @Test
    public void depthFourSequences() {
        Simple simple4 = new Simple("E", 4, true, new Integer[]{-1, 0, 1, 2}, 4);
        assertThat(simple4.nextInSequence(), is(-1));
        assertThat(simple4.nextInSequence(), is(0));
        assertThat(simple4.nextInSequence(), is(1));
        assertThat(simple4.nextInSequence(), is(2));
        for (int i = 1, j = -1, k = 0, m = 1, n = 2, t = 0; i < 100; i++) {
            t = j + k + m + n;
            j = k;
            k = m;
            m = n;
            n = t;
            assertThat(simple4.nextInSequence(), is(n));
        }
        simple4 = new Simple("E", 1, true, new Integer[]{42, -3, 0, 1}, 4);
        assertThat(simple4.nextInSequence(), is(42));
        assertThat(simple4.nextInSequence(), is(-3));
        assertThat(simple4.nextInSequence(), is(0));
        assertThat(simple4.nextInSequence(), is(1));
        assertThat(simple4.nextInSequence(), is(40));
        assertThat(simple4.nextInSequence(), is(38));
        assertThat(simple4.nextInSequence(), is(79));
        assertThat(simple4.nextInSequence(), is(158));
        assertThat(simple4.nextInSequence(), is(315));
    }

    @Test
    public void wrapAroundSequences() {
        Simple simpleNeg = new Simple("F", 0, true, new Integer[]{Integer.MIN_VALUE, -1}, 2);
        assertThat(simpleNeg.nextInSequence(), is(Integer.MIN_VALUE));
        assertThat(simpleNeg.nextInSequence(), is(-1));
        for (int i = 1, j = Integer.MIN_VALUE, k = -1, t = 0; i < 1000000; i++) {
            t = j + k;
            j = k;
            k = t;
            assertThat(simpleNeg.nextInSequence(), is(k));
        }
        Simple simplePos = new Simple("F", 0, true, new Integer[]{Integer.MAX_VALUE, 2}, 2);
        assertThat(simplePos.nextInSequence(), is(Integer.MAX_VALUE));
        assertThat(simplePos.nextInSequence(), is(2));
        for (int i = 1, j = Integer.MAX_VALUE, k = 2, t = 0; i < 1000000; i++) {
            t = j + k;
            j = k;
            k = t;
            assertThat(simplePos.nextInSequence(), is(k));
        }
    }

    @Test
    public void toStringTest() {
        Simple simpleStr = new Simple("Expected Text",
                42,
                true,
                new Integer[]{Integer.MIN_VALUE, -1},
                2);
        assertThat(simpleStr.toString(), is("Simple[true, 42, \"Expected Text\"]"));
    }
}
