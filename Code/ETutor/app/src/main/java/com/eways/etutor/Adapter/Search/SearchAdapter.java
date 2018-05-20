package com.eways.etutor.Adapter.Search;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eways.etutor.Adapter.Favorite.FavoriteViewHolder;
import com.eways.etutor.Model.Course;
import com.eways.etutor.R;

import java.util.ArrayList;

/**
 * Created by ADMIN on 5/20/2018.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchVHolder> {
    ArrayList<Course> listCourse;
    int res;

    public SearchAdapter(ArrayList<Course> listCourse, int res) {
        this.listCourse = listCourse;
        this.res = res;
    }

    @Override
    public SearchVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_search,parent,false);
        return new SearchVHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchVHolder holder, int position) {
        Course course = listCourse.get(position);

        //load image with picasso here

        holder.nameStudent.setText(course.getName());
        holder.subject.setText(course.getSubject());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
