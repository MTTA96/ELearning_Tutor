package com.eways.etutor.Adapter.Request;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eways.etutor.Model.Requestion;
import com.eways.etutor.R;
import com.eways.etutor.Utils.Handler.ImageHandler;

import java.util.ArrayList;

/**
 * Created by ADMIN on 6/17/2018.
 */

public class RequestAdapter extends RecyclerView.Adapter<RequestVHolder> {
    Activity activity;
    ArrayList<Requestion> mListRequest;

    ImageHandler imageHandler;


    public RequestAdapter(Activity activity, ArrayList mListRequest) {
        this.activity = activity;
        this.mListRequest = mListRequest;

        imageHandler = new ImageHandler(activity);
    }

    @Override
    public RequestVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_request,parent,false);
        return new RequestVHolder(view);
    }

    @Override
    public void onBindViewHolder(RequestVHolder holder, int position) {
        final Requestion mRequest = mListRequest.get(position);

//        imageHandler.loadImageRound(mRequest.getAvatar(), holder.avarta);
//        holder.tutorName.setText(mRequest.getFirstName() + " " + mRequest.getLastName());

//        holder.tvMore.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ActivityUtils.ChangeActivity(activity, InfoUserViewerActivity.class);
//            }
//        });
//
//        holder.btnConfirm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return mListRequest.size();
    }
}
