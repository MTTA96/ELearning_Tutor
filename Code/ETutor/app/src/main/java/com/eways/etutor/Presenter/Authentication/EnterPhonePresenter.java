package com.eways.etutor.Presenter.Authentication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.eways.etutor.Interfaces.DataCallBack;
import com.eways.etutor.Model.User;
import com.eways.etutor.Utils.SupportKey;

/**
 * Created by zzzzz on 5/20/2018.
 */

public class EnterPhonePresenter implements DataCallBack {
    private DataCallBack dataCallBack;

    public EnterPhonePresenter(DataCallBack dataCallBack) {
        this.dataCallBack = dataCallBack;
    }

    /** Check phone's status on server */
    public void checkPhoneStatus(String phoneNumber) {
        User.checkPhoneNumber(phoneNumber, this);
    }

    /** Handle results from database */
    @Override
    public void dataCallBack(int resultCode, @Nullable Bundle bundle) {
        // Handle error
        if (resultCode == SupportKey.FAILED_CODE) {
            dataCallBack.dataCallBack(resultCode, null);
            return;
        }

        // Handle data
        dataCallBack.dataCallBack(resultCode, bundle);
    }
}
