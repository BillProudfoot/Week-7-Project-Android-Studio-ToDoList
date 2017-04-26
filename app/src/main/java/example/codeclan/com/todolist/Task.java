package example.codeclan.com.todolist;

import java.io.Serializable;

/**
 * Created by user on 22/04/2017.
 */

public class Task implements Serializable{

    private String priority;
    private String task;
    private String detail;
    private int image;
    private boolean isDone;
    private String date;

    public Task(String  priority, String task, String detail, int image, boolean isDone, String date) {
        this.priority = priority;
        this.task = task;
        this.detail = detail;
        this.image = image;
        this.isDone = isDone;
        this.date = date;
    }

    public String getPriority(){return priority;}
    public String getTask() {return task;}
    public String getDetail() {return detail;}
    public int getImage(){return image;}
    public boolean getIsDone(){return isDone;}
    public String getDate(){return date;}
    public void setToDone(){
        isDone ^= true;
    }
    public void setImage(int diy ) { image = diy; }

    public void setDate(String date){ this.date = date; }
}

