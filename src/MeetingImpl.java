import java.util.Calendar;
import java.util.Set;

/**
 * @see Meeting
 */
public class MeetingImpl implements Meeting {
    private int meetingId;
    private Calendar date;
    private Set<Contact> meetingContacts;

    /**
     * Added this constructor for testing purposes, might keep if it will be useful.
     * @param set of contacts that will be participating in the meeting
     * @param meeting ID of the meeting
     * @param date of the meeting
     */
    public MeetingImpl(Set<Contact> newContacts, int id, Calendar date) {
        this.meetingContacts =  newContacts;
        this.meetingId = this.hashCode();
        this.date = date;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public Calendar getDate() {
        return date;
    }

    @Override
    public Set<Contact> getContacts() {
        return meetingContacts;
    }
}
