package com.eways.etutor.views;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.eways.etutor.Adapter.DialogImageAdapter;
import com.eways.etutor.Fragment.FragmentUserInfo;
import com.eways.etutor.Fragment.FragmentUpdateDetail;
import com.orhanobut.dialogplus.DialogPlusBuilder;
import com.orhanobut.dialogplus.GridHolder;
import com.orhanobut.dialogplus.OnItemClickListener;

import static android.app.Activity.RESULT_OK;

/**
 * Created by ADMIN on 4/23/2018.
 */

public class DialogPlus {
    Activity activity;
    ArrayAdapter arrayAdapter;
    FragmentUpdateDetail fragment;

    int position;

    int requestCode;
    String[] permissions;
    int[] grantResults;

    private com.orhanobut.dialogplus.DialogPlus dialogPlus;

    public static int REQUEST_CODE_CAMERA=0;
    public static int REQUEST_CODE_GALLERY=1;

    public DialogPlus(Activity activity, ArrayAdapter arrayAdapter, FragmentUpdateDetail fragment) {
        this.activity = activity;
        this.arrayAdapter = arrayAdapter;
        this.fragment = fragment;
    }

    public DialogPlus(FragmentActivity activity, DialogImageAdapter dialogImageAdapter, FragmentUserInfo fragmentSignUpDetail) {
    }

    public void showDialog(){
        DialogPlusBuilder dialog = com.orhanobut.dialogplus.DialogPlus.newDialog(activity);
        dialog.setContentHolder(new GridHolder(2));
        dialog.setContentHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setAdapter(arrayAdapter);

        dialog.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(com.orhanobut.dialogplus.DialogPlus dialog, Object item, View view, int position) {
                if (position==0){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        fragment.requestPermissions(new String[]{Manifest.permission.CAMERA},REQUEST_CODE_CAMERA);
                    }
                }
                if (position==1){
                    Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                    fragment.startActivityForResult(intent,REQUEST_CODE_GALLERY);
                }

            }
        });
        dialogPlus=dialog.create();
        dialogPlus.show();

//        this.position = position;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data, ImageView imageView){
        if (requestCode == REQUEST_CODE_CAMERA && resultCode == RESULT_OK && data!= null){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

            //load image circle by picasso
        }
        if (requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null) {

            //load image circle by picasso
        }
    }

    public int getPosition() {
        return position;
    }
}
