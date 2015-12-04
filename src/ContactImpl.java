import java.io.Serializable;

public class ContactImpl implements Contact, Serializable {
    private int id;
    private String name;
    private String notes;

    /**
     * Constructor for only id and name of contact.
     *
     * @param id of contact
     * @param name of contact
     */
    public ContactImpl(int id, String name){
        this.id = id;
        this.name = name;
    }

    /**
     * Constructor for id, name and notes for contact.
     *
     * @param id of contact
     * @param name of contact
     * @param note for the contact
     */
    public ContactImpl(int id, String name, String note){
        this.id = id;
        this.name = name;
        this.notes = note;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getNotes() {
        return this.notes;
    }

    @Override
    public void addNotes(String note) {
        this.notes += "\n" + note;
    }

    /**
     * This method will return the contacts full details
     *
     * @return The following contact details, ID, name and if applicable, notes.
     */
    @Override
    public String toString(){
        if(this.getNotes() == null) {
            return "ID: " + this.getId() + "\nName: " + this.getName();
        }
        return "ID: " + this.getId() + "\nName: " + this.getName() + "\nNotes: " + this.getNotes();
    }
}
