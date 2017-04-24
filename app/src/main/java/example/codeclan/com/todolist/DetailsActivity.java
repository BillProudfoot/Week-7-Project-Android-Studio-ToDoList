package example.codeclan.com.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by user on 24/04/2017.
 */

public class DetailsActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_list);

        ArrayList<Task> list = SavedTextPreferences.getTasks(this);

        TopTasksAdapter tasksAdapter = new TopTasksAdapter(this, list);

        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(tasksAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                String selected = (String)listView.getItemAtPosition(position);
            }
        });

    public void getTask(View listItem) {
        Task task = (Task) listItem.getTag();

        Gson gson = new Gson();

        String detailAsString = gson.toJson(task);

        Intent intent = new Intent(this, TasksActivity.class);
        intent.putExtra("detail", detailAsString);

        startActivity(intent);
    }

}
