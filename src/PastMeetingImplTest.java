import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Tests for PastMeeting.
 */
public class PastMeetingImplTest {
    private Meeting m;
    private Set<Contact> cSet;
    private Contact test1;
    private Contact test2;
    private Contact test3;
    private Contact test4;

    @Before
    public void setUp(){
        m = new PastMeetingImpl();
        cSet = new HashSet<>();
        test1 = new ContactImpl("Jane Doe");
        test2 = new ContactImpl("John Doe");
        test3 = new ContactImpl("Mark Mane");
        test4 = new ContactImpl("Charles Fitz");
        cSet.add(test1);
        cSet.add(test2);
        cSet.add(test3);
        cSet.add(test4);
    }

    @Test
    public void testGetNotes(){
        assertNull(((PastMeeting)m).getNotes());
    }

    @Test
    public void testGetId() {
        assertEquals(0,m.getId());
    }

    @Test
    public void testGetDate() {
       assertNull(m.getDate());
    }

    @Test
    public void testGetContacts() throws Exception {
        assertNull(m.getContacts());
    }
}