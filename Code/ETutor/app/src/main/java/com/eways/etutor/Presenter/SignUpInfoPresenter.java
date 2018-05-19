package com.eways.etutor.Presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.eways.etutor.Interfaces.DataCallBack;
import com.eways.etutor.Model.User;
import com.google.gson.Gson;

/**
 * Created by zzzzz on 5/13/2018.
 */

public class SignUpInfoPresenter implements DataCallBack {
    private DataCallBack dataCallBack;

    public SignUpInfoPresenter(DataCallBack dataCallBack) {
        this.dataCallBack = dataCallBack;
    }

    /** Sign up*/
    public void signUp(User user) {
        Gson gson = new Gson();

        // Parse obj to json
        String jsonData = gson.toJson(user);

        // Send to server
        User.signUp(jsonData, this);
    }

    @Override
    public void dataCallBack(String result, @Nullable Bundle bundle) {
        if (result.compareTo("Success") == 0) {
            dataCallBack.dataCallBack(result, null);
            return;
        }

        dataCallBack.dataCallBack(result, null);
    }

}
