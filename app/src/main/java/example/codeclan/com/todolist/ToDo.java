package example.codeclan.com.todolist;

/**
 * Created by user on 22/04/2017.
 */

public class ToDo {

    private int priority;
    private String todo;
    private String detail;
    private int image;

    public ToDo( Integer priority, String todo, String detail, int image) {
        this.priority = priority;
        this.todo = todo;
        this.detail = detail;
        this.image = image;
    }

    public Integer getPriority(){return priority;}
    public String getTodo() {return todo;}
    public String getDetail() {return detail;}
    public int getImage(){return image;}
}
