package example.codeclan.com.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by user on 22/04/2017.
 */

public class TopToDosAdapter extends ArrayAdapter<ToDo> {


    public class TopToDosAdapter(Context context, ArrayList<ToDo> toDos) {
        super(context, 0, toDos);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent){

        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.toDos_item, parent, false);
        }

        ToDo currentToDo = getItem(position);

        TextView todo = (TextView) listItemView.findViewById(R.id.todo);
        todo.setText(currentToDo.getTodo().toString());

        TextView detail = (TextView) listItemView.findViewById(R.id.detail);
        detail.setText(currentToDo.getDetail().toString());

        listItemView.setTag(currentToDo);

        return listItemView;
    }

}
