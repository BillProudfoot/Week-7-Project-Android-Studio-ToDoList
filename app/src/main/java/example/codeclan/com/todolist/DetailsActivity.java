package example.codeclan.com.todolist;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by user on 24/04/2017.
 */

public class DetailsActivity extends AppCompatActivity {
    private CheckBox check1;
    private Button button_done_sel;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_list);
        addListenerOnButton();
        addListenerToCheckBox();


        String taskAsString = getIntent().getExtras().getString("task");

        Gson gson = new Gson();

        Task task = gson.fromJson(taskAsString, Task.class);

        TextView textView = (TextView) findViewById(R.id.detail);

        textView.setText(task.getDetail());
//        ArrayList<Task> list = SavedTextPreferences.getTasks(this);
//
//        TopTasksAdapter tasksAdapter = new TopTasksAdapter(this, list);
//
//        final ListView listView = (ListView) findViewById(R.id.list);
//        listView.setAdapter(tasksAdapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String selected = (String) listView.getItemAtPosition(position);
//            }
//        });
    }

    public void addListenerOnButton() {
        final SavedTextPreferences savedTextPreferences = new SavedTextPreferences();
        final ArrayList<Task> taskList = savedTextPreferences.getTasks(this);
        check1 = (CheckBox) findViewById(R.id.checkbox_done);
        button_done_sel = (Button) findViewById(R.id.button);
        final Context context = this;

        button_done_sel.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View variable) {


                        StringBuffer result = new StringBuffer();
                        result.append("Task : ").append(check1.isChecked());

                        Toast.makeText(DetailsActivity.this, result.toString(), Toast.LENGTH_LONG).show();

                        String taskAsString = getIntent().getExtras().getString("task");

                        Gson gson = new Gson();

                        if (check1.isChecked()) {
                            Task task = gson.fromJson(taskAsString, Task.class);
//                            taskList.remove(task);
                            for(int i = 0; i < taskList.size(); i++){
                                if(taskList.get(i).getTask().equals(task.getTask())){
                                    taskList.remove(i);
                                }
                            }
                            task.setToDone();
                            taskList.add(task);
                            savedTextPreferences.setTasks(context, taskList);
                        }

                    }

                }
        );
    }
    public void addListenerToCheckBox(){
        check1 = (CheckBox)findViewById(R.id.checkbox_done);
        check1.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View variable){
                        if(((CheckBox)variable).isChecked()){
                            Toast.makeText(DetailsActivity.this,"Task is Checked done",Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );

    }

}
