import java.io.Serializable;

public class ContactImpl implements Contact, Serializable {

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getName() {
        return "name";
    }

    @Override
    public String getNotes() {
        return "notes";
    }

    @Override
    public void addNotes(String note) {
    }
}
