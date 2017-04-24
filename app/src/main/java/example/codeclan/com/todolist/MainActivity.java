package example.codeclan.com.todolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by user on 23/04/2017.
 */

public class MainActivity extends AppCompatActivity {
    EditText taskTextToSave;
    EditText detailTextToSave;
    Button saveButton;
    TextView savedTaskText;
    TextView savedDetailText;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskTextToSave = (EditText)findViewById(R.id.task_text_to_save);
        detailTextToSave = (EditText)findViewById(R.id.detail_text_to_save);
        saveButton = (Button)findViewById(R.id.save_button);
        savedTaskText = (TextView)findViewById(R.id.saved_task_text);
        savedTaskText.setVisibility(View.INVISIBLE);
        savedDetailText = (TextView)findViewById(R.id.saved_detail_text);
        savedDetailText.setVisibility(View.INVISIBLE);

        String returnedText = SavedTextPreferences.getStoredTaskText(this);

        if (returnedText != null) {
            taskTextToSave.setVisibility(View.INVISIBLE);
            detailTextToSave.setVisibility(View.INVISIBLE);
            saveButton.setVisibility(View.INVISIBLE);
            savedTaskText.setVisibility(View.VISIBLE);
            savedTaskText.setText(returnedText);
            savedDetailText.setVisibility(View.VISIBLE);
            savedDetailText.setText(returnedText);
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
        if (item.getItemId() == R.id.action_welcome){
            Toast.makeText(MainActivity.this,"Task updated", Toast.LENGTH_SHORT).show();;
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onSaveButtonClick(View view) {
        String stringTextToSave = taskTextToSave.getText().toString();
        String stringDetailToSave = detailTextToSave.getText().toString();
        Log.d(" ToDo List:", "Save Button Clicked!");
        Log.d(" ToDo List:", " ToDo Task: ' " + taskTextToSave + "'");
        Log.d(" ToDo List", "ToDo Detail: ' " + detailTextToSave + "'");
        saveButton.setVisibility(View.INVISIBLE);
        taskTextToSave.setVisibility(View.INVISIBLE);
        detailTextToSave.setVisibility(View.INVISIBLE);
        savedTaskText.setVisibility(View.VISIBLE);
        savedTaskText.setText(stringTextToSave);
        savedDetailText.setVisibility(View.VISIBLE);
        savedDetailText.setText(stringDetailToSave);

        SavedTextPreferences.setStoredTaskText(this, stringTextToSave);
        SavedTextPreferences.setStoredTaskText(this, stringDetailToSave);

    }

}
