package com.eways.etutor.Views.Activity;

import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.eways.etutor.Adapter.Course.CourseAdapter;
import com.eways.etutor.Adapter.Search.SearchAdapter;
import com.eways.etutor.Interfaces.DataCallBack;
import com.eways.etutor.Model.Course;
import com.eways.etutor.Presenter.HomePresenter;
import com.eways.etutor.R;

import com.eways.etutor.Utils.Handler.FragmentHandler;
import com.eways.etutor.Utils.SupportKey;
import com.eways.etutor.Utils.params.GlobalParams;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, DataCallBack {

    /* VIEWS */
    Toolbar toolbar;
    RelativeLayout content;
    RecyclerView listSearch;

    /** MODELS */
    private HomePresenter homePresenter;

    SearchAdapter searchAdapter;
    ArrayList<Course> listCourse;


    FragmentHandler fragmentHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        declare_views();
        Handle();

        homePresenter = new HomePresenter(this);
    }

    public void Handle(){
//        fragmentHandler = new FragmentHandler(this, R.id.content_course);
//        fragmentHandler.changeFragment(new FragmentUpdateDetail(), SupportKey.UPDATE_DETAILs_FRAGMENT_TAG, 0, 0);
        setUpToolBar();
        listCourse = new ArrayList<>();
        searchAdapter = new SearchAdapter(listCourse, R.layout.item_search);
        listSearch.setLayoutManager(new LinearLayoutManager(getParent(), LinearLayoutManager.VERTICAL, false));
        listSearch.hasFixedSize();
        listSearch.setAdapter(searchAdapter);


    }

    public void declare_views(){
        toolbar = findViewById(R.id.toolbar);
        content = findViewById(R.id.content);
        listSearch = findViewById(R.id.list_search);

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);

        MenuItem mSearch = menu.findItem(R.id.action_search);

        SearchView mSearchView = (SearchView) mSearch.getActionView();
        mSearchView.setQueryHint("Search");

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.compareTo("")==0){
                    listCourse.clear();
                    searchAdapter.notifyDataSetChanged();
                }
                homePresenter.searchCorese(newText, "");
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    public void setUpToolBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void setResultSearch(String tutorName, String subjectName, int courseType){
        final ArrayList<Course> courses = new ArrayList<>();
//        String condition = "{\"TutorName\":\"" + tutorName + "\",\"SubjectName\":\"" + subjectName + "\",\"CourseType\":\""+ courseType +"\"}";
//        apiHandler.getCourseSearch(condition).enqueue(new Callback<String>() {
//            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                if (response.isSuccessful()){
//                    try {
//                        JSONObject jsonObject = new JSONObject(response.body());
//                        if(jsonObject.get("errorCode").toString().compareTo("200") == 0){
//                            JSONArray jsonArray = new JSONArray(jsonObject.get("listC"));
//
//                            for (int i = 0; i < jsonArray.length(); i++){
//                                courses.add(GlobalParams.getInstance().getGSon().fromJson(jsonArray.get(i).toString(), Course.class));
//                            }
//
//                            ArrayList<Course> temp = courses;
//                        }
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//
//            }
//        });

    }

    /** Handle result from server */
    @Override
    public void dataCallBack(int result, @Nullable Bundle bundle) {
        // Handle errors
        if (result == SupportKey.FAILED_CODE) {
            Log.d("Search results:", "failed!");
            return;
        }

        // Get data success
        ArrayList resultsList = (ArrayList) bundle.getSerializable(null);

        if (resultsList.size() > 0) {
            listCourse.clear();
            for (int i = 0; i < resultsList.size(); i++) {

                JsonObject jsonObject = GlobalParams.getInstance().getGSon().toJsonTree(resultsList.get(i)).getAsJsonObject();
                listCourse.add(GlobalParams.getInstance().getGSon().fromJson(jsonObject.toString(), Course.class));

            }
            searchAdapter.notifyDataSetChanged();

        }

    }
}

