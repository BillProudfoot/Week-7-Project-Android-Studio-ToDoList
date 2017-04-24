package example.codeclan.com.todolist;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by user on 24/04/2017.
 */

public class SavedTextPreferences {
    private static final String PREF_SAVEDTASKTEXT = "savedTaskText";

    public static void setStoredTaskText(Context context, String text){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(PREF_SAVEDTASKTEXT,text);
        editor.apply();

    }

    public static String getStoredTaskText(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        return sharedPreferences.getString(PREF_SAVEDTASKTEXT, null);
    }
}
