import java.time.LocalDate;

public class MyEntry {
    private int identification;
    private String title;
    private String body;
    private LocalDate entryDate;

    public MyEntry(int id, String title, String body) {
        this.identification = id;
        this.title = title;
        this.body = body;
        this.entryDate = LocalDate.now();

    }
    public int getIdentification() {
        return identification;
    }
    public String getBody(){
        return body;
    }
    public String getTitle(){
        return title;
    }
    public LocalDate getEntryDate(){
        return entryDate;
    }

}

