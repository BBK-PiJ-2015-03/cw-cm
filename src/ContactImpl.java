import java.io.Serializable;
/**
 * @see Contact
 */
public class ContactImpl implements Contact, Serializable {
    //Assuming id & name are immutable fields.
    private int id;
    private String name;
    private String notes = "";
    private static int CUSTOMER_COUNT = 1;

    /**
     * Constructor for a  contact.
     * Creates a unique id for each new contact.
     *
     * @param name of contact
     */
    public ContactImpl(String name){
        this.id = CUSTOMER_COUNT;
        this.name = name;
        CUSTOMER_COUNT++;
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
     * This method will return the contacts full details
     *
     * @return The following contact details, id, name and if applicable, notes.
     */
    @Override
    public String toString(){
        if(this.getNotes().equals("")) {
            return "ID: " + this.getId() + "\nName: " + this.getName();
        }
        return "ID: " + this.getId() + "\nName: " + this.getName() + "\nNotes: " + this.getNotes();
    }
}
