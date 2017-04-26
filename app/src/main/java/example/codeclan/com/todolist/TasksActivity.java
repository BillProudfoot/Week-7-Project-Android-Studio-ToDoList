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
    }
}
