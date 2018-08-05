package com.eways.etutor.Adapter.Home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eways.etutor.Model.Course.Course;
import com.eways.etutor.R;
import com.eways.etutor.Utils.Handler.ImageHandler;
import com.eways.etutor.Utils.params.GlobalParams;

import java.util.ArrayList;

/**
 * Created by ADMIN on 5/30/2018.
 */

public class SubjectItemAdapter extends RecyclerView.Adapter<HomeVHolder>{
    private int res;
    private ArrayList<Course> courses = new ArrayList<>();
    private ImageHandler imageHandler;

    public SubjectItemAdapter(int res, ArrayList<Course> courses) {
        this.res = res;
        this.courses = courses;

        imageHandler = new ImageHandler(GlobalParams.getInstance());
    }

    @Override
    public HomeVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_home_detail,parent,false);
        return new HomeVHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeVHolder holder, int position) {
        final Course course = courses.get(position);
        holder.tvTitle.setText(course.getFirstName() + course.getLastName());

        //méo có hình
    }

    @Override
    public int getItemCount() {
        if (courses != null) {
            return courses.size();
        } else
            return 0;
    }

}
