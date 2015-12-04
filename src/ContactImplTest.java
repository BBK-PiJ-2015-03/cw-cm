/**
 * Testing for ContactImpl
 * Majority of test names will be self explanatory, if need be I will comment.
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContactImplTest {
ContactImpl test;

    @Before
    public void buildUp(){
        test = new ContactImpl();
    }

    @Test
    public void testGetId() {
        assertEquals(test.getId(), 0);
    }

    @Test
    public void testGetName() {
        assertEquals(test.getName(), "name");
    }

    @Test
    public void testGetNotes() {
        assertEquals(test.getNotes(), "notes");
    }

}
