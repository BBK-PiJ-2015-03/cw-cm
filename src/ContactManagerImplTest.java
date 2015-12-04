import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by J2FX on 04/12/2015.
 */
public class ContactManagerImplTest {
ContactManager cm;

    @Before
    public void buildUp(){
        cm = new ContactManagerImpl();
    }

    @Test
    public void testAddFutureMeeting(){
        assertEquals(0, 0);
    }

    @Test
    public void testGetPastMeeting() throws Exception {
        assertNull(cm);
    }

    @Test
    public void testGetFutureMeeting() throws Exception {
        assertNull(cm);
    }

    @Test
    public void testGetMeeting() throws Exception {
        assertNull(cm);
    }

    @Test
    public void testGetFutureMeetingList() throws Exception {
        assertNull(cm);
    }

    @Test
    public void testGetFutureMeetingList1() throws Exception {
        assertNull(cm);
    }

    @Test
    public void testGetPastMeetingList() throws Exception {
        assertNull(cm);
    }

    @Test
    public void testAddNewPastMeeting() throws Exception {

    }

    @Test
    public void testAddMeetingNotes() throws Exception {

    }

    @Test
    public void testAddNewContact() throws Exception {

    }

    @Test
    public void testGetContactsArray() throws Exception {
        assertNull(cm);
    }

    @Test
    public void testGetContactsByName() throws Exception {
        assertNull(cm);
    }

    @Test
    public void testFlush() throws Exception {

    }
}