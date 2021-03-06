import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.*;

/**
 * Tests for ContactManagerImpl
 */
public class ContactManagerImplTest {
    private ContactManager cm;
    private Calendar futureDate;
    private Calendar futureDate2;
    private Calendar pastDate;
    private Contact contact1;
    private Contact contact2;
    private Set<Contact> cSet;
    private Set<Contact> cSet2;

    @Before
    public void buildUp(){
        cm = new ContactManagerImpl();
        pastDate = new GregorianCalendar(1992,3,19); //For some reason any month entered is incremented by 1.
        futureDate = new GregorianCalendar(2019,11,6); //Maybe this is treated like an array where January is '0' etc...
        futureDate2 = new GregorianCalendar(2017,2,12); //Maybe this is treated like an array where January is '0' etc...
        contact1 = new ContactImpl("Jane Doe");        //*** This has somehow fixed itself - not sure how or why.
        contact2 = new ContactImpl("Mark Pole");
        cSet = new HashSet<>();
        cSet.add(contact1);
        cSet.add(contact2);
        cSet2 = new HashSet<>();
        cSet2.add(contact1);

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

    @Test(expected = NullPointerException.class)
    public void testAddFutureMeetingWithNullDate() {
        cm.addFutureMeeting(cSet, null);
    }

    @Test
    public void testAddFutureMeeting() {
        assertNotNull(cm.addFutureMeeting(cSet,futureDate));
    }

    @Test
    public void testGetPastMeeting() {  //Unless I create a constructor and add the meeting manually I cannot test this.
       // assertNull(cm.getPastMeeting(2)); //Will come back to this later
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetPastMeetingWithFutureDate() {
        int meetingId = cm.addFutureMeeting(cSet, futureDate);
        assertNull(cm.getPastMeeting(meetingId));
    }

    @Test
    public void testGetFutureMeetingListByFutureDate() {
        cm.addFutureMeeting(cSet,futureDate);
        cm.addFutureMeeting(cSet,futureDate);
        assertTrue(cm.getFutureMeetingList(contact1).size() == 2);
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
    public void testGetFutureMeetingListByContact() {
        cm.addFutureMeeting(cSet, futureDate2);
        cm.addFutureMeeting(cSet2, futureDate);
        cm.addFutureMeeting(cSet, futureDate2);
        cm.addFutureMeeting(cSet2, futureDate2);
        cm.addFutureMeeting(cSet, futureDate);
        List<Meeting> tempList = cm.getFutureMeetingList(contact1);
        assertNotNull(cm.getFutureMeetingList(contact1));
    }

    @Test(expected = NullPointerException.class)
    public void testGetPastMeetingListNullPointer() {
        assertNull(cm.getPastMeetingListFor(null));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetPastMeetingListForNonExistingContact() {
        Contact test = new ContactImpl();
        assertNull(cm.getPastMeetingListFor(test));
    }

    @Test
    public void testAddNewPastMeeting() {

    }

    @Test
    public void testAddMeetingNotes() {

    }

    @Test(expected = NullPointerException.class)
    public void testAddNewContactNullPointerException() {
        cm.addNewContact(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNewContactIllegalArgumentException() {
        cm.addNewContact("","");
    }

    @Test
    public void testAddNewContactReturnsAnIdGreaterThan0() {
        assertTrue(cm.addNewContact("Jeremy Kyle", "Prefers latte with no milk.") > 0);
    }

    @Test(expected = NullPointerException.class)
    public void testGetContactsByNameNullPointerException() {
        String name = null;
        cm.getContacts(name);
    }

    @Test
    public void testGetContactsByEmptyStringReturnsFullListOfContacts() {
        ContactImpl accessor = new ContactImpl();
       assertTrue(cm.getContacts("") == accessor.getAllContacts());
    }

    @Test
    public void testGetContactsByString() {
        Contact Jimmy = new ContactImpl("Jimmy Russler");
        assertEquals(cm.getContacts("jim").size(), 1);
        assertEquals(cm.getContacts("Jimmy").size(), 1);
        assertEquals(cm.getContacts("russler").size(), 1);
        assertEquals(cm.getContacts("Russle").size(), 1);
        assertEquals(cm.getContacts("RUSLER").size(), 0);
        assertEquals(cm.getContacts("JIMM").size(), 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetContactsByNonExistingID() {
        cm.getContacts(232, 322);
    }

    @Test
    public void testGetContactsOneContactByExistingID() {
        assertEquals(cm.getContacts(19).size(), 1);
        Contact jone = new ContactImpl("Jonesy Jone");
        int testId = jone.getId();
        assertEquals(cm.getContacts(testId, 19).size(), 2);
    }

    @Test
    public void testFlush() {
        ContactManagerImpl cm = new ContactManagerImpl();
        ContactImpl c1 = new ContactImpl("James Bond");
        ContactImpl c2 = new ContactImpl("Dillion Smila");
        ContactImpl c3 = new ContactImpl("Tilda Mall");
        Set<Contact> cSet = new HashSet<>();
        cSet.add(c1);
        cSet.add(c3);
        Calendar date = new GregorianCalendar(2018,10,1);
        cm.addFutureMeeting(cSet, date);
        System.out.println(c1.getAllContacts());
        System.out.println("****** LINE BREAK ******");
        System.out.println(cm.getAllMeetings().toString());
        System.out.println("****** LINE BREAK ******");
        System.out.println(cm.getContacts("James"));
        cm.flush();

        ContactManagerImpl cm2 = new ContactManagerImpl();
        ContactImpl c10 = new ContactImpl();
        assertTrue(!c10.getAllContacts().isEmpty());
        assertTrue(!cm2.getAllMeetings().isEmpty());
    }
}