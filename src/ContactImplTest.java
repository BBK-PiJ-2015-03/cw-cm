/**
 * Testing for ContactImpl
 * Majority of test names will be self explanatory, if need be I will comment.
 */

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class ContactImplTest {
    private ArrayList<Contact> cArray;
    private Contact test1;
    private Contact test2;


    @Before
    public void buildUp(){
        test1 = new ContactImpl("Janis Dole");
        test2 = new ContactImpl("Dean Johnson");
        cArray = new ArrayList<>();
        cArray.add(test1);
        cArray.add(test2);
    }

    @Test
    public void testGetIdActuallyWorks() {
        assertNotNull(test1.getId());
        assertNotNull(test2.getId());
    }

    @Test
    public void testIdUnique() {
        cArray.remove(test1);
        for (Contact c : cArray) {
            assertNotEquals(c.getId(), test1.getId());
        }
        cArray.add(test1);
        cArray.remove(test2);
        for (Contact c : cArray) {
            assertNotEquals(c.getId(), test2.getId());
        }
    }

    @Test
    public void testGetName() {
        assertEquals("Janis Dole", test1.getName());
        assertEquals("Dean Johnson", test2.getName());
    }

    @Test
    public void testGetNotesEmptyThenAddThenTestAgain() {
        assertEquals("", test1.getNotes());
        test1.addNotes("Test Note");
        assertEquals("Test Note", test1.getNotes());

    }

}
