package example.codeclan.com.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 22/04/2017.
 */

public class TopToDosAdapter extends ArrayAdapter<ToDo>{


    public TopToDosAdapter(Context context, ArrayList<ToDo> todos){
        super(context, 0, todos);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent){

        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.todos_item, parent, false);
        }

        ToDo currentToDo = getItem(position);

        TextView priority = (TextView) listItemView.findViewById(R.id.priority);
        priority.setText(currentToDo.getPriority().toString());

        TextView todo = (TextView) listItemView.findViewById(R.id.todo);
        todo.setText(currentToDo.getTodo().toString());

        TextView detail = (TextView) listItemView.findViewById(R.id.detail);
        detail.setText(currentToDo.getDetail().toString());

        ImageView myImageView = (ImageView) listItemView.findViewById(R.id.category_art);
        myImageView.setImageResource(currentToDo.getImage());

        listItemView.setTag(currentToDo);

        return listItemView;
    }

}
