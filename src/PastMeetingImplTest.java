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
    private PastMeeting m;

    @Before
    public void setUp(){
        m = new PastMeetingImpl();
    }

    @Test
    public void testGetNotes(){
        assertEquals("", m.getNotes());
    }
}