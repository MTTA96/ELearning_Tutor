package com.eways.etutor.Presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.eways.etutor.Interfaces.DataCallBack;
import com.eways.etutor.Model.Course;
import com.eways.etutor.Model.SearchResults;
import com.eways.etutor.Utils.SupportKey;

/**
 * Created by ADMIN on 5/20/2018.
 */

public class HomePresenter implements DataCallBack {
    private DataCallBack dataCallBack;

    public HomePresenter(DataCallBack dataCallBack) {
        this.dataCallBack = dataCallBack;
    }

    /** Search courses */
    public void searchCorese(String keyWord, String filter) {
        SearchResults.searchSuggestions(keyWord, filter, this);
    }

    /** Handle data from server */
    @Override
    public void dataCallBack(int result, @Nullable Bundle bundle) {
        // Handle errors
        if (result == SupportKey.FAILED_CODE) {
            dataCallBack.dataCallBack(result, null);
            return;
        }

        // Get data success
        dataCallBack.dataCallBack(result, bundle);
    }
}
