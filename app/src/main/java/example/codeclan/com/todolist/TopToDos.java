package example.codeclan.com.todolist;

import java.util.ArrayList;

/**
 * Created by user on 22/04/2017.
 */

public class TopToDos {

    private ArrayList<ToDo> list;

    public TopToDos (){
        list = new ArrayList<ToDo>();
        list.add(new ToDo(1, "wash floors", "Hall and kitchen floors to be vacuumed and washed",R.drawable.chore));
        list.add(new ToDo(2, "shopping", "Buy bread, milk and cheese",R.drawable.shopping));
        list.add(new ToDo(3, "DIY", "fix shower in bathroom",R.drawable.diy));

    }

    public ArrayList<ToDo> getList(){ return new ArrayList<ToDo>(list);}
}
