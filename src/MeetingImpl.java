import java.util.Calendar;
import java.util.Set;

/**
 * @see Meeting
 */
public class MeetingImpl implements Meeting {
    private final int Id;
    private Calendar date;
    private Set<Contact> contacts;
    private static int MEETING_COUNT = 0;


    public MeetingImpl(Set<Contact> c, Calendar d){
        this.date = d;
        this.contacts = c;
        this.Id = MEETING_COUNT+1;
        MEETING_COUNT++;
    }

    public MeetingImpl(){
        super();
        this.Id = MEETING_COUNT+1;
        MEETING_COUNT++;
    }

    //Added setters for testing purposes, if useful will keep them.
    //This has solved the testing issue I was having, not sure why will ask Sergio.

    public void setId(int meetingId) {
        //this.Id = meetingId;
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

    @Override
    public String toString(){
        String printDate = date.get(Calendar.DAY_OF_MONTH) + "/" + date.get(Calendar.MONTH) + "/" + date.get(Calendar.YEAR);
        return "\nMeeting ID: " + this.getId() + "\nDate:  " + printDate +  "\n== Contact List ==" + this.contacts;
    }
}
