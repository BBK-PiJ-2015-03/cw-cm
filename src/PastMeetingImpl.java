import java.util.Calendar;
import java.util.Set;

/**
 * @see PastMeeting & Meeting
 */
public class PastMeetingImpl implements PastMeeting {

    /**
     * @see PastMeeting#getNotes();
     */
    @Override
    public String getNotes() {
        return null;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public Calendar getDate() {
        return null;
    }

    @Override
    public Set<Contact> getContacts() {
        return null;
    }
}
