import java.util.ArrayList;

public class Diaries {
    ArrayList<PersonalDiary> diary;
    ArrayList<String> diariesUsername;
    public Diaries() {
        this.diary = new ArrayList<>();
        this.diariesUsername = new ArrayList<>();
    }
    public void add(String username, String password) {
        boolean isValidUsername = !diariesUsername.contains(username);
        if(isValidUsername)diary.add(new PersonalDiary(username, password));
        if(isValidUsername)diariesUsername.add(username);
    }
    public int size() {
        return diary.size();
    }
    public PersonalDiary findByUsername(String username) {
        int userIndex = 0;
        boolean isValidUsername = !diariesUsername.contains(username);
        if(isValidUsername)userIndex =diariesUsername.indexOf(username);
        if(isValidUsername)return diary.get(userIndex);
        return null;
    }
}
