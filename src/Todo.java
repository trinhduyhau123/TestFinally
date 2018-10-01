import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Todo {
    private String title = "";
    private String description ="";
    private boolean done = false;
    private Date due ;

    public Todo() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Date getDue() {
        return due;
    }

    public void setDue(Date due) {
        this.due = due;
    }

    public void setDue(String dataString) throws ParseException {
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formater.parse(dataString);
            due = date;
    }

    public void showInfor() {
        System.out.println("Title :" + getTitle());
        System.out.println("Description:" + getDescription());
        if (isDone() == true) {
            System.out.println("Done");
        } else {
            System.out.println("Not Done");
        }
        System.out.println("Date: "+ getDue());
    }
}
