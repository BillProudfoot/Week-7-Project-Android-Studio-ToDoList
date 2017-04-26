package example.codeclan.com.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 22/04/2017.
 */

public class TopTasksAdapter extends ArrayAdapter<Task>{


    public TopTasksAdapter(Context context, ArrayList<Task> tasks){
        super(context, 0, tasks);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent){

        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.tasks_item, parent, false);
        }

        Task currentTask = getItem(position);

        TextView priority = (TextView) listItemView.findViewById(R.id.priority);
        priority.setText(currentTask.getPriority().toString());

        TextView task = (TextView) listItemView.findViewById(R.id.task);
        task.setText(currentTask.getTask().toString());

        ImageView myImageView = (ImageView) listItemView.findViewById(R.id.category_art);
        myImageView.setImageResource(currentTask.getImage());
        Switch checked = (Switch) listItemView.findViewById(R.id.isDone);
        checked.setChecked(currentTask.getIsDone());
        
        TextView date = (TextView) listItemView.findViewById(R.id.date);
        date.setText(currentTask.getDate().toString());

        listItemView.setTag(currentTask);

        return listItemView;
    }

}
