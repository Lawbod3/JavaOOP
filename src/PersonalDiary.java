import java.util.ArrayList;

public class PersonalDiary {
    private String password;
    private boolean isLocked = true;

    public PersonalDiary(String username, String password) {
        this.password = password;
    }


    public void unLockedDiary(String password) {
        boolean isValidUser = this.password.equals(password);
        if(isValidUser)isLocked = false;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void lockedDiary() {
        isLocked = true;
    }

    public void createEntry(String title, String body) {

    }
}
