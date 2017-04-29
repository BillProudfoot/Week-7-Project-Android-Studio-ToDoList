package example.codeclan.com.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

public class TopTasksActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasks_list);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.action_welcome){
            Toast.makeText(TopTasksActivity.this,"Going to list", Toast.LENGTH_SHORT).show();;
            return true;

        }
        return super.onOptionsItemSelected(item);

    }

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

    @Override
    public void onResume() {
        super.onResume();

        ArrayList<Task> list = SavedTextPreferences.getTasks(this);

        TopTasksAdapter tasksAdapter = new TopTasksAdapter(this, list);

        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(tasksAdapter);
    }

}
