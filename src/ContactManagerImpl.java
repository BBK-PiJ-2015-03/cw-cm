import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @see ContactManager
 */
public class ContactManagerImpl implements ContactManager{
    private Calendar todayDate = Calendar.getInstance();
    private Set<Meeting> allMeetings = new HashSet<>();
    /**
     * @see ContactManager#addFutureMeeting(Set, Calendar)
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
        Meeting meeting = new FutureMeetingImpl();
        ((FutureMeetingImpl)meeting).setContacts(contacts);
        ((FutureMeetingImpl)meeting).setDate(date);
        ((FutureMeetingImpl)meeting).setId(meeting.hashCode());
        allMeetings.add(meeting);
        return meeting.getId();
    }
    /**
     * @see ContactManager#getPastMeeting(int)
     */
    @Override
    public PastMeeting getPastMeeting(int id) throws IllegalArgumentException{
        for (Meeting m : allMeetings) {  //Double check this loop
            System.out.println(m.getId());
            if(m.getId() == id){
                if(m.getDate().after(todayDate)){
                    throw new IllegalArgumentException("The date of this meeting is in the future.");
                }
                return ((PastMeetingImpl)m);
            }
        }
        return null;
    }
    /**
     * Returns the FUTURE meeting with the requested ID, or null if there is none.
     *
     * @param id the ID for the meeting
     * @return the meeting with the requested ID, or null if it there is none.
     * @throws IllegalArgumentException if there is a meeting with that ID happening in the past
     */
    @Override
    public FutureMeeting getFutureMeeting(int id) throws IllegalArgumentException{
        for (Meeting m : allMeetings) {  //Double check this loop
            System.out.println(m.getId());
            if(m.getId() == id){
                if(m.getDate().before(todayDate)){
                    throw new IllegalArgumentException("The date of this meeting is in the past.");
                }
                return ((FutureMeetingImpl)m);
            }
        }
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
