package com.eways.etutor.Views.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import com.eways.etutor.R;
import com.eways.etutor.Utils.Handler.FragmentHandler;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    /* VIEWS */
    Toolbar toolbar;
    RelativeLayout content;
    RecyclerView listSearch;



    FragmentHandler fragmentHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        declare_views();
        Handle();
    }

    public void Handle(){
//        fragmentHandler = new FragmentHandler(this, R.id.content_course);
//        fragmentHandler.changeFragment(new FragmentUpdateDetail(), SupportKey.UPDATE_DETAILs_FRAGMENT_TAG, 0, 0);

        setSupportActionBar(toolbar);

    }

    public void declare_views(){
        toolbar = findViewById(R.id.toolbar);
        content = findViewById(R.id.content);
        listSearch = findViewById(R.id.list_search);

    }

    @Override
    public void onClick(View view) {

    }
}
