package com.eways.etutor.Model;

import android.os.Bundle;
import android.util.Log;

import com.eways.etutor.Interfaces.DataCallBack;
import com.eways.etutor.Network.ApiUtils;
import com.eways.etutor.Network.ListResponse;
import com.eways.etutor.Network.Services.CourseServicesImp;
import com.eways.etutor.Network.Services.ETutorServicesImp;
import com.eways.etutor.Utils.SupportKey;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by zzzzz on 5/22/2018.
 */

public class SearchResults {

    /** METHODS */

    /** Sign in */
    public static void search(String keyWord, String filters, final DataCallBack dataCallBack) {
        ETutorServicesImp eTutorServicesImp = ApiUtils.eTutorServices();
        String param = "{\"TutorName\":\"" + keyWord + "\",\"SubjectName\":\"" + keyWord + "\",\"CourseType\":\""+ 0 +"\"}";
        eTutorServicesImp.search(param).enqueue(new Callback<ListResponse>() {
            @Override
            public void onResponse(Call<ListResponse> call, Response<ListResponse> response) {
                Log.d("search:", call.request().toString());
                // Handle errors
                if (!response.isSuccessful()) {
                    Log.d("search:", " Connect Failed");
                    dataCallBack.dataCallBack(SupportKey.FAILED_CODE, null);
                    return;
                }

                // Get data success
                // Prepare data
                Bundle bundle = new Bundle();
                bundle.putSerializable(null, (Serializable) response.body().getListC());
                dataCallBack.dataCallBack(SupportKey.SUCCESS_CODE, bundle);
            }

            @Override
            public void onFailure(Call<ListResponse> call, Throwable t) {
                Log.d("search:", "Connect Failed");
                dataCallBack.dataCallBack(SupportKey.FAILED_CODE, null);
            }
        });
    }

    /** Search all suggestions */
    public static void searchSuggestions(String keyWord, String filters, final DataCallBack dataCallBack) {
        ETutorServicesImp eTutorServicesImp = ApiUtils.eTutorServices();
        String condition = "{\"TutorName\":\"" + keyWord + "\",\"SubjectName\":\"" + keyWord + "\",\"CourseType\":\""+ 0 +"\"}";
        eTutorServicesImp.searchSuggestions(condition).enqueue(new Callback<ListResponse>() {
            @Override
            public void onResponse(Call<ListResponse> call, Response<ListResponse> response) {
                Log.d("searchSuggestions:", call.request().toString());
                // Handle errors
                if (!response.isSuccessful()) {
                    Log.d("searchSuggestions:", " Connect Failed");
                    dataCallBack.dataCallBack(SupportKey.FAILED_CODE, null);
                    return;
                }

                // Get data success
                // Prepare data
                Bundle bundle = new Bundle();
                bundle.putSerializable(null, (Serializable) response.body().getListC());
                dataCallBack.dataCallBack(SupportKey.SUCCESS_CODE, bundle);
            }

            @Override
            public void onFailure(Call<ListResponse> call, Throwable t) {
                Log.d("searchSuggestions:", "Connect Failed");
                dataCallBack.dataCallBack(SupportKey.FAILED_CODE, null);
            }
        });
    }
}
