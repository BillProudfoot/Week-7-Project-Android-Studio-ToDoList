package example.codeclan.com.todolist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by user on 23/04/2017.
 */

public class MainActivity extends AppCompatActivity {
    EditText priorityToSave;
    EditText taskTextToSave;
    EditText detailTextToSave;
    Button saveButton;
    Button button_go_to_tasks_2;
    TextView savedPriorityText;
    TextView savedTaskText;
    TextView savedDetailText;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListnerOnButton();


        priorityToSave = (EditText)findViewById(R.id.task_priority_to_save);
        taskTextToSave = (EditText)findViewById(R.id.task_text_to_save);
        detailTextToSave = (EditText)findViewById(R.id.detail_text_to_save);
        saveButton = (Button)findViewById(R.id.save_button);
        button_go_to_tasks_2 = (Button) findViewById(R.id.button_go_to_tasks);
        savedPriorityText = (TextView)findViewById(R.id.saved_priority_text);
        savedPriorityText.setVisibility(View.INVISIBLE);
        savedTaskText = (TextView)findViewById(R.id.saved_task_text);
        savedTaskText.setVisibility(View.INVISIBLE);
        savedDetailText = (TextView)findViewById(R.id.saved_detail_text);
        savedDetailText.setVisibility(View.INVISIBLE);
        String returnedText = SavedTextPreferences.getStoredTaskText(this);

    }

    private void addListnerOnButton()
        {
            final SavedTextPreferences savedTextPreferences = new SavedTextPreferences();
            final ArrayList<Task> taskList = savedTextPreferences.getTasks(this);
            button_go_to_tasks_2 = (Button) findViewById(R.id.button_go_to_tasks);
            final Context context = this;
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
            Toast.makeText(MainActivity.this,"Going to list", Toast.LENGTH_SHORT).show();;
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onSaveButtonClick(View view) {
        String stringPriorityToSave = priorityToSave.getText().toString();
        String stringTextToSave = taskTextToSave.getText().toString();
        String stringDetailToSave = detailTextToSave.getText().toString();

        Task task = new Task(stringPriorityToSave , stringTextToSave, stringDetailToSave, 0, false, "");

        SavedTextPreferences.addTask(this, task);

        Intent intent = new Intent(this, TopTasksActivity.class);
        startActivity(intent);

    }

    public void gotoTaskList(View view) {

        Intent intent = new Intent(this, TopTasksActivity.class);
        startActivity(intent);
    }
}
