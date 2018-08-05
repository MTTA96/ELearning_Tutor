package com.eways.etutor.Network.Services;

import com.eways.etutor.Network.Responses.BaseResponse;
import com.eways.etutor.Network.Responses.User.SignInResponse;
import com.eways.etutor.Network.Responses.User.UserBaseResponse;
import com.eways.etutor.Network.ServerUrl;

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
    @POST(ServerUrl.LOGIN_URL)
    @FormUrlEncoded
    Call<SignInResponse> signIn(@Field("Phone") String userId,
                                @Field("Password") String password);

    /** Sign up */
    @POST(ServerUrl.SIGN_UP_URL)
    @FormUrlEncoded
    Call<BaseResponse> signUp(@Field("request") String request);

    /** Get user info */
    @GET(ServerUrl.GET_USER_INFO_URL)
    Call<UserBaseResponse> getUserDetails(@Query("id") String uID);

    /** Check phone number */
    @GET(ServerUrl.CHECK_PHONE_NUMBER_URL)
    Call<BaseResponse> checkPhoneNumber(@Query("phone") String phone);

    /** Add favorite */
//    @POST(ServerUrl.ADD_USER_FAVORITE_URL)
//    @FormUrlEncoded
//    Call<BaseResponse> addUserFavoriteUrl(@Field("uID") String data,
//                                          @Field("listFavoriteSubject") ArrayList<String> listFavorite);
//
    /** Get favorite subject */
//    @GET(ServerUrl.GET_USER_FAVORITE_SUBJECTS)
//    Call<UserFavoriteSubjectResponse> getUserFavoriteSubjects(@Query("Uid") String uID);

    /** Send requisition */
    @POST(ServerUrl.SEND_REQUEST_URL)
    @FormUrlEncoded
    Call<BaseResponse> sendRequest(@Field("request") String request);

}
