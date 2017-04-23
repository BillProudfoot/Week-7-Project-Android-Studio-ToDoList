package example.codeclan.com.todolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TopToDosActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.todos_list);

        listView = (ListView)findViewById(R.id.list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,setUpStringsList());

        TopToDos topToDos = new TopToDos();
        ArrayList<ToDo> list = topToDos.getList();

        TopToDosAdapter toDosAdapter = new TopToDosAdapter(this, list);



        listView.setAdapter(toDosAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
               String selected = (String)listView.getItemAtPosition(position);
                Log.d("ListView:", selected + "selected");
            }
        });
    }

    private ArrayList<String> setUpStringsList(){

    }


    public void getToDo(View listItem) {
        ToDo toDo = (ToDo) listItem.getTag();
        Log.d(" To Do : ", toDo.getTodo());
    }
}
