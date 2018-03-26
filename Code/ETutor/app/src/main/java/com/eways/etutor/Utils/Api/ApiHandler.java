package com.eways.etutor.Utils.Api;

import com.eways.etutor.Model.Teacher;
import com.eways.etutor.Model.Teacher_;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ADMIN on 3/18/2018.
 */

public interface ApiHandler {
    //Get user by id
    @GET("/API/User/Teacher/GetTeacherByUid.php")
    Call<Teacher> getUserById(@Query("Uid") String uid);
}
