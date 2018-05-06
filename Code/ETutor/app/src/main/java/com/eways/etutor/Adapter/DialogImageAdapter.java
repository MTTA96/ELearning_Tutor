package com.eways.etutor.Adapter;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eways.etutor.Model.ImageDialogPlus;
import com.eways.etutor.R;

import java.util.ArrayList;

/**
 * Created by ADMIN on 4/23/2018.
 */

public class DialogImageAdapter extends ArrayAdapter  {
    Activity mActivity;
    ArrayList<ImageDialogPlus> imageList;
    int res;
    public DialogImageAdapter(@NonNull Activity activity, int resource, @NonNull ArrayList<ImageDialogPlus> objects) {
        super(activity, resource, objects);
        mActivity = activity;
        res = resource;
        imageList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=mActivity.getLayoutInflater();
        convertView=inflater.inflate(res,null);
        final ImageDialogPlus imageDialogPlus = imageList.get(position);
        ImageView ivImageSelect =(ImageView) convertView.findViewById(R.id.Image);
        TextView tvTitle=(TextView) convertView.findViewById(R.id.Title);
        LinearLayout layoutImage =(LinearLayout) convertView.findViewById(R.id.layout_image);
        ivImageSelect.setBackgroundResource(imageDialogPlus.getImage());
        tvTitle.setText(imageDialogPlus.getContent());
        return convertView;
    }


}
