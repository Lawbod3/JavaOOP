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
        myDiary.createEntry("Title",  "body");
        assertEquals(1, myDiary.numberOfEntry());

    }


}
