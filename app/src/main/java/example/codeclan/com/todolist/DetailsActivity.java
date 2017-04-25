package example.codeclan.com.todolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

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

    public void addListenerOnButton(){
        check1 = (CheckBox)findViewById(R.id.checkbox_done);
        button_done_sel =(Button)findViewById(R.id.button);

        button_done_sel.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View variable){
                        StringBuffer result = new StringBuffer();
                        result.append("Task : ").append(check1.isChecked());

                        Toast.makeText(DetailsActivity.this,result.toString(),Toast.LENGTH_LONG).show();
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
