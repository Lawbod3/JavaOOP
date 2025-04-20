import org.junit.Test;

import static org.junit.Assert.*;

public class PersonalDiaryTest {
    @Test
    public void testThatDiaryIsUnLocked(){
    PersonalDiary myDiary = new PersonalDiary("username", "password");
    myDiary.unlockDiary("password");
    assertFalse(myDiary.isLocked());
    }
    @Test
    public void testThatDiaryIsLocked(){
        PersonalDiary myDiary = new PersonalDiary("username", "password");
        myDiary.unlockDiary("password");
        assertFalse(myDiary.isLocked());
        myDiary.lockDiary();
        assertTrue(myDiary.isLocked());
    }
    @Test
    public void testThatDiaryUnlockedWithRightPassword(){
        PersonalDiary myDiary = new PersonalDiary("username", "password");
        myDiary.unlockDiary("wrongPassword");
        assertTrue(myDiary.isLocked());
    }
    @Test
    public void testThatDiaryCreateAnEntry(){
        PersonalDiary myDiary = new PersonalDiary("username", "password");
        myDiary.unlockDiary("password");
        myDiary.createEntry("Title",  "Body");
        assertEquals(1, myDiary.numberOfEntries());
    }
    @Test
    public void testThatDiaryCreateAnEntryWithMoreEntry(){
        PersonalDiary myDiary = new PersonalDiary("username", "password");
        myDiary.unlockDiary("password");
        myDiary.createEntry("Title",  "Body");
        assertEquals(1, myDiary.numberOfEntries());
        myDiary.unlockDiary("password");
        myDiary.createEntry("Title",  "Body2  ");
        assertEquals(2, myDiary.numberOfEntries());
    }
    @Test
    public void testThatDiaryDeleteAnEntryWithRightPassword(){
        PersonalDiary myDiary = new PersonalDiary("username", "password");
        myDiary.unlockDiary("password");
        myDiary.createEntry("Title",  "Body");
        myDiary.unlockDiary("password");
        myDiary.createEntry("Title",  "Body2");
        myDiary.unlockDiary("WrongPassword");
        myDiary.deleteEntry(1);
        assertEquals(2, myDiary.numberOfEntries());
        myDiary.unlockDiary("password");
        myDiary.deleteEntry(1);
        assertEquals(1, myDiary.numberOfEntries());
    }
    @Test
    public void testThatDiaryDeleteMethodDontTakeInvalidIdentification(){
        PersonalDiary myDiary = new PersonalDiary("username", "password");
        myDiary.unlockDiary("password");
        myDiary.createEntry("Title",  "Body");
        myDiary.unlockDiary("password");
        myDiary.createEntry("Title",  "Body2");
        myDiary.unlockDiary("WrongPassword");
        myDiary.deleteEntry(1);
        assertEquals(2, myDiary.numberOfEntries());
        myDiary.unlockDiary("password");
        myDiary.deleteEntry(1);
        assertEquals(1, myDiary.numberOfEntries());
        myDiary.unlockDiary("password");
        myDiary.deleteEntry(1);
        assertEquals(1, myDiary.numberOfEntries());
    }
    @Test
    public void testThatDiaryFindEntryWithId(){
        PersonalDiary myDiary = new PersonalDiary("username", "password");
        myDiary.unlockDiary("password");
        myDiary.createEntry("Title",  "Body");
        myDiary.unlockDiary("password");
        myDiary.createEntry("Title",  "Body2");
        MyEntry expected = new MyEntry(1, "Title", "Body2");
        myDiary.unlockDiary("password");
        MyEntry result = myDiary.findEntryById(1);
        assertEquals(expected.getIdentification(), result.getIdentification());
        assertEquals(expected.getBody(), result.getBody());
    }
    @Test
    public void testThatDiaryDontFindEntryWithIdWhenItIsLocked(){
        PersonalDiary myDiary = new PersonalDiary("username", "password");
        myDiary.unlockDiary("password");
        myDiary.createEntry("Title",  "Body");
        myDiary.unlockDiary("password");
        myDiary.createEntry("Title",  "Body2");
        myDiary.unlockDiary("wrongPassword");
        assertEquals(null, myDiary.findEntryById(1));
    }
    @Test
    public void testThatDiaryDontFindIdNotInEntry(){
        PersonalDiary myDiary = new PersonalDiary("username", "password");
        myDiary.unlockDiary("password");
        myDiary.createEntry("Title",  "Body");
        myDiary.unlockDiary("password");
        myDiary.createEntry("Title",  "Body2");
        myDiary.unlockDiary("password");
        MyEntry result = myDiary.findEntryById(2);
        assertEquals(null, result);
    }
    @Test
    public void testThatDiaryUpdateEntry(){
        PersonalDiary myDiary = new PersonalDiary("username", "password");
        myDiary.unlockDiary("password");
        myDiary.createEntry("Title",  "Body");
        myDiary.unlockDiary("password");
        myDiary.createEntry("Title",  "Body2");
        myDiary.unlockDiary("password");
        myDiary.updateEntry(1,"Title1", "body");
        myDiary.unlockDiary("password");
        assertEquals("body", myDiary.findEntryById(1).getBody());
    }
    @Test
    public void testThatDiaryUpdateEntryDontTakeInvalidIdentification(){
        PersonalDiary myDiary = new PersonalDiary("username", "password");
        myDiary.unlockDiary("password");
        myDiary.createEntry("Title",  "Body");
        myDiary.unlockDiary("password");
        myDiary.createEntry("Title",  "Body2");
        myDiary.unlockDiary("password");
        myDiary.updateEntry(2,"Title1", "body");
        myDiary.unlockDiary("password");
        assertEquals(null, myDiary.findEntryById(2));
    }

}
