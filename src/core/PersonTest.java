package core;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Simple example of using equals and hashCode method
 * @author Prashant Kumar
 */
public class PersonTest {

    @Test
    public void testEquals() {
        Person james = new Person(21, "James", 34, new Date(1980, Calendar.DECEMBER, 1));
        Person same = new Person(14, "James", 45, new Date(1980,Calendar.DECEMBER, 1));
        Person similar = new Person(23, "Harry", 21, new Date(1981,Calendar.DECEMBER,1));

        assertEquals(james, same);
        assertEquals(james.hashCode(), same.hashCode());

        assertNotEquals(null, james);
        assertNotEquals(james, similar);
        assertTrue(james.hashCode() != similar.hashCode());
    }

}