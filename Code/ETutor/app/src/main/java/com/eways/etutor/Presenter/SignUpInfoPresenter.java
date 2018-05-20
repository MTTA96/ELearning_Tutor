package com.eways.etutor.Presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.eways.etutor.Interfaces.DataCallBack;
import com.eways.etutor.Model.User;
import com.eways.etutor.Utils.SupportKey;
import com.google.gson.Gson;

/**
 * Created by zzzzz on 5/13/2018.
 */

public class SignUpInfoPresenter implements DataCallBack {
    private DataCallBack dataCallBack;

    public SignUpInfoPresenter(DataCallBack dataCallBack) {
        this.dataCallBack = dataCallBack;
    }

    /** Sign up */
    public void signUp(User user) {
        Gson gson = new Gson();

        // Parse obj to json
        String jsonData = gson.toJson(user);

        // Send to server
        User.signUp(jsonData, this);
    }

    /** handle results from database */
    @Override
    public void dataCallBack(int result, @Nullable Bundle bundle) {
        // handle error
        if (result == SupportKey.FAILED_CODE) {
            dataCallBack.dataCallBack(result, null);
            return;
        }

        // handle data
        dataCallBack.dataCallBack(result, bundle);
    }

}
