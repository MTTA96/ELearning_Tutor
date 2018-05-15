package com.eways.etutor.Utils;


import com.eways.etutor.Network.RetrofitClient;
import com.eways.etutor.Network.UserServicesImp;

/**
 * Created by zzzzz on 3/13/2018.
 */

public class ApiUtils {
    public static final String BASE_URL = ServerUrl.ServerAPIURL;

    public static UserServicesImp userServices() {
        return RetrofitClient.getClient(BASE_URL).create(UserServicesImp.class);
    }
}
