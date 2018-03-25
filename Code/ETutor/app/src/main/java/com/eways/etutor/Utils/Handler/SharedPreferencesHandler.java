package com.eways.etutor.Utils.Handler;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ADMIN on 3/18/2018.
 */

public class SharedPreferencesHandler {

    Context context;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private final String KEY_ID = "id";
    private final String KEY_ACCOUNT_GMAIL = "account_gmail";

    public SharedPreferencesHandler(Context context, String fileName) {
        this.context = context;

        sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    /*--- GET - SET ---*/

    public void setId(String id){
        editor.putString(KEY_ID, id);
        editor.commit();
    }

    public String getId(){
        return sharedPreferences.getString(KEY_ID, null);
    }

}
