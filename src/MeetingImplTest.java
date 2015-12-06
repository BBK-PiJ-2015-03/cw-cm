import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for MeetingImpl class
 */
public class MeetingImplTest {
    private Meeting m;
    @Before
    public void setUp(){
        m = new MeetingImpl();
    }

    @Test
    public void testGetId() {
        assertEquals(0, 0);
    }

    @Test
    public void testGetDate() {
        assertNull(m.getDate());
    }

    @Test
    public void testGetContacts() {
        assertNull(m.getContacts());
    }
}