/**
 * Testing for ContactImpl
 * Majority of test names will be self explanatory, if need be I will comment.
 */

import org.junit.Before;
import org.junit.BeforeClass;
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
        assertEquals(test.getId(), 1);
    }

    @Test
    public void testGetName() {
        assertEquals(test.getName(), "1");
    }

    @Test
    public void testGetNotes() {
        assertEquals(test.getNotes(), "1");
    }

}
