package example.codeclan.com.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class TopTasksActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasks_list);


        ArrayList<Task> list = SavedTextPreferences.getTasks(this);

        TopTasksAdapter tasksAdapter = new TopTasksAdapter(this, list);

        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(tasksAdapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
//               String selected = (String)listView.getItemAtPosition(position);
//                Log.d("ListView:", selected + "selected");
//            }
//        });
    }

//    private ArrayList<String> setUpStringsList(){
//
//    }


    public void getTask(View listItem) {
        Task task = (Task) listItem.getTag();
        Log.d(" To Do : ", task.getTask());
        Log.d(" Detail : ", task.getDetail());

        Gson gson = new Gson();

        String taskAsString = gson.toJson(task);

        Intent intent = new Intent(this, DetailsActivity.class); // UPDATED
        intent.putExtra("task", taskAsString); // UPDATED

        startActivity(intent); // UPDATED
    }
}
