package com.eways.etutor.Network;

import com.eways.etutor.Network.Services.ETutorServicesImp;
import com.eways.etutor.Network.Services.UserServicesImp;

/**
 * Created by zzzzz on 3/13/2018.
 */

public class ApiUtils {
    public static final String BASE_URL = ServerUrl.ServerAPIURL;

    /** ETutor services */
    public static ETutorServicesImp eTutorServices() {
        return RetrofitClient.getClient(BASE_URL).create(ETutorServicesImp.class);
    }

    /** User services */
    public static UserServicesImp userServices() {
        return RetrofitClient.getClient(BASE_URL).create(UserServicesImp.class);
    }

}
