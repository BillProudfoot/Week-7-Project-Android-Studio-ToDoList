package example.codeclan.com.todolist;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class WelcomeActivity extends AppCompatActivity {
    private Button button_go_to_tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }
    public void addListenerOnButton() {
        final SavedTextPreferences savedTextPreferences = new SavedTextPreferences();
        final ArrayList<Task> taskList = savedTextPreferences.getTasks(this);
        button_go_to_tasks = (Button) findViewById(R.id.button_go_to_tasks);
        final Context context = this;
    }

    public void gotoTaskList(View view) {

        this.finish();
    }

}
