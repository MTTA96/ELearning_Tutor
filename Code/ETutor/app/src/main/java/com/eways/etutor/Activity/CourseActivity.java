package com.eways.etutor.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.eways.etutor.Fragment.FragmentUserManager;
import com.eways.etutor.R;
import com.eways.etutor.Utils.Handler.FragmentHandler;

public class CourseActivity extends AppCompatActivity implements View.OnClickListener {

    /* VIEWS */



    FragmentHandler fragmentHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        Handle();
    }

    public void Handle(){
        fragmentHandler = new FragmentHandler(this, R.id.content_course);
        fragmentHandler.changeFragment(new FragmentUserManager(), 0, 0);
    }

    public void Declare(){

    }

    @Override
    public void onClick(View view) {

    }
}
