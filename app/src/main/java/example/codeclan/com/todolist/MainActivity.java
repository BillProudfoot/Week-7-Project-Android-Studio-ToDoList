package example.codeclan.com.todolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by user on 23/04/2017.
 */

public class MainActivity extends AppCompatActivity {
    EditTaskText taskTextToSave;
    EditDetailText detailTextToSave;
    Button saveButton;
    TextView savedTaskText;
    TextView savedDetailText;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskTextToSave = (EditTaskText)findViewById(R.id.task_text_to_save);
        detailTextToSave = (EditDetailText)findViewById(R.id.detail_test_to_save);
        saveButton = (Button)findViewById(R.id.save_button);
        savedTaskText = (TextView)findViewById(R.id.saved_task_text);
        savedDetailText = (TextView)findViewById(R.id.saved_detail_text);

        String returnedText = SavedTextPreferences.getStoredText(this);

        if (returnedText != null) {
            taskTextToSave.setVisibility(View.INVISIBLE);
            detailTextToSave.setVisibility(View.INVISIBLE);
            saveButton.setVisibility(View.INVISIBLE);
            savedTaskText.setVisibility(View.VISIBLE);
            savedTaskText.setTaskText(returnedTaskText);
            savedDetailText.setVisibility(View.VISIBLE);
            savedDetailText.setDetailText(returnedDetailText);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.action_edit_task){
            Toast.makeText(MainActivity.this,"Task updated", Toast.LENGTH_SHORT).show();;
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onSaveButtonClick(View view) {
        String stringTextToSave = taskTextToSave.getText();
        String stringDetailToSave = detailTextToSave.getText();
        Log.d(" ToDo List:", "Save Button Clicked!");
        Log.d(" ToDo List:", " ToDo Task: ' " + taskTextToSave + "'");
        taskTextToSave.setVisibility(View.INVISIBLE);
        detailTextToSave.setVisibility(View.INVISIBLE);
        saveButton.setVisibility(View.INVISIBLE);
        savedTaskText.setVisibility(View.VISIBLE);
        savedTaskText.setTaskText(stringTextToSave);
        savedDetailText.setVisibility(View.VISIBLE);
        savedDetailText.setDetailText(stringDetailToSave);

        SavedTextPreferences.setStoredText(this, stringTextToSave);
        SavedTextPreferences.setStoredText(this, stringDetailToSave);

    }
}
