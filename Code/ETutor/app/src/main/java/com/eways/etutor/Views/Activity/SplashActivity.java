package com.eways.etutor.Views.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.eways.etutor.R;
import com.eways.etutor.Utils.Handler.FragmentHandler;
import com.eways.etutor.Utils.SharedPreferences.SharedPrefUtils;
import com.eways.etutor.Views.Activity.Account.AuthenticationActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    /**
     * VARS
     */

    private FragmentHandler fragmentHandler;
    private SharedPrefUtils sharedPrefUtils;

    /**
     * LIFECYCLE
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handle_views();
    }

    /**
     * CONFIG
     */
    public void handle_views() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(SplashActivity.this, AuthenticationActivity.class));
                        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_from_left);
                        finish();
                    }
                });
            }
        }, 1000);

    }

}
