package example.codeclan.com.todolist;

/**
 * Created by user on 22/04/2017.
 */

public class ToDo {

    private String todo;
    private String detail;

    public ToDo( String todo, String detail){
        this.todo = todo;
        this.detail = detail;
    }

    public String getTodo() {return todo;}
    public String getDetail() {return detail;}
}
