package com.eways.etutor.Network;

import com.eways.etutor.Utils.ServerUrl;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


/**
 * Created by zzzzz on 3/13/2018.
 */

public interface UserServicesImp {
    /** Sign in */
    @GET(ServerUrl.LOGIN_URL)
    Call<BaseUserResponse> login(@Query("Uid") String userId);

    /** Sign up */
    @POST(ServerUrl.SIGN_UP_URL)
    @FormUrlEncoded
    Call<BaseResponse> signup(@Field("mydata") String data);
}
