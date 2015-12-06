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
    private PastMeetingImpl m;
    private Set<Contact> cSet;
    private Contact test1;
    private Contact test2;

    @Before
    public void setUp(){
        m = new PastMeetingImpl();
        cSet = new HashSet<>();
        test1 = new ContactImpl("Jane Doe");
        test2 = new ContactImpl("John Doe");
        cSet.add(test1);
        cSet.add(test2);
        m.setContacts(cSet);
        m.setDate(Calendar.getInstance());
        m.setId(m.hashCode());
    }

    @Test
    public void testGetNotes(){
        assertEquals("", m.getNotes());
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