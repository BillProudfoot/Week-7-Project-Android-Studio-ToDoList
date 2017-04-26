package example.codeclan.com.todolist;

import java.util.ArrayList;

/**
 * Created by user on 22/04/2017.
 */

public class TopTasks {

    private ArrayList<Task> list;

    public TopTasks(){
        list = new ArrayList<Task>();
        list.add(new Task("High", "wash floors", "Hall and kitchen floors to be vacuumed and washed",R.drawable.chore, false, 1292838124));
        list.add(new Task("Medium", "shopping", "Buy bread, milk and cheese",R.drawable.shopping, false, 1292838124));
        list.add(new Task("Low", "DIY", "fix shower in bathroom",R.drawable.diy, false, 1292838124));

    }

    public ArrayList<Task> getList(){ return new ArrayList<Task>(list);}

    /**
     * Created by user on 24/04/2017.
     */

    public static class TasksActivity {
    }
}
