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
    private MeetingImpl m;
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
        test1 = new ContactImpl("Jane Doe");
        test2 = new ContactImpl("John Doe");
        test3 = new ContactImpl("Mark Mane");
        test4 = new ContactImpl("Charles Fitz");
        test5 = new ContactImpl("Gemma Simmons");
        test6 = new ContactImpl("Donna Grey");
        test7 = new ContactImpl("Chad Walts");
        test8 = new ContactImpl("King Henry");
        test9 = new ContactImpl("Domminic Salvador");
        test10 = new ContactImpl("Dean Gourski");
        cSet.add(test1);
        cSet.add(test2);
        cSet.add(test3);
        cSet.add(test4);
        cSet.add(test5);
        cSet.add(test6);
        cSet.add(test7);
        cSet.add(test8);
        cSet.add(test9);
        m = new MeetingImpl();
        m.setContacts(cSet);
        m.setDate(Calendar.getInstance());
        m.setId(m.hashCode());
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