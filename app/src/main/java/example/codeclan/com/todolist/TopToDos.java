package example.codeclan.com.todolist;

import java.util.ArrayList;

/**
 * Created by user on 22/04/2017.
 */

public class TopToDos {

    private ArrayList<ToDo> list;

    public TopToDos (){
        list = new ArrayList<ToDo>();
        list.add(new ToDo("wash floors", "Hall and kitchen floors to be vacuumed and washed"));
        list.add(new ToDo("shopping", "Buy bread, milk and cheese"));
        list.add(new ToDo("DIY", "fix shower in bathroom"));

    }

    public ArrayList<ToDo> getList(){ return new ArrayList<ToDo>(list);}
}
