package com.eways.etutor.Views.Activity;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.eways.etutor.Adapter.Search.SearchAdapter;
import com.eways.etutor.Interfaces.DataCallBack;
import com.eways.etutor.Model.Course;
import com.eways.etutor.Presenter.HomePresenter;
import com.eways.etutor.R;

import com.eways.etutor.Utils.Handler.FragmentHandler;
import com.eways.etutor.Utils.SupportKey;
import com.eways.etutor.Views.Fragment.HomeFragment;
import com.eways.etutor.Views.Fragment.SearchFragment;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, DataCallBack {

    /** VIEWS */
    Toolbar toolbar;
    RelativeLayout content;
    RecyclerView listSearch;

    /** MODELS */
    private HomePresenter homePresenter;
    private FragmentHandler fragmentHandler;
    private SearchAdapter searchAdapter;
    private ArrayList suggestionsList;

    // Identify current search type
    public static int currentSearchType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        declareViews();
        handle();

        homePresenter = new HomePresenter(this);
    }

    public void declareViews(){
        toolbar = findViewById(R.id.toolbar);
        content = findViewById(R.id.content);
        listSearch = findViewById(R.id.list_search);

    }

    public void handle(){
        fragmentHandler = new FragmentHandler(this, R.id.home_content_view);
        setUpToolBar();
        suggestionsList = new ArrayList<>();
        searchAdapter = new SearchAdapter(suggestionsList, R.layout.item_search);
        listSearch.setLayoutManager(new LinearLayoutManager(getParent(), LinearLayoutManager.VERTICAL, false));
        listSearch.hasFixedSize();
        listSearch.setAdapter(searchAdapter);

        // Move to home
        fragmentHandler.changeFragment(HomeFragment.newInstance(), SupportKey.HOME_FRAGMENT_TAG, 0, 0);
        currentSearchType = SupportKey.SEARCH_SUBJECTS;

    }

    /** EVENTS */

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
                    suggestionsList.clear();
                    searchAdapter.notifyDataSetChanged();
                }
                homePresenter.searchSuggestions(newText);
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    /** handle options menu item selected */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_search) {
            fragmentHandler.changeFragment(SearchFragment.newInstance(), SupportKey.SEARCH_RESULTS_TAG, 0, 0);
        }
        return super.onOptionsItemSelected(item);
    }

    public void setUpToolBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void setResultSearch(String tutorName, String subjectName, int courseType){
        final ArrayList<Course> courses = new ArrayList<>();
//        String condition = "{\"TutorName\":\"" + tutorName + "\",\"SubjectName\":\"" + subjectName + "\",\"CourseType\":\""+ courseType +"\"}";
//        apiHandler.searchSubjectSuggestions(condition).enqueue(new Callback<String>() {
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

    /** handle result from server */
    @Override
    public void dataCallBack(int result, @Nullable Bundle bundle) {
        // handle errors
        if (result == SupportKey.FAILED_CODE) {
            Log.d("Search results:", "search failed!");
            return;
        }

        // Get data success
        ArrayList resultsList = (ArrayList) bundle.getSerializable(null);

        suggestionsList = resultsList;
        searchAdapter.notifyDataSetChanged();
    }
}

