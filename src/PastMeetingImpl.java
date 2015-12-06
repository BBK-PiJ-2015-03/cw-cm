import java.util.Calendar;
import java.util.Set;

/**
 * @see PastMeeting & Meeting
 */
public class PastMeetingImpl extends MeetingImpl implements PastMeeting {
    /**
     * @see PastMeeting#getNotes();
     */
    @Override
    public String getNotes() {
        return ((this).getNotes());
    }
}
