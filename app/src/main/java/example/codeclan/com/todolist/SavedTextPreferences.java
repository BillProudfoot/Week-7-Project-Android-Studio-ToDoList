package example.codeclan.com.todolist;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * Created by user on 24/04/2017.
 */

public class SavedTextPreferences {
    private static final String PREF_SAVEDTASKTEXT = "savedTaskText";
    private static final String PREF_SAVEDTASK = "savedTask";

    public static void setStoredTaskText(Context context, String text){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(PREF_SAVEDTASKTEXT,text);
        editor.apply();

    }


    public static void addTask(Context context, Task task){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        ArrayList<Task> allTasks = getTasks(context);
        allTasks.add(task);

        Gson gson = new Gson();
        String allTaskAsJson = gson.toJson(allTasks);

        editor.putString(PREF_SAVEDTASK, allTaskAsJson);
        editor.apply();
    }

    public static ArrayList<Task> getTasks(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String tasksAsJson = sharedPreferences.getString(PREF_SAVEDTASK, new ArrayList<Task>().toString());

        Gson gson = new Gson();
        TypeToken<ArrayList<Task>> typeToken = new TypeToken<ArrayList<Task>>(){};
        ArrayList<Task> allTasks = gson.fromJson(tasksAsJson, typeToken.getType());
        return allTasks;
    }

    public static void setTasks(Context context, ArrayList<Task> taskList){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();
        String allTaskAsJson = gson.toJson(taskList);

        editor.putString(PREF_SAVEDTASK, allTaskAsJson);
        editor.apply();
    }


    public static String getStoredTaskText(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        return sharedPreferences.getString(PREF_SAVEDTASKTEXT, null);
    }

    private static final String PREF_SAVEDDETAILTEXT = "savedDetailText";

    public static void setStoredDetailText(Context context, String text){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(PREF_SAVEDDETAILTEXT,text);
        editor.apply();

    }

    public static String getStoredDetailText(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        return sharedPreferences.getString(PREF_SAVEDDETAILTEXT, null);
    }
}
