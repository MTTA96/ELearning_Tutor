package com.eways.etutor.params;

import android.app.Application;

import com.eways.etutor.MainActivity;
import com.google.gson.Gson;

/**
 * Created by ADMIN on 2/10/2018.
 */

public class GlobalParams extends Application {

    private static GlobalParams instance;
    private MainActivity mainActivity;
    private Gson gson;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    /* GET - SET */

    public static GlobalParams getInstance() {
        return instance;
    }

    public MainActivity getMainActivity() {
        return mainActivity;
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public Gson getGSon() {
        return gson;
    }
}
