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
    public int addFutureMeeting(Set<Contact> contacts, Calendar date) throws NullPointerException, IllegalArgumentException{
        if(contacts == null || date == null){
            throw new NullPointerException("Input cannot be null.");
        }
        if(date.before(todayDate)){
            throw new IllegalArgumentException("Date entered cannot be in the past.");
        }
        contacts.forEach(c -> {
            if(c == null) {
                throw new IllegalArgumentException("Unknown Contact.");
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
        if(this.getMeeting(id) != null && !this.getMeeting(id).getDate().before(todayDate)){
            throw new IllegalArgumentException("The date of this meeting is in the future.");
        }
        return (PastMeeting)this.getMeeting(id);
    }
    /**
     * @see ContactManager#getFutureMeeting(int)
     */
    @Override
    public FutureMeeting getFutureMeeting(int id) throws IllegalArgumentException{
        if(this.getMeeting(id) != null && !this.getMeeting(id).getDate().after(todayDate)){
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
     * @see ContactManager#getFutureMeetingList(Contact)
     */
    @Override
    public List<Meeting> getFutureMeetingList(Contact contact) throws NullPointerException{
        if(contact == null){
            throw new NullPointerException("Contact entered is null.");
        }
        List<Meeting> futureMeetingList = new ArrayList<>();
        for (Meeting m : allMeetings) {
            if(m.getDate().after(todayDate)) {  //Assuming todays meetings are not in the future.
                for (Contact c : m.getContacts()) {
                    if (c.equals(contact)) {
                        futureMeetingList.add(m);
                    }
                }
            }
            if(!futureMeetingList.isEmpty()) {
                Collections.sort(futureMeetingList, (m1, m2) -> m1.getDate().compareTo(m2.getDate()));
            }
        }
        return futureMeetingList;
    }

    /**
     * @see ContactManager#getMeetingListOn(Calendar)
     */
    @Override
    public List<Meeting> getMeetingListOn(Calendar date) throws NullPointerException {
        if(date == null){
            throw new NullPointerException("Date entered is null.");
        }
        List<Meeting> futureMeetingList = new ArrayList<>();
        for (Meeting m : allMeetings) {
            if(m.getDate().equals(date)) {
                futureMeetingList.add(m);
           }
        }
        if(!futureMeetingList.isEmpty()) {
            Collections.sort(futureMeetingList, (m1, m2) -> m1.getDate().compareTo(m2.getDate()));
        }
        return futureMeetingList;
    }

    /**
     * @see ContactManager#getPastMeetingListFor(Contact)
     */
    @Override
    public List<PastMeeting> getPastMeetingListFor(Contact contact) throws NullPointerException, IllegalArgumentException{
        if(contact == null){
            throw new NullPointerException("Contact entered is null.");
        }
        ContactImpl access = new ContactImpl();
        boolean contactExists = false;
        for(Contact cn : access.getAllContacts()){
            if(cn.equals(contact)){
                contactExists = true;
            }
        }
        if(!contactExists){
            throw new IllegalArgumentException("Contact does not exist.");
        }
        List<PastMeeting> pastMeetingList = new ArrayList<>();
        for (Meeting m : allMeetings) {
            if(m.getDate().before(todayDate)) {  //Assuming past meeting are prior to todays date.
                for (Contact c : m.getContacts()) {
                    if (c.equals(contact)) {
                        pastMeetingList.add(((PastMeeting)m));
                    }
                }
            }
            if(!pastMeetingList.isEmpty()) {
                Collections.sort(pastMeetingList, (m1, m2) -> m1.getDate().compareTo(m2.getDate()));
            }
        }
        return pastMeetingList;
    }
    /**
     * @see ContactManager#addNewPastMeeting(Set, Calendar, String)
     */
    @Override
    public void addNewPastMeeting(Set<Contact> contacts, Calendar date, String text) throws NullPointerException, IllegalStateException, IllegalArgumentException{
        if(contacts == null || date == null || text == null){
            throw new NullPointerException("Input cannot be null.");
        }
        if(!date.before(todayDate)){
            throw new IllegalStateException("Date entered must be in the past.");
        }
        contacts.forEach(c -> {
            if(c == null) {
                throw new IllegalArgumentException("Unknown Contact.");
            }
        });
        Meeting meeting = new PastMeetingImpl();
        ((PastMeetingImpl)meeting).setContacts(contacts);
        ((PastMeetingImpl)meeting).setDate(date);
        ((PastMeetingImpl)meeting).setId(meeting.hashCode());
        ((PastMeetingImpl)meeting).setNotes(text);
        allMeetings.add(meeting);
    }
    /**
     * @see ContactManager#addMeetingNotes(int, String)
     */
    @Override
    public PastMeeting addMeetingNotes(int id, String text) throws IllegalArgumentException, IllegalStateException, NullPointerException{
        if(getMeeting(id) == null){
            throw new IllegalArgumentException("Meeting does not exist.");
        }
        if(getMeeting(id).getDate().after(todayDate)){
            throw new IllegalStateException("Meeting cannot be in the future.");
        }
        if(text == null){
            throw new NullPointerException("Notes cannot be null.");
        }
        Meeting meeting = getMeeting(id);
        ((PastMeetingImpl)meeting).setNotes(text);
        return ((PastMeetingImpl)meeting);
    }

    @Override
    public int addNewContact(String name, String notes) {
        if(name == null || notes == null){
            throw new NullPointerException("Parameters cannot be null.");
        }
        if(name.equals("") || notes.equals("")){
            throw new IllegalArgumentException("Parameters cannot be empty strings.");
        }
        Contact newContact = new ContactImpl(name);
        newContact.addNotes(notes);
        return newContact.getId();
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
