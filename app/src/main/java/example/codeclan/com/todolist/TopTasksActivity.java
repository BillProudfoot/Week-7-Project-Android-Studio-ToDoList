package example.codeclan.com.todolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class TopTasksActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasks_list);

        TopTasks topTasks = new TopTasks();
        ArrayList<Task> list = topTasks.getList();

        TopTasksAdapter toDosAdapter = new TopTasksAdapter(this, list);

        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(toDosAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
               String selected = (String)listView.getItemAtPosition(position);
                Log.d("ListView:", selected + "selected");
            }
        });
    }

//    private ArrayList<String> setUpStringsList(){
//
//    }


    public void getTask(View listItem) {
        Task task = (Task) listItem.getTag();
        Log.d(" To Do : ", task.getTask());
    }
}
