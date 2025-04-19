import javax.swing.*;
import java.util.ArrayList;

public class PersonalDiary {
    private String password;
    private boolean isLocked = true;
    private ArrayList<MyEntry> entries;

    public PersonalDiary(String username, String password) {
        this.password = password;
        entries = new ArrayList<>();
    }
    public void unlockDiary(String password) {
        boolean isValidUser = this.password.equals(password);
        if (isValidUser) isLocked = false;
    }
    public boolean isLocked() {
        return isLocked;
    }
    public void lockDiary() {
        isLocked = true;
    }
    public void createEntry(String title, String body) {
        boolean isValidSecurity = !isLocked;
        MyEntry myEntry = new MyEntry(entries.size(), title, body);
        if(isValidSecurity)this.entries.add(myEntry);
        this.lockDiary();
    }
    public int numberOfDiary() {
        return entries.size();
    }
    public void deleteEntry(int identification) {
        boolean isValidIdentification = identification >= 0 && identification < entries.size();
        boolean isValidSecurity = !isLocked;
        boolean isValidOperation = isValidIdentification && isValidSecurity;
        if(isValidOperation)entries.remove(identification);
    }
    public MyEntry findEntryById(int identification) {
        boolean isValidIdentification = identification >= 0 && identification < entries.size();
        boolean isValidSecurity = !isLocked;
        boolean isValidSearch = isValidIdentification && isValidSecurity;
         return isValidSearch? entries.get(identification): null;
    }
    public void updateEntry(int identification, String title1, String body) {
        boolean isValidOperation = !isLocked && identification >= 0 && identification < entries.size();
        MyEntry updated = new  MyEntry(identification, title1, body);
       if(isValidOperation)this.entries.set(identification, updated);
       this.lockDiary();
    }
}
