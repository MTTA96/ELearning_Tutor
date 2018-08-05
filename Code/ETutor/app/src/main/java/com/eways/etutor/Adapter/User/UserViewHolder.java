package com.eways.etutor.Adapter.User;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.eways.etutor.R;

/**
 * Created by zzzzz on 5/27/2018.
 */

public class UserViewHolder extends RecyclerView.ViewHolder {

    public LinearLayout vUser;
    public ImageView userAvatar;
    public TextView tvName,tvSubject, tvSkype;
    public RatingBar rtbRating;
    public Button btnRequest;

    public UserViewHolder(View itemView) {
        super(itemView);

        vUser = (LinearLayout) itemView.findViewById(R.id.view_item_user_list);
        userAvatar = (ImageView)itemView.findViewById(R.id.avatar_item_user_list);
        tvName = (TextView)itemView.findViewById(R.id.user_name_item_user_list);
        tvSubject = (TextView)itemView.findViewById(R.id.subject_item_user_list);
        tvSkype = itemView.findViewById(R.id.skype_item_user_list);
//        rtbRating = (RatingBar)itemView.findViewById(R.id.rtb_item_user_list);
        btnRequest = itemView.findViewById(R.id.btn_request_tutor_item);

    }
}
