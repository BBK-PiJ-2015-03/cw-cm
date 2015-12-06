import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.*;

/**
 * Test for MeetingImpl class
 */
public class MeetingImplTest {
    private Meeting m;
    private Set<Contact> cSet;
    private Contact test1;
    private Contact test2;
    private Contact test3;
    private Contact test4;
    private Contact test5;
    private Contact test6;
    private Contact test7;
    private Contact test8;
    private Contact test9;
    private Contact test10;

    @Before
    public void setUp(){
        cSet = new HashSet<>();
        cSet.add(test1);
        cSet.add(test2);
        cSet.add(test3);
        cSet.add(test4);
        cSet.add(test5);
        cSet.add(test6);
        cSet.add(test7);
        cSet.add(test8);
        cSet.add(test9);
        m = new MeetingImpl(cSet, m.hashCode(), Calendar.getInstance());

    }

    @Test
    public void testGetId() {
        assertEquals(m.hashCode(), m.getId());
    }

    @Test
    public void testGetDate() {
        assertEquals(Calendar.getInstance(), m.getDate());
    }

    @Test
    public void testGetContacts() {
        assertEquals(cSet, m.getContacts());
    }
}