package com.eways.etutor.Views.Activity.Course;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import com.eways.etutor.R;

public class CreateCourseActivity extends Activity {
    EditText etSubject, etAddress, etTuition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_course);

        declare_views();
        handle_views();
    }

    private void declare_views(){}

    private void handle_views(){
    }

}
