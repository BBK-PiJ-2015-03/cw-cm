import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

/**
 * Tests for ContactManagerImpl
 */
public class ContactManagerImplTest {
    private ContactManager cm;
    private Calendar date;
    private Contact contact1;

    @Before
    public void buildUp(){
        cm = new ContactManagerImpl();
        Calendar date = new GregorianCalendar(2014, 12, 22);
        System.out.println(date);
        contact1 = new ContactImpl("Jane Doe");
    }

    @Test
    public void testAddFutureMeeting() {
        assertEquals(0, 0);
    }

    @Test
    public void testGetPastMeeting() {
        assertNull(cm.getPastMeeting(2));
    }

    @Test
    public void testGetFutureMeeting() {
        assertNull(cm.getFutureMeetingList(date));
    }

    @Test
    public void testGetMeeting() {
        assertNull(cm.getMeeting(222));
    }

    @Test
    public void testGetFutureMeetingList() {
        assertNull(cm.getFutureMeetingList(date));
    }

    @Test
    public void testGetFutureMeetingList1() {
        assertNull(cm.getFutureMeetingList(contact1));
    }

    @Test
    public void testGetPastMeetingList() {
        assertNull(cm.getPastMeetingList(contact1));
    }

    @Test
    public void testAddNewPastMeeting() {

    }

    @Test
    public void testAddMeetingNotes() {

    }

    @Test
    public void testAddNewContact() {

    }

    @Test
    public void testGetContactsArray() {
        assertNull(cm.getContacts(21, 21, 32, 323));
    }

    @Test
    public void testGetContactsByName() {
        assertNull(cm.getContacts("Jane Doe"));
    }

    @Test
    public void testFlush() {

    }
}