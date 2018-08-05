package com.eways.etutor.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.eways.etutor.R;

/**
 * Created by ADMIN on 7/6/2018.
 */

public class ImageSpecVHolder extends RecyclerView.ViewHolder {
    TextView tvTitle;
    ImageView ivEditTitle;
    ImageView ivEditVideo, ivMini;
    View areaVideo, areaImage;
    VideoView video;
    RecyclerView rcImage;

    public ImageSpecVHolder(View itemView) {
        super(itemView);

        tvTitle = itemView.findViewById(R.id.title);
        ivEditVideo = itemView.findViewById(R.id.btn_edit_video);
        video = itemView.findViewById(R.id.video);
        rcImage = itemView.findViewById(R.id.rc_item_subject);
        ivMini = itemView.findViewById(R.id.btn_mini);
        areaVideo = itemView.findViewById(R.id.area_video);
        areaImage = itemView.findViewById(R.id.subject_image);
    }
}
