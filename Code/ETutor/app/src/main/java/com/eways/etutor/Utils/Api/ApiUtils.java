package com.eways.etutor.Utils.Api;

import retrofit2.Retrofit;

/**
 * Created by ADMIN on 3/18/2018.
 */

public class ApiUtils {
    public static final String BASE_URL = "https://ewayslearn.000webhostapp.com";

    public static ApiHandler getUserById(){
        return Client.getClient(BASE_URL).create(ApiHandler.class);
    }
}
