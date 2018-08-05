package com.eways.etutor.Adapter.Home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.eways.etutor.R;

/**
 * Created by ADMIN on 5/28/2018.
 */

public class HomeVHolder extends RecyclerView.ViewHolder{
    /* VIEWS */
    ImageView ivHomeDetail;
    TextView tvTitle;

    public HomeVHolder(View itemView) {
        super(itemView);

        ivHomeDetail = itemView.findViewById(R.id.iv_home_detail);
        tvTitle = itemView.findViewById(R.id.tv_title);
    }
}
