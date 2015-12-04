/**
 * Testing for ContactImpl
 * Majority of test names will be self explanatory, if need be I will comment.
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContactImplTest {
    ContactImpl test1;
    ContactImpl test2;


    @Before
    public void buildUp(){
        test1 = new ContactImpl(17, "John Doe", "Test Note");
        test2 = new ContactImpl(17, "John Doe");
    }

    @Test
    public void testGetId() {
        assertEquals(test1.getId(), 17);
        assertEquals(test2.getId(), 17);
    }

    @Test
    public void testGetName() {
        assertEquals(test1.getName(), "name");
    }

    @Test
    public void testGetNotes() {

        assertEquals(test1.getNotes(), "notes");
    }

}
