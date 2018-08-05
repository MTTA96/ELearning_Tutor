package com.eways.etutor.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.eways.etutor.R;

/**
 * Created by ADMIN on 7/6/2018.
 */

public class ImageSubjectVHolder extends RecyclerView.ViewHolder {
    ImageView ivSubject;

    public ImageSubjectVHolder(View itemView) {
        super(itemView);

        ivSubject = itemView.findViewById(R.id.iv_sucject);

    }
}
