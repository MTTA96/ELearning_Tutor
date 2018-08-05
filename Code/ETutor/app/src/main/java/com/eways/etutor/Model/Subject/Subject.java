package com.eways.etutor.Model.Subject;

import android.util.Log;

import com.eways.etutor.Interfaces.DataCallback.Subject.TrendingSubjectCallBack;
import com.eways.etutor.Network.ApiUtils;
import com.eways.etutor.Network.Responses.User.TrendingSubjectResponse;
import com.eways.etutor.Network.Services.ETutorServicesImp;
import com.eways.etutor.Network.Subject.SubjectListCallBack;
import com.eways.etutor.Utils.SupportKeys;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by zzzzz on 5/31/2018.
 */

public class Subject {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("subject_name")
    @Expose
    private String subjectName;
    @SerializedName("image")
    @Expose
    private String image;

    public Subject(String subjectName, String idSubject, String img) {
        this.subjectName = subjectName;
        this.id = idSubject;
        this.image = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    /** METHODS */

    /** Get subject list */
    public static void getSubjectList(final SubjectListCallBack subjectListCallBack) {

        ETutorServicesImp eLearningServicesImp = ApiUtils.eTutorServices();
        eLearningServicesImp.getSubjectList().enqueue(new Callback<ArrayList<Subject>>() {
            @Override
            public void onResponse(Call<ArrayList<Subject>> call, Response<ArrayList<Subject>> response) {
                // handle error
                if (!response.isSuccessful()) {
                    Log.d("subjectListModel:", "connect failed");
                    subjectListCallBack.subjectListCallBack(SupportKeys.FAILED_CODE, null);
                    return;
                }

                // Prepare data
                subjectListCallBack.subjectListCallBack(SupportKeys.SUCCESS_CODE, response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Subject>> call, Throwable t) {
                Log.d("subjectListModel:", t.getLocalizedMessage());
                subjectListCallBack.subjectListCallBack(SupportKeys.FAILED_CODE, null);
            }
        });

    }

}
