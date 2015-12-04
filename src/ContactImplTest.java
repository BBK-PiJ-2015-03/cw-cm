/**
 * Testing for ContactImpl
 * Majority of test names will be self explanatory, if need be I will comment.
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContactImplTest {
    Contact test1;
    Contact test2;


    @Before
    public void buildUp(){
        test1 = new ContactImpl(17, "John Doe", "Test Note");
        test2 = new ContactImpl(17, "John Doe");
    }

    @Test
    public void testGetId() {
        assertEquals(17, test1.getId());
        assertEquals(17, test2.getId());
    }

    @Test
    public void testGetName() {
        assertEquals("John Doe", test1.getName());
        assertEquals("John Doe", test2.getName());
    }

    @Test
    public void testGetNotes() {
        assertEquals("Test Note", test1.getNotes());
        assertNull(test2.getNotes());

    }

}
