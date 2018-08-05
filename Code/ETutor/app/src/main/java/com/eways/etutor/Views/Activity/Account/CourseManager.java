package com.eways.etutor.Views.Activity.Account;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.eways.etutor.Adapter.Course.CourseManager.CourseManagerAdapter;
import com.eways.etutor.R;

import java.util.ArrayList;

public class CourseManager extends Activity implements View.OnClickListener{
    /** VIEWS */
    TextView tvPending, tvJoined, tvAll;
    RecyclerView rcCourse;

    /** STATICS */

    /** ACCESSORIES */
    private ArrayList<com.eways.etutor.Model.Course.Course> mListCourse ;
    private ArrayList<com.eways.etutor.Model.Course.Course> mListCourseShow;
    private CourseManagerAdapter mCourseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_manager);

        declare_views();
        handle_views();

    }

    private void declare_views(){
        tvPending = findViewById(R.id.tv_pending);
        tvJoined = findViewById(R.id.tv_joined);
        tvAll = findViewById(R.id.tv_all);

    }

    private void handle_views(){

        tvJoined.setOnClickListener(this);
        tvPending.setOnClickListener(this);
        tvAll.setOnClickListener(this);
        rcCourse = findViewById(R.id.rc_course_manager);

        setUpListCourse();
    }

    //set filter
    public void filter(int mode){
        switch (mode){
            case 0:

                mListCourseShow.clear();
                mListCourseShow = mListCourse;

                mCourseAdapter.notifyDataSetChanged();
                break;

            case 1:

                for (int i = 0; i < mListCourse.size(); i++){
                    if (Integer.parseInt(mListCourse.get(i).getStatus()) == 0){
                        mListCourseShow.clear();
                        mListCourseShow.add(mListCourse.get(i));

                        mCourseAdapter.notifyDataSetChanged();
                    }
                }
                break;

            case 2:

                for (int i = 0; i < mListCourse.size(); i++){
                    if (Integer.parseInt(mListCourse.get(i).getStatus()) == 1){
                        mListCourseShow.clear();
                        mListCourseShow.add(mListCourse.get(i));

                        mCourseAdapter.notifyDataSetChanged();
                    }
                }
                break;
        }

    }

    private void setUpListCourse(){
        mListCourse = new ArrayList<>();
        mListCourseShow = new ArrayList<>();

        mListCourseShow.add(new com.eways.etutor.Model.Course.Course());

        rcCourse.setHasFixedSize(true);
        LinearLayoutManager lm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mCourseAdapter = new CourseManagerAdapter(mListCourseShow, this);
        rcCourse.setLayoutManager(lm);
        rcCourse.setAdapter(mCourseAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_pending:
                filter(1);

                break;

            case R.id.tv_all:
                filter(0);

                break;

            case R.id.tv_joined:
                filter(2);

                break;
        }
    }
}
