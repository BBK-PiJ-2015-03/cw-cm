/**
 * @see PastMeeting & Meeting
 */
public class PastMeetingImpl extends MeetingImpl implements PastMeeting {
    private String notes = "";
    /**
     * @see PastMeeting#getNotes();
     */
    @Override
    public String getNotes() {
        return this.notes;
    }
}
