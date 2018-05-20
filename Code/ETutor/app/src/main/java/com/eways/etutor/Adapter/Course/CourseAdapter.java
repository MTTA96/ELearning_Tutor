package com.eways.etutor.Adapter.Course;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eways.etutor.Model.Course;
import com.eways.etutor.R;

import java.util.ArrayList;

/**
 * Created by ADMIN on 5/19/2018.
 */

public class CourseAdapter extends RecyclerView.Adapter<CourseVHolder> {
    ArrayList<Course> listCourse ;
    int res;

    public CourseAdapter(ArrayList<Course> listCourse, int res) {
        this.listCourse = listCourse;
        this.res = res;
    }

    @Override
    public CourseVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_course,parent,false);
        return new CourseVHolder(view);
    }

    @Override
    public void onBindViewHolder(CourseVHolder holder, int position) {
        Course course = listCourse.get(position);

        holder.studentName.setText(course.getFirstName() + course.getLastName());
        holder.subject.setText(course.getSubjectName());

        //check time and set status
        //do it later

    }

    @Override
    public int getItemCount() {
        return listCourse.size();
    }

}
