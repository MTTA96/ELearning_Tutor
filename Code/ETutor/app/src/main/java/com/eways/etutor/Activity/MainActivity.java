package com.eways.etutor.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.eways.etutor.Fragment.LoginFragment;
import com.eways.etutor.R;
import com.eways.etutor.Utils.Handler.FragmentHandler;

public class MainActivity extends AppCompatActivity {

    /*---- FRAGMENT HANDLE -----*/
    FragmentHandler fragmentHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Declare();

        Handle();

    }

    //Declare
    public void Declare(){

        //setup fragment handle
        fragmentHandler = new FragmentHandler(this, R.id.main_activity);
    }

    //Handle
    public void Handle(){

        //Change fragment
        fragmentHandler.ChangeFragment(LoginFragment.newInstance());
    }
}
