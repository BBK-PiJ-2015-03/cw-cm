/**
 * Testing for ContactImpl
 * Majority of test names will be self explanatory, if need be I will comment.
 */

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class ContactImplTest {
    ArrayList<Contact> cArray;
    Contact test1;
    Contact test2;
    Contact test3;
    Contact test4;
    Contact test5;
    Contact test6;
    Contact test7;
    Contact test8;
    Contact test9;
    Contact test10;


    @Before
    public void buildUp(){
        test1 = new ContactImpl("Jane Doe");
        test2 = new ContactImpl("John Doe");
        test3 = new ContactImpl("Mark Mane");
        test4 = new ContactImpl("Charles Fitz");
        test5 = new ContactImpl("Gemma Simmons");
        test6 = new ContactImpl("Donna Grey");
        test7 = new ContactImpl("Chad Walts");
        test8 = new ContactImpl("King Henry");
        test9 = new ContactImpl("Domminic Salvador");
        test10 = new ContactImpl("Dean Gourski");
        cArray = new ArrayList<>();
        cArray.add(test1);
        cArray.add(test2);
        cArray.add(test3);
        cArray.add(test4);
        cArray.add(test5);
        cArray.add(test6);
        cArray.add(test7);
        cArray.add(test8);
        cArray.add(test9);
        cArray.add(test10);
    }

    @Test
    public void testGetIdActuallyUsesHashcode() {
        assertEquals(test1.hashCode(), test1.getId());
        assertEquals(test2.hashCode(), test2.getId());
        assertEquals(test3.hashCode(), test3.getId());
        assertEquals(test4.hashCode(), test4.getId());
        assertEquals(test5.hashCode(), test5.getId());
        assertEquals(test6.hashCode(), test6.getId());
        assertEquals(test7.hashCode(), test7.getId());
        assertEquals(test8.hashCode(), test8.getId());
        assertEquals(test9.hashCode(), test9.getId());
        assertEquals(test10.hashCode(), test10.getId());
    }

    @Test
    public void testIdUnique() {
        cArray.remove(test1);
        for (Contact c : cArray){
            assertNotEquals(c.getId(), test1.getId());
        }
        cArray.add(test1);
        cArray.remove(test2);
        for (Contact c : cArray){
            assertNotEquals(c.getId(), test2.getId());
        }
        cArray.add(test2);
        cArray.remove(test3);
        for (Contact c : cArray){
            assertNotEquals(c.getId(), test3.getId());
        }
        cArray.add(test3);
        cArray.remove(test4);
        for (Contact c : cArray){
            assertNotEquals(c.getId(), test4.getId());
        }
        cArray.add(test4);
        cArray.remove(test5);
        for (Contact c : cArray){
            assertNotEquals(c.getId(), test5.getId());
        }
        cArray.add(test5);
        cArray.remove(test6);
        for (Contact c : cArray){
            assertNotEquals(c.getId(), test6.getId());
        }
        cArray.add(test6);
        cArray.remove(test7);
        for (Contact c : cArray){
            assertNotEquals(c.getId(), test7.getId());
        }
        cArray.add(test7);
        cArray.remove(test8);
        for (Contact c : cArray){
            assertNotEquals(c.getId(), test8.getId());
        }
        cArray.add(test8);
        cArray.remove(test9);
        for (Contact c : cArray){
            assertNotEquals(c.getId(), test9.getId());
        }
        cArray.add(test9);
        cArray.remove(test10);
        for (Contact c : cArray){
            assertNotEquals(c.getId(), test10.getId());
        }
        cArray.add(test10);
    }

    @Test
    public void testGetName() {
        assertEquals("Jane Doe", test1.getName());
        assertEquals("John Doe", test2.getName());
    }

    @Test
    public void testGetNotesEmptyThenAddThenTestAgain() {
        assertEquals("", test1.getNotes());
        test1.addNotes("Test Note");
        assertEquals("Test Note", test1.getNotes());

    }

}
