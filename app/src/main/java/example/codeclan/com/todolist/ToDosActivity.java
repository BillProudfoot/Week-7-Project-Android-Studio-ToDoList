package example.codeclan.com.todolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.attr.id;

public class ToDosActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(layout.todos_list);

        TopToDos topToDos = new TopToDos();
        ArrayList<ToDo> list = topToDos.getList();

        TopToDosAdapter toDosAdapter = new TopToDosAdapter(this, list);

        ListView listView = (ListView) findViewById(id.list);
        listView.setAdapter(toDosAdapter);
    }

    public void getToDo(View listItem) {
        ToDo toDo = (ToDo) listItem.getTag();
        Log.d(" To Do : ", toDo.gettoDo());
    }
}
