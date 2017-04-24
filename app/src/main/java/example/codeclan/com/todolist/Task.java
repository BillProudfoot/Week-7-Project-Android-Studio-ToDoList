package example.codeclan.com.todolist;

import java.io.Serializable;

/**
 * Created by user on 22/04/2017.
 */

public class Task implements Serializable{

    private int priority;
    private String task;
    private String detail;
    private int image;

    public Task(Integer priority, String task, String detail, int image) {
        this.priority = priority;
        this.task = task;
        this.detail = detail;
        this.image = image;
    }

    public Integer getPriority(){return priority;}
    public String getTask() {return task;}
    public String getDetail() {return detail;}
    public int getImage(){return image;}
}
