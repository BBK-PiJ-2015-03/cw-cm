import java.util.Calendar;
import java.util.Set;

/**
 * @see Meeting
 */
public class MeetingImpl implements Meeting {
    private int Id;
    private Calendar date;
    private Set<Contact> contacts;


    //Added setters for testing purposes, if useful will keep them.
    //This has solved the testing issue I was having, not sure why will ask Sergio.

    public void setId(int meetingId) {
        this.Id = meetingId;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public void setContacts(Set<Contact> meetingContacts) {
        this.contacts = meetingContacts;
    }

    @Override
    public int getId() {
        return Id;
    }

    @Override
    public Calendar getDate() {
        return date;
    }

    @Override
    public Set<Contact> getContacts() {
        return contacts;
    }
}
