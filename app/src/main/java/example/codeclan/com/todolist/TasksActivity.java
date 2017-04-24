package example.codeclan.com.todolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;

/**
 * Created by user on 24/04/2017.
 */

public class TasksActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.tasks_list);

        Bundle bundle = getIntent().getExtras();
        String taskAsString = bundle.getString("task");

        Gson gson = new Gson();

        Task task = gson.fromJson(taskAsString, Task.class);


//
//        SharedPreferences sharedPref = getSharedPreferences("SavedPref", Context.MODE_PRIVATE);
//        String tasks = sharedPref.getString("MyTasks", new ArrayList<Task>().toString());
//
//        Log.d("Tasks String", tasks);
//
//        SharedPreferences.Editor editor = sharedPref.edit();
//
//        Gson gson = new Gson();
//        editor.putString("MyTasks", tasks);
//        editor.apply();
//
//        Toast.makeText(this, "Task added!", Toast.LENGTH_LONG).show();
//
//        TasksActivity();
//
//        TypeToken<ArrayList<Task>> taskArrayList = new
//                TypeToken<ArrayList<Task>>(){};
//        ArrayList<Task> myFavourites = gson.fromJson(tasks, taskArrayList.getType());
//
//        Task newTask = (Task) getIntent().getSerializableExtra("task");
//        Log.d("myTasks", myTasks);
//
//        TextView list = (TextView)findViewById(R.id.favourites_list);
//        String taskString = "";
//
//        for(Task task: myTasks){
//            taskString += task.getTask() + " " + task.getDetail() + "\n";
//        }
//
//        list.setText(taskString);

    }


}
