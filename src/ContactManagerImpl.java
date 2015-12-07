import java.util.*;

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
        if(this.getMeeting(id) != null || !this.getMeeting(id).getDate().before(todayDate)){
            throw new IllegalArgumentException("The date of this meeting is in the future.");
        }
        return (PastMeeting)this.getMeeting(id);
    }
    /**
     * @see ContactManager#getFutureMeeting(int)
     */
    @Override
    public FutureMeeting getFutureMeeting(int id) throws IllegalArgumentException{
        if(this.getMeeting(id) != null || !this.getMeeting(id).getDate().after(todayDate)){
            throw new IllegalArgumentException("The date of this meeting is in the past.");
        }
        return (FutureMeeting)this.getMeeting(id);
    }

    /**
     * @see ContactManager#getMeeting(int)
     */
    @Override
    public Meeting getMeeting(int id) {
        for (Meeting m : allMeetings) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    /**
     * Removes duplicate meeting from a given list
     *
     * @param meetingList any list type of meeting(s)
     * @return the list with any duplicates removed
     */
    public List<Meeting> removeDuplicates(List<Meeting> meetingList){
        Set<Meeting> removeDupe = new HashSet<>();
        removeDupe.addAll(meetingList);
        meetingList.clear();
        meetingList.addAll(removeDupe);
        return meetingList;
    }
    /**
     * @see ContactManager#getFutureMeetingList(Contact)
     */
    @Override
    public List<Meeting> getFutureMeetingList(Contact contact) throws IllegalArgumentException{
        List<Meeting> futureMeetingList = new ArrayList<>();
        for (Meeting m : allMeetings) {
            if(m.getDate().after(todayDate)) {
                for (Contact c : m.getContacts()) {
                    if (c.equals(contact)) {
                        futureMeetingList.add(m);
                    }
                }
            }
            if(!futureMeetingList.isEmpty()) {
                Collections.sort(futureMeetingList, (m1, m2) -> m1.getDate().compareTo(m2.getDate()));
                return removeDuplicates(futureMeetingList);
            }
        }
        return futureMeetingList;
    }

    /**
     * @see ContactManager#getFutureMeetingList(Calendar)
     */
    @Override
    public List<Meeting> getFutureMeetingList(Calendar date) {
        List<Meeting> futureMeetingList = new ArrayList<>();
        if(date.before(todayDate)){
            return futureMeetingList;  //JavaDoc did not specify if past dates should be returned, I will assume not.
        }
        for (Meeting m : allMeetings) {
            if(m.getDate().equals(date)) {
                for (Contact c : m.getContacts()) {
                    futureMeetingList.add(m);
                }
            }
        }
        if(!futureMeetingList.isEmpty()) {
            Collections.sort(futureMeetingList, (m1, m2) -> m1.getDate().compareTo(m2.getDate()));
            return removeDuplicates(futureMeetingList);
        }
        return futureMeetingList;
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
