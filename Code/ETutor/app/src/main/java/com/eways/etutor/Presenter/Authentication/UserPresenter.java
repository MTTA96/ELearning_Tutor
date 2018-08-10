package com.eways.etutor.Presenter.Authentication;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.eways.etutor.Interfaces.DataCallBack;
import com.eways.etutor.Interfaces.DataCallback.CreateCourseCallBack;
import com.eways.etutor.Interfaces.DataCallback.User.SendRequestCallback;
import com.eways.etutor.Interfaces.DataCallback.User.UpdateUserInfoCallBack;
import com.eways.etutor.Interfaces.DataCallback.User.UserCallBack;
import com.eways.etutor.Model.Account.User;
import com.eways.etutor.Model.Request;
import com.eways.etutor.Utils.SharedPreferences.SharedPrefSupportKeys;
import com.eways.etutor.Utils.SharedPreferences.SharedPrefUtils;
import com.eways.etutor.Utils.SupportKeys;
import com.eways.etutor.Views.Activity.MainActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;


/**
 * Created by zzzzz on 7/1/2018.
 */

public class UserPresenter implements UserCallBack, DataCallBack, CreateCourseCallBack, SendRequestCallback, UpdateUserInfoCallBack {

    private Context context;
    private SharedPrefUtils sharedPreferencesUtils;
    private UserCallBack userCallBack;
    private DataCallBack dataCallBack;
    private SendRequestCallback sendRequestCallback;
    private UpdateUserInfoCallBack updateUserInfoCallBack;

    public UserPresenter(Context context) {
        this.context = context;
        sharedPreferencesUtils = new SharedPrefUtils(context, SharedPrefSupportKeys.SHARED_PREF_FILE_NAME);
    }

    /** Sign out */

    public void signOut(DataCallBack dataCallBack) {

        sharedPreferencesUtils.clear();
        dataCallBack.dataCallBack(SupportKeys.SUCCESS_CODE, null);

    }

    /** Get user info */

    public void getUserInfo(String uId, UserCallBack userCallBack) {

        this.userCallBack = userCallBack;

        User.getUserInfo(uId, this);

    }

    public void updateInfo(User user, Uri filePath, UpdateUserInfoCallBack updateUserInfoCallBack) {

        this.updateUserInfoCallBack = updateUserInfoCallBack;
        uploadImage(user, filePath);

    }

    /** Handle request */

    public void sendRequestToTutor(String subjectName, String tutorId, SendRequestCallback sendRequestCallback) {

        this.sendRequestCallback = sendRequestCallback;

        // Prepare data

        Date c = Calendar.getInstance().getTime();

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String sentDate = df.format(c);

//        Request request = new Request(courseId, sharedPreferencesUtils.getString(SharedPrefSupportKeys.UID), sentDate, "", "");
        Request request = new Request(String.valueOf(UUID.randomUUID()),
                sharedPreferencesUtils.getString(SharedPrefSupportKeys.UID),
                tutorId,
                sentDate,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
                );
        Gson gson = new Gson();
        String jsonRequest = gson.toJson(request);

        // Call API

        User.sendRequest(jsonRequest, this);

//        if (courseId != null) {
//            User.sendRequest(jsonRequest, this);
//        } else {
//
//            Course newCourse = new Course();
//            newCourse.setSubjectName(subjectName);
//
//            String jsonCourse = gson.toJson(newCourse);
//
//            Course.createCourse(jsonCourse, this);
//        }

    }

    /** ----- SUPPORTED FUNC ----- */

    private void uploadImage(final User user, Uri filePath) {

        if(filePath != null) {

            FirebaseStorage storage = FirebaseStorage.getInstance();
            StorageReference storageReference = storage.getReference();
            SharedPrefUtils sharedPrefUtils = new SharedPrefUtils(context);
            StorageReference ref = storageReference.child("images/"+ sharedPrefUtils.getString(SharedPrefSupportKeys.UID));

            ref.putFile(filePath)

                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Uri downloadUrl = taskSnapshot.getUploadSessionUri();
                            user.setAvatar(String.valueOf(downloadUrl));
                            Gson gson = new Gson();
                            String jsonRequest = gson.toJson(user);

                            User.updateUserInfo(jsonRequest, UserPresenter.this);
                            
                        }
                    })

                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(context, "Không thể cập nhật hình", Toast.LENGTH_LONG).show();
                        }
                    })

                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
//                            double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
//                                    .getTotalByteCount());
//                            progressDialog.setMessage("Uploaded "+(int)progress+"%");
                        }
                    });

        }
    }


    /** ----- HANDLE RESULT FROM DB ----- */

    /** Get user info */

    @Override
    public void userCallBack(int errorCode, User user) {

        if (errorCode == SupportKeys.FAILED_CODE) {
            userCallBack.userCallBack(errorCode, null);
            return;
        }

        userCallBack.userCallBack(errorCode, user);

    }

    /** Sign out */

    @Override
    public void dataCallBack(int resultCode, @Nullable Bundle bundle) {
        // handle error
        if (resultCode == SupportKeys.FAILED_CODE) {
            dataCallBack.dataCallBack(resultCode, null);
            return;
        }

        // handle data
        dataCallBack.dataCallBack(resultCode, bundle);
    }

    /** Create course */

    @Override
    public void createCourseCallback(int errorCode, String msg) {

        if (errorCode == SupportKeys.FAILED_CODE) {

            sendRequestCallback.sendRequestCallback(SupportKeys.FAILED_CODE, null);
            return;
        }

        User.sendRequest(msg, this);

    }

    /** Send request */

    @Override
    public void sendRequestCallback(int resultCode, @Nullable String msg) {

        // handle error
        if (resultCode == SupportKeys.FAILED_CODE) {
            sendRequestCallback.sendRequestCallback(SupportKeys.FAILED_CODE, null);
            return;
        }

        // handle data
        sendRequestCallback.sendRequestCallback(SupportKeys.SUCCESS_CODE, null);

    }

    @Override
    public void uploadInfoCallBack(int errorCode) {

        // handle error

        if (errorCode == SupportKeys.FAILED_CODE) {
            uploadInfoCallBack(errorCode);
            return;
        }

        // handle data

        uploadInfoCallBack(errorCode);

    }
}
