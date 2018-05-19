package com.eways.etutor.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.eways.etutor.R;
import com.eways.etutor.Utils.Handler.FragmentHandler;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    /* VIEWS */



    FragmentHandler fragmentHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Handle();
    }

    public void Handle(){
//        fragmentHandler = new FragmentHandler(this, R.id.content_course);
//        fragmentHandler.changeFragment(new FragmentUpdateDetail(), SupportKey.UPDATE_DETAILs_FRAGMENT_TAG, 0, 0);

    }

    public void Declare(){

    }

    @Override
    public void onClick(View view) {

    }
}
