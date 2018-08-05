package com.eways.etutor.Utils.Handler;

/**
 * Created by zzzzz on 6/2/2018.
 */

public class SharedPreferencesHandler {
    private static SharedPreferencesHandler instance = null;

    public static SharedPreferencesHandler getInstance() {
        if (instance == null) {
            instance = new SharedPreferencesHandler();
            return instance;
        }
        return instance;
    }


}
