import org.junit.Test;

import static org.junit.Assert.*;

public class PersonalDiaryTest {
    @Test
    public void testThatDiaryIsUnLocked(){
    PersonalDiary myDiary = new PersonalDiary("username", "password");
    myDiary.unLockedDiary("password");
    assertFalse(myDiary.isLocked());
    }
    @Test
    public void testThatDiaryIsLocked(){
        PersonalDiary myDiary = new PersonalDiary("username", "password");
        myDiary.unLockedDiary("password");
        assertFalse(myDiary.isLocked());
        myDiary.lockedDiary();
        assertTrue(myDiary.isLocked());
    }
    @Test
    public void testThatDiaryUnlockedWithRightPassword(){
        PersonalDiary myDiary = new PersonalDiary("username", "password");
        myDiary.unLockedDiary("wrongPassword");
        assertTrue(myDiary.isLocked());
    }
    @Test
    public void testThatDiaryCreateAnEntry(){
        PersonalDiary myDiary = new PersonalDiary("username", "password");
        myDiary.createEntry("Title",  "Body");
        assertEquals(1, myDiary.numberOfDiary());
    }
    @Test
    public void testThatDiaryCreateAnEntryWithMoreEntry(){
        PersonalDiary myDiary = new PersonalDiary("username", "password");
        myDiary.createEntry("Title",  "Body");
        assertEquals(1, myDiary.numberOfDiary());
        myDiary.createEntry("Title",  "Body2  ");
        assertEquals(2, myDiary.numberOfDiary());
    }
    @Test
    public void testThatDiaryDeleteAnEntryWithRightPassword(){
        PersonalDiary myDiary = new PersonalDiary("username", "password");
        myDiary.createEntry("Title",  "Body");
        myDiary.createEntry("Title",  "Body2");
        myDiary.unLockedDiary("WrongPassword");
        myDiary.deleteEntry(1);
        assertEquals(2, myDiary.numberOfDiary());
        myDiary.unLockedDiary("password");
        myDiary.deleteEntry(1);
        assertEquals(1, myDiary.numberOfDiary());
    }
    @Test
    public void testThatDiaryDeleteMethodDontTakeInvalidIdentification(){
        PersonalDiary myDiary = new PersonalDiary("username", "password");
        myDiary.createEntry("Title",  "Body");
        myDiary.createEntry("Title",  "Body2");
        myDiary.unLockedDiary("WrongPassword");
        myDiary.deleteEntry(1);
        assertEquals(2, myDiary.numberOfDiary());
        myDiary.unLockedDiary("password");
        myDiary.deleteEntry(1);
        assertEquals(1, myDiary.numberOfDiary());
        myDiary.unLockedDiary("password");
        myDiary.deleteEntry(1);
        assertEquals(1, myDiary.numberOfDiary());
    }
    @Test
    public void testThatDiaryFindEntryWithId(){
        PersonalDiary myDiary = new PersonalDiary("username", "password");
        myDiary.createEntry("Title",  "Body");
        myDiary.createEntry("Title",  "Body2");
        MyEntry expected = new MyEntry(1, "Title", "Body2");
        myDiary.unLockedDiary("password");
        MyEntry result = myDiary.findEntryById(1);
        assertEquals(expected.getId(), result.getId());
        assertEquals(expected.getBody(), result.getBody());
    }
    @Test
    public void testThatDiaryDontFindEntryWithIdWhenItIsLocked(){
        PersonalDiary myDiary = new PersonalDiary("username", "password");
        myDiary.createEntry("Title",  "Body");
        myDiary.createEntry("Title",  "Body2");
        myDiary.unLockedDiary("wrongPassword");
        assertEquals(null, myDiary.findEntryById(1));
    }
    @Test
    public void testThatDiaryDontFindIdNotInEntry(){
        PersonalDiary myDiary = new PersonalDiary("username", "password");
        myDiary.createEntry("Title",  "Body");
        myDiary.createEntry("Title",  "Body2");
        myDiary.unLockedDiary("password");
        MyEntry result = myDiary.findEntryById(2);
        assertEquals(null, result);
    }
    @Test
    public void testThatDiaryUpdateEntry(){
        PersonalDiary myDiary = new PersonalDiary("username", "password");
        myDiary.createEntry("Title",  "Body");
        myDiary.createEntry("Title",  "Body2");
        myDiary.unLockedDiary("password");
        myDiary.updateEntry(1,"Title1", "body");
        myDiary.unLockedDiary("password");
        assertEquals("body", myDiary.findEntryById(1).getBody());
    }

}
