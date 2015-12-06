import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Tests for FutureMeeting.
 */
public class FutureMeetingImplTest {
    private FutureMeeting m;

    @Before
    public void setUp(){
        m = new FutureMeetingImpl();
    }

    @Test
    public void testGetNotes(){
        assertNull(m.getContacts());
    }
}