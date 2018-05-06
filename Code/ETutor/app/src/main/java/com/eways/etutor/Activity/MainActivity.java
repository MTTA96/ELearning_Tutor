package com.eways.etutor.Activity;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eways.etutor.Fragment.LoginFragment;
import com.eways.etutor.R;
import com.eways.etutor.Utils.Handler.FragmentHandler;

public class MainActivity extends AppCompatActivity{

    /*---- FRAGMENT HANDLE -----*/
    FragmentHandler fragmentHandler;

    /*------ VIEWS ------*/
    View content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Declare();

        Handle();

    }

    //Declare
    public void Declare(){
        content = findViewById(R.id.content_user);
    }

    //Handle
    public void Handle(){
        fragmentHandler = new FragmentHandler(this, R.id.content_user);

        fragmentHandler.ChangeFragment(new LoginFragment(), 0, 0);
    }
}
