import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @see Contact
 */
public class ContactImpl implements Contact, Serializable {
    //Assuming id & name are immutable fields.
    private final int id;
    private final String name;
    private String notes = "";
    private static int CONTACT_COUNT = 0;
    private static Set<Contact> allContacts = new HashSet<>();

    /**
     * Empty constructor needed for some testing / methods.
     * does not increment contact count or add contact to list.
     *
     * @param name of contact
     */
    public ContactImpl(){
        super();
        this.name = "Test";
        this.id = 007;
    }
    /**
     * Constructor for a  contact.
     * Creates a unique id for each new contact.
     *
     * @param name of contact
     */
    public ContactImpl(String name){
        this.id = CONTACT_COUNT+1;
        this.name = name;
        allContacts.add(this);
        CONTACT_COUNT++;
    }
    /**
     * @see Contact#getId()
     */
    @Override
    public int getId() {
        return this.id;
    }
    /**
     * @see Contact#getName()
     */
    @Override
    public String getName() {
        return this.name;
    }
    /**
     * @see Contact#getNotes()
     */
    @Override
    public String getNotes() {
        return this.notes;
    }
    /**
     * @see Contact#addNotes(String)
     */
    @Override
    public void addNotes(String note) {
        if(!this.getNotes().equals("")) {
            this.notes += "\n" + note;
        } else {
            this.notes = note;
        }
    }
    /**
     * Get details of all contacts
     * @return a set of all contacts that have been registered
     */
    public Set<Contact> getAllContacts(){
        return allContacts;
    }
    /**
     * Save set of all contacts
     * @param set of contacts to be saved
     */
    public void setAllContacts(List<Contact> newContacts){
        this.allContacts.addAll(newContacts);
    }

    /**
     * This method will return the contacts full details
     *
     * @return The following contact details, id, name and if applicable, notes.
     */
    @Override
    public String toString(){
        if(this.getNotes().equals("")) {
            return "\nID: " + this.getId() + "\nName: " + this.getName();
        }
        return "\nID: " + this.getId() + "\nName: " + this.getName() + "\nNotes: " + this.getNotes();
    }
}
