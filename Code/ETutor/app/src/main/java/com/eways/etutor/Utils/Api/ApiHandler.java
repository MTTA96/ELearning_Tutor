package com.eways.etutor.Utils.Api;

import com.eways.etutor.Model.UserBaseResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by ADMIN on 3/18/2018.
 */

public interface ApiHandler {
    //Get user by id
    @GET("/API/GetTeacherByUid.php")
    Call<UserBaseResponse> getUserById(@Query("Uid") String uid);

    @POST("/API/AddNewUser.php")
    Call<UserBaseResponse> addRawUser(@Field("Uid") String uid, @Field("FirstName") String firstName, @Field("Phone") String phone);

}
