package example.codeclan.com.todolist;

import java.util.ArrayList;

/**
 * Created by user on 22/04/2017.
 */

public class TopTasks {

    private ArrayList<Task> list;

    public TopTasks(){
        list = new ArrayList<Task>();
        list.add(new Task(1, "wash floors", "Hall and kitchen floors to be vacuumed and washed",R.drawable.chore));
        list.add(new Task(2, "shopping", "Buy bread, milk and cheese",R.drawable.shopping));
        list.add(new Task(3, "DIY", "fix shower in bathroom",R.drawable.diy));

    }

    public ArrayList<Task> getList(){ return new ArrayList<Task>(list);}

    /**
     * Created by user on 24/04/2017.
     */

    public static class TasksActivity {
    }
}
