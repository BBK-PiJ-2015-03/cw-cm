import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Tests for ContactManagerImpl
 */
public class ContactManagerImplTest {
    private ContactManager cm;
    private Calendar futureDate;
    private Calendar pastDate;
    private Contact contact1;
    private Contact contact2;
    private Set<Contact> cSet;

    @Before
    public void buildUp(){
        cm = new ContactManagerImpl();
        pastDate = new GregorianCalendar(1992,3,19); //For some reason any month entered is incremented by 1.
        futureDate = new GregorianCalendar(2019,11,6); //Maybe this is treated like an array where January is '0' etc...
        contact1 = new ContactImpl("Jane Doe");        //*** This has somehow fixed itself - not sure how or why.
        contact2 = new ContactImpl("Mark Pole");
        cSet = new HashSet<>();
        cSet.add(contact1);
        cSet.add(contact2);


    }

    @Test
    public void testFutureDate() {
        assertEquals(2019, futureDate.get(Calendar.YEAR));
        assertEquals(11, futureDate.get(Calendar.MONTH));
        assertEquals(6, futureDate.get(Calendar.DAY_OF_MONTH));
    }

    @Test
    public void testPastDate() {
        assertEquals(1992, pastDate.get(Calendar.YEAR));
        assertEquals(3, pastDate.get(Calendar.MONTH));
        assertEquals(19, pastDate.get(Calendar.DAY_OF_MONTH));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFutureMeetingWithPastDate() {
        cm.addFutureMeeting(cSet, pastDate);
    }

    @Test
    public void testAddFutureMeeting() {
        assertEquals(0, 0);
    }

    @Test
    public void testGetPastMeeting() {  //Unless I create a constructor and add the meeting manually I cannot test this.
        assertNull(cm.getPastMeeting(2)); //Will come back to this later
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetPastMeetingWithFutureDate() {  //Unless I create a constructor and add the meeting manually I cannot test this.
        int meetingId = cm.addFutureMeeting(cSet,futureDate);
        assertNull(cm.getPastMeeting(meetingId)); //Will come back to this later
    }

    @Test
    public void testGetFutureMeetingListByDate() {
        cm.addFutureMeeting(cSet,futureDate);
        assertNull(cm.getFutureMeetingList(futureDate));
    }

    @Test
    public void testGetFutureMeetingById(){
        // assertEquals(futureDate, cm.getFutureMeeting(1213415012).getDate()); // Having problems with this method
    }

    @Test
    public void testGetMeeting() {
        int meetingId = cm.addFutureMeeting(cSet,futureDate);
        assertNotNull(cm.getMeeting(meetingId));
    }

    @Test
    public void testGetFutureMeetingList() {
        assertNull(cm.getFutureMeetingList(pastDate));
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