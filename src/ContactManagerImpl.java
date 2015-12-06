import java.util.Calendar;
import java.util.List;
import java.util.Set;

/**
 * @see ContactManager
 */
public class ContactManagerImpl implements ContactManager{
    private Calendar todayDate = Calendar.getInstance();
    /**
     * Add a new meeting to be held in the future.
     *
     * @param contacts a list of contacts that will participate in the meeting
     * @param date the date on which the meeting will take place
     * @return the ID for the meeting
     * @throws IllegalArgumentException if the meeting is set for a time in the past,
     * of if any contact is unknown / non-existent
     */
    @Override
    public int addFutureMeeting(Set<Contact> contacts, Calendar date) throws IllegalArgumentException{
        if(date.before(todayDate)){
            throw new IllegalArgumentException("Date entered cannot be in the past.");
        }
        contacts.forEach(c -> {
            if(c.getName() == null) {
                throw new IllegalArgumentException("Unknown Contact");
            }
        });
        MeetingImpl newFutureMeeting = new FutureMeetingImpl();
        newFutureMeeting.setContacts(contacts);
        newFutureMeeting.setDate(date);
        newFutureMeeting.setId(newFutureMeeting.hashCode());
        return newFutureMeeting.getId();

    }

    @Override
    public PastMeeting getPastMeeting(int id) {
        return null;
    }

    @Override
    public FutureMeeting getFutureMeeting(int id) {
        return null;
    }

    @Override
    public Meeting getMeeting(int id) {
        return null;
    }

    @Override
    public List<Meeting> getFutureMeetingList(Contact contact) {
        return null;
    }

    @Override
    public List<Meeting> getFutureMeetingList(Calendar date) {
        return null;
    }

    @Override
    public List<PastMeeting> getPastMeetingList(Contact contact) {
        return null;
    }

    @Override
    public void addNewPastMeeting(Set<Contact> contacts, Calendar date, String text) {

    }

    @Override
    public void addMeetingNotes(int id, String text) {

    }

    @Override
    public void addNewContact(String name, String notes) {

    }

    @Override
    public Set<Contact> getContacts(int... ids) {
        return null;
    }

    @Override
    public Set<Contact> getContacts(String name) {
        return null;
    }

    @Override
    public void flush() {

    }
}
