import java.util.ArrayList;

public class Diaries {
    ArrayList<PersonalDiary> diary;
    ArrayList<String> diariesUsername;
    ArrayList<String> diariesPassword;
    public Diaries() {
        this.diary = new ArrayList<>();
        this.diariesUsername = new ArrayList<>();
        this.diariesPassword = new ArrayList<>();
    }
    public void add(String username, String password) {
        boolean isValidUsername = !diariesUsername.contains(username);
        if(isValidUsername)diary.add(new PersonalDiary(username, password));
        if(isValidUsername)diariesUsername.add(username);
        if(isValidUsername)diariesPassword.add(password);
    }
    public int size() {
        return diary.size();
    }
    public PersonalDiary findByUsername(String username) {
        boolean isValidUsername = diariesUsername.contains(username);
        if(isValidUsername)return diary.get(diariesUsername.indexOf(username));
        return null;
    }
    public void delete(String username, String password) {
        boolean isValidOperation = diariesUsername.contains(username)  && diariesPassword.get(diariesUsername.indexOf(username)).equals(password);
        if(isValidOperation)diary.remove(diariesUsername.indexOf(username));
        if(isValidOperation)diariesUsername.remove(username);
        if(isValidOperation)diariesPassword.remove(username);
    }
    public boolean isValidUsername(String username) {
        boolean isValidUsername = !diariesUsername.contains(username);
        if(isValidUsername)return true;
        return false;
    }
}
