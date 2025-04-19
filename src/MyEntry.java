import java.time.LocalDate;
import java.util.ArrayList;

public class MyEntry {
    private int id ;
    private String title;
    private String body;
    private LocalDate entryDate;

    public MyEntry(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.entryDate = LocalDate.now();

    }
    public int getId() {
        return id;
    }
    public String getBody(){
        return body;
    }

}

