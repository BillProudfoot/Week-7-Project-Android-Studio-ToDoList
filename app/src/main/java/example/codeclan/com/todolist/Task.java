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

    public Task(String  priority, String task, String detail, int image, boolean isDone) {
        this.priority = priority;
        this.task = task;
        this.detail = detail;
        this.image = image;
        this.isDone = isDone;
    }

    public String getPriority(){return priority;}
    public String getTask() {return task;}
    public String getDetail() {return detail;}
    public int getImage(){return image;}
    public boolean getIsDone(){return isDone;}
    public void setToDone(){
        isDone ^= true;
    }

}
