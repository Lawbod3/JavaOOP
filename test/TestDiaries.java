import org.junit.Test;

import static org.junit.Assert.*;

public class TestDiaries {
    @Test
    public void testThatDiariesAreAdded(){
        Diaries diaries = new Diaries();
        diaries.add("username", "password");
        assertEquals(1, diaries.size());
    }
    @Test
    public void testThatDiariesAddMultipleDiary(){
        Diaries diaries = new Diaries();
        diaries.add("username", "password");
        assertEquals(1, diaries.size());
        diaries.add("username2", "password2");
        assertEquals(2, diaries.size());
    }
    @Test
    public void testThatDiariesDontAddSameUsername(){
        Diaries diaries = new Diaries();
        diaries.add("username", "password");
        assertEquals(1, diaries.size());
        diaries.add("username", "password2");
        assertEquals(1, diaries.size());
    }
    @Test
    public void testThatDiariesCanFindUserByUsername(){
        Diaries diaries = new Diaries();
        diaries.add("username", "password");
        assertEquals(1, diaries.size());
        PersonalDiary diaryExist =  diaries.findByUsername("username");
        assertNotNull(diaryExist);
    }
    @Test
    public void testThatDiariesOnlyFindExistingUserByUsername2(){
        Diaries diaries = new Diaries();
        diaries.add("username", "password");
        assertEquals(1, diaries.size());
        PersonalDiary diaryExist =  diaries.findByUsername("username1");
        assertNull(diaryExist);
    }





}
