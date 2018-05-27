package com.eways.etutor.Network.Services;

import com.eways.etutor.Network.BaseResponse;
import com.eways.etutor.Network.ListResponse;
import com.eways.etutor.Utils.ServerUrl;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by zzzzz on 5/22/2018.
 */

public interface ETutorServicesImp {

    /** Search */
    @POST(ServerUrl.SEARCH_URL)
    @FormUrlEncoded
    Call<ListResponse> search(@Field("mydata") String data);

    /** Search suggestions */
    @POST(ServerUrl.SEARCH_SUGGESTIONS_URL)
    @FormUrlEncoded
    Call<ListResponse> searchSuggestions(@Field("mydata") String condition);
}
