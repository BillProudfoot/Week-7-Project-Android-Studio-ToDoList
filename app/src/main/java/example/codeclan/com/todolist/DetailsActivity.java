package example.codeclan.com.todolist;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import static example.codeclan.com.todolist.R.drawable.chore;
import static example.codeclan.com.todolist.R.drawable.diy;
import static example.codeclan.com.todolist.R.drawable.exercise;
import static example.codeclan.com.todolist.R.drawable.other;
import static example.codeclan.com.todolist.R.drawable.shopping;
import static example.codeclan.com.todolist.R.drawable.work;

/**
 * Created by user on 24/04/2017.
 */

public class DetailsActivity extends AppCompatActivity {
    private CheckBox check1;
    private RadioButton check2;
    private RadioButton check3;
    private RadioButton check4;
    private RadioButton check5;
    private RadioButton check6;
    private RadioButton check7;
    private Button button_done_sel;
    ListView listView;
    RadioGroup radioGroup;
    int checked;
    Image image;

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

        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                checked = radioGroup.indexOfChild(findViewById(checkedId));
                switch (checked) {
                    case 0:
                        Toast.makeText(DetailsActivity.this, "DIY Category has been selected", Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        Toast.makeText(DetailsActivity.this, "Chore Category has been selected", Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Toast.makeText(DetailsActivity.this, "Shopping Category has been selected", Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        Toast.makeText(DetailsActivity.this, "Exercise Category has been selected", Toast.LENGTH_LONG).show();
                        break;
                    case 4:
                        Toast.makeText(DetailsActivity.this, "Work Category has been selected", Toast.LENGTH_LONG).show();
                        break;
                    case 5:
                        Toast.makeText(DetailsActivity.this, "Other Category is selected", Toast.LENGTH_LONG).show();
                        break;
                    default:

                        break;

                }
            }

        });

    }


    public void addListenerOnButton() {
        final SavedTextPreferences savedTextPreferences = new SavedTextPreferences();
        final ArrayList<Task> taskList = savedTextPreferences.getTasks(this);
        check1 = (CheckBox) findViewById(R.id.checkbox_done);
        check2 = (RadioButton) findViewById(R.id.checkBox_diy);
        check3 = (RadioButton) findViewById(R.id.checkBox_chore);
        check4 = (RadioButton) findViewById(R.id.checkBox_shopping);
        check5 = (RadioButton) findViewById(R.id.checkBox_exercise);
        check6 = (RadioButton) findViewById(R.id.checkBox_work);
        check7 = (RadioButton) findViewById(R.id.checkBox_other);
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

                            for(int i = 0; i < taskList.size(); i++){
                                if(taskList.get(i).getTask().equals(task.getTask())){
                                    taskList.remove(i);
                                }
                            }
                            task.setToDone();
                            taskList.add(task);
                            savedTextPreferences.setTasks(context, taskList);
                        }
                        if (check2.isChecked()) {
                            Task task = gson.fromJson(taskAsString, Task.class);

                            for(int i = 0; i < taskList.size(); i++){
                                if(taskList.get(i).getTask().equals(task.getTask())){
                                    taskList.remove(i);
                                }
                            }
                            task.setImage(diy);
                            taskList.add(task);
                            savedTextPreferences.setTasks(context, taskList);
                        }
                        if (check3.isChecked()) {
                            Task task = gson.fromJson(taskAsString, Task.class);

                            for(int i = 0; i < taskList.size(); i++){
                                if(taskList.get(i).getTask().equals(task.getTask())){
                                    taskList.remove(i);
                                }
                            }
                            task.setImage(chore);
                            taskList.add(task);
                            savedTextPreferences.setTasks(context, taskList);
                        }
                        if (check4.isChecked()) {
                            Task task = gson.fromJson(taskAsString, Task.class);

                            for(int i = 0; i < taskList.size(); i++){
                                if(taskList.get(i).getTask().equals(task.getTask())){
                                    taskList.remove(i);
                                }
                            }
                            task.setImage(shopping);
                            taskList.add(task);
                            savedTextPreferences.setTasks(context, taskList);
                        }
                        if (check5.isChecked()) {
                            Task task = gson.fromJson(taskAsString, Task.class);

                            for(int i = 0; i < taskList.size(); i++){
                                if(taskList.get(i).getTask().equals(task.getTask())){
                                    taskList.remove(i);
                                }
                            }
                            task.setImage(exercise);
                            taskList.add(task);
                            savedTextPreferences.setTasks(context, taskList);
                        }
                        if (check6.isChecked()) {
                            Task task = gson.fromJson(taskAsString, Task.class);

                            for(int i = 0; i < taskList.size(); i++){
                                if(taskList.get(i).getTask().equals(task.getTask())){
                                    taskList.remove(i);
                                }
                            }
                            task.setImage(work);
                            taskList.add(task);
                            savedTextPreferences.setTasks(context, taskList);
                        }
                        if (check7.isChecked()) {
                            Task task = gson.fromJson(taskAsString, Task.class);

                            for(int i = 0; i < taskList.size(); i++){
                                if(taskList.get(i).getTask().equals(task.getTask())){
                                    taskList.remove(i);
                                }
                            }
                            task.setImage(other);
                            taskList.add(task);
                            savedTextPreferences.setTasks(context, taskList);
                        }
                    }

                }
        );
    }
    public void addListenerToCheckBox(){
        check1 = (CheckBox) findViewById(R.id.checkbox_done);
//        check2 = (RadioButton) findViewById(R.id.checkBox_diy);
//        check3 = (RadioButton) findViewById(R.id.checkBox_chore);
//        check4 = (RadioButton) findViewById(R.id.checkBox_shopping);
//        check5 = (RadioButton) findViewById(R.id.checkBox_exercise);
//        check6 = (RadioButton) findViewById(R.id.checkBox_work);
//        check7 = (RadioButton) findViewById(R.id.checkBox_other);
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

//        check2.setOnClickListener(
//                new View.OnClickListener(){
//                    @Override
//                    public void onClick(View variable){
//                        if(((RadioButton)variable).isChecked()){
//                            Toast.makeText(DetailsActivity.this,"DIY Category has been selected",Toast.LENGTH_LONG).show();
//                        }
//                    }
//                }
//        );
//
//        check3.setOnClickListener(
//                new View.OnClickListener(){
//                    @Override
//                    public void onClick(View variable){
//                        if(((RadioButton)variable).isChecked()){
//                            Toast.makeText(DetailsActivity.this,"Chore Category has been selected",Toast.LENGTH_LONG).show();
//                        }
//                    }
//                }
//        );
//
//        check4.setOnClickListener(
//                new View.OnClickListener(){
//                    @Override
//                    public void onClick(View variable){
//                        if(((RadioButton)variable).isChecked()){
//                            Toast.makeText(DetailsActivity.this,"Shopping Category has been selected",Toast.LENGTH_LONG).show();
//                        }
//                    }
//                }
//        );
//
//        check5.setOnClickListener(
//                new View.OnClickListener(){
//                    @Override
//                    public void onClick(View variable){
//                        if(((RadioButton)variable).isChecked()){
//                            Toast.makeText(DetailsActivity.this,"Exercise Category has been selected",Toast.LENGTH_LONG).show();
//                        }
//                    }
//                }
//        );
//
//        check6.setOnClickListener(
//                new View.OnClickListener(){
//                    @Override
//                    public void onClick(View variable){
//                        if(((RadioButton)variable).isChecked()){
//                            Toast.makeText(DetailsActivity.this,"Work Category has been selected",Toast.LENGTH_LONG).show();
//                        }
//                    }
//                }
//        );
//
//        check7.setOnClickListener(
//                new View.OnClickListener(){
//                    @Override
//                    public void onClick(View variable){
//                        if(((RadioButton)variable).isChecked()){
//                            Toast.makeText(DetailsActivity.this,"Other Category is selected",Toast.LENGTH_LONG).show();
//                        }
//                    }
//                }
//        );
    }

}
