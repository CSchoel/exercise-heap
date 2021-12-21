package hashables.test;

import hashables.Interval;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Random;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IntervalTest extends HashableTest {
    private Interval randomInterval() {
        Random r = new Random();
        // intentionally generate some intervals with fixed min and max values
        boolean minFixed = r.nextDouble() > 0.1;
        boolean maxFixed = r.nextDouble() > 0.1;
        return new Interval(
                minFixed ? -Double.MAX_VALUE : r.nextDouble(),
                maxFixed ? Double.MAX_VALUE : r.nextDouble(),
                r.nextBoolean(),
                r.nextBoolean()
        );
    }
    @Test
    public void i01_toString() {
        assertEquals("[0.0, 10.0]", new Interval(0.0, 10.0, false, false).toString());
        assertEquals("(0.0, 10.0]", new Interval(0.0, 10.0, true, false).toString());
        assertEquals("[0.0, 10.0)", new Interval(0.0, 10.0, false, true).toString());
        assertEquals("(0.0, 10.0)", new Interval(0.0, 10.0, true, true).toString());
        assertEquals("[-Infinity, Infinity]", new Interval(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, false, false).toString());
        assertEquals("(0.5, 18.7)", new Interval(0.5, 18.7, true, true).toString());
        assertEquals("[1.0E-20, 1.0E-10)", new Interval(1e-20, 1e-10, false, true).toString());
        assertEquals("[-5.0, -1.23456]", new Interval(-5, -1.23456, false, false).toString());
    }
    @Test
    public void i02_equals() {
        assertShouldEqual(
                new Interval(0, 10, true, true),
                new Interval(0, 10, true, true)
        );
        assertShouldEqual(
                new Interval(0.5, 1.25, true, false),
                new Interval(0.5, 1.25, true, false)
        );
        assertShouldEqual(
                new Interval(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, true, false),
                new Interval(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, true, false)
        );
        assertShouldEqual(
                new Interval(-0.0, 0.5, true, false),
                new Interval(0.0, 0.5, true, false)
        );
        assertShouldEqual(
                new Interval(-0.001, 0.0, true, false),
                new Interval(-0.001, -0.0, true, false)
        );
        assertShouldNotEqual(
                new Interval(-5, 10.5, true, true),
                new Interval(-5, 10.5, true, false)
        );
        assertShouldNotEqual(
                new Interval(-5, 10.5, true, true),
                new Interval(-5, 10.5, false, true)
        );
        assertShouldNotEqual(
                new Interval(-1.23456789, 1.23456789, true, true),
                new Interval(-1.23456789, 1.23456788, true, true)
        );
        assertShouldNotEqual(
                new Interval(-1.23456789, 1.23456789, true, true),
                new Interval(-1.23456788, 1.23456789, true, true)
        );
    }
    @Test
    public void i03_hashCodeFitsEquals() {
        assertHashEquals(
                new Interval(0, 10, true, true),
                new Interval(0, 10, true, true)
        );
        assertHashEquals(
                new Interval(0.5, 1.25, true, false),
                new Interval(0.5, 1.25, true, false)
        );
        assertHashEquals(
                new Interval(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, true, false),
                new Interval(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, true, false)
        );
        assertHashEquals(
                new Interval(-0.0, 0.5, true, false),
                new Interval(0.0, 0.5, true, false)
        );
        assertHashEquals(
                new Interval(-0.001, 0.0, true, false),
                new Interval(-0.001, -0.0, true, false)
        );
    }
    @Test
    public void i04_collisionsAcceptable() {
        testHashCollisions(this::randomInterval, 100000, 100, 10);
    }
    @Test
    public void i05_collisionsOptimal() {
        testHashCollisions(this::randomInterval, 100000, 4, 2);
    }
}
