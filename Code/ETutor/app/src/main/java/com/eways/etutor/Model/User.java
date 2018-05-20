package com.eways.etutor.Model;

import android.util.Log;

import com.eways.etutor.Interfaces.DataCallBack;
import com.eways.etutor.Network.BaseResponse;
import com.eways.etutor.Network.UserServicesImp;
import com.eways.etutor.Utils.Api.ApiUtils;
import com.eways.etutor.Utils.SupportKey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ADMIN on 3/25/2018.
 */

public class User {
    @SerializedName("Uid")
    @Expose
    private String uid;
    @SerializedName("Password")
    @Expose
    private String password;
    @SerializedName("Avatar")
    @Expose
    private String avatar;
    @SerializedName("FirstName")
    @Expose
    private String firstName;
    @SerializedName("LastName")
    @Expose
    private String lastName;
    @SerializedName("Sex")
    @Expose
    private String sex;
    @SerializedName("Birthday")
    @Expose
    private String birthday;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("Phone")
    @Expose
    private String phone;
    @SerializedName("Skype")
    @Expose
    private String skype;
    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("Degree")
    @Expose
    private String degree;
    @SerializedName("Career")
    @Expose
    private String career;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("Verification")
    @Expose
    private String verification;
    @SerializedName("Authorization")
    @Expose
    private String authorization;
    @SerializedName("DateRegistered")
    @Expose
    private String dateRegistered;

    public User() {
        this.password = "";
        this.avatar = "";
        this.firstName = "";
        this.lastName = "";
        this.sex = "";
        this.birthday = "";
        this.email = "";
        this.phone = "";
        this.skype = "";
        this.address = "";
        this.degree = "";
        this.career = "";
        this.status = "";
        this.verification = "";
        this.authorization = "";
        this.dateRegistered = "";
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVerification() {
        return verification;
    }

    public void setVerification(String verification) {
        this.verification = verification;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public String getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(String dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    /** MARK: - METHODS */

    /** Sign up*/
    public static void signUp(String jsonData, final DataCallBack dataCallBack) {
        UserServicesImp userServices = ApiUtils.userServices();
        userServices.signup(jsonData).enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                Log.d("signUpFirebase:", call.request().toString());
                if (response.body().getErrorCode() == 200)
                    if (response.body().getStatus().compareTo("Success") == 0) {
                        dataCallBack.dataCallBack(SupportKey.SUCCESS_CODE, null);
                        return;
                    }
                dataCallBack.dataCallBack(SupportKey.FAILED_CODE, null);
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                dataCallBack.dataCallBack(SupportKey.FAILED_CODE, null);
            }
        });
    }

    /** Sign in */

    /** Check phone's status to know if it existing in database when signing up */
    public static void checkPhoneNumber(String phoneNumber, DataCallBack dataCallBack) {
        UserServicesImp userServicesImp = ApiUtils.userServices();
//        userServicesImp.checkPhoneNumber(phoneNumber).en
    }

}

