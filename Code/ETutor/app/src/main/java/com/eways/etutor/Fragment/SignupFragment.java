package com.eways.etutor.Fragment;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eways.etutor.Activity.CourseActivity;
import com.eways.etutor.Adapter.Circle.CircleAdapter;
import com.eways.etutor.Adapter.SignUpPagerAdapter;
import com.eways.etutor.FragmentWelcome;
import com.eways.etutor.Model.Circle;
import com.eways.etutor.R;
import com.eways.etutor.views.NonSwipeableViewPager;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignupFragment extends Fragment implements View.OnClickListener {

    /* VIEWS */
    NonSwipeableViewPager viewPager;
    SignUpPagerAdapter signUpPagerAdapter;
    AppBarLayout barLayout;
    LinearLayout btnBack, btnNext;
    TextView tvBack, tvNext;
    RecyclerView listCircle;
    android.support.v7.widget.Toolbar toolbar;

    private int curPosition = 0;
    CircleAdapter circleAdapter;
    ArrayList<Circle> circles;
    ArrayList<Fragment> listFragment;


    public SignupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_signup, container, false);

        declare_views(root);
        handle_views();
        return root;
    }

    private void handle_views() {
        setUpViewPager();

        btnNext.setOnClickListener(this);
        btnBack.setOnClickListener(this);

        circles = new ArrayList<>();
        circleAdapter = new CircleAdapter(getActivity(), circles);
        listCircle.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true));
        listCircle.setAdapter(circleAdapter);
    }


    private void declare_views(View root) {
        viewPager = root.findViewById(R.id.view_pager);

        barLayout = (AppBarLayout) root.findViewById(R.id.appBarLayout);
        btnBack = root.findViewById(R.id.btn_back);
        btnNext = root.findViewById(R.id.btn_next);
        tvBack = root.findViewById(R.id.tv_back);
        tvNext = root.findViewById(R.id.tv_next);
        toolbar = root.findViewById(R.id.toolbar);
        listCircle = root.findViewById(R.id.list_circle);

    }

    public void setUpViewPager() {
        FragmentManager manager = getFragmentManager();
        listFragment = new ArrayList<>();
        listFragment.add(new FragmentRules());
        listFragment.add(new FragmentEnterPhone());
        listFragment.add(new FragmentVerify());
        listFragment.add(new FragmentUserInfo());
        listFragment.add(new FragmentWelcome());
        signUpPagerAdapter = new SignUpPagerAdapter(manager, listFragment);
        viewPager.setAdapter(signUpPagerAdapter);
        setUpParallexView(barLayout, 0);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                curPosition = position;
                setUpParallexView(barLayout, position);



                if (position == listFragment.size() - 1) {
                    tvNext.setText(getString(R.string.finish));
                    curPosition = position;
                }
                if (position < listFragment.size() - 1 && position > -1){
                    tvNext.setText(getString(R.string.next));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }



    //Set up parallex view
    public void setUpParallexView(AppBarLayout appBarLayout, int mode) {
        if (mode == listFragment.size() - 1){
            appBarLayout.setExpanded(false, true);

        }else {
            appBarLayout.setExpanded(true, true);
        }

    }

    //check email valid
    public boolean checkEmail(String mail){
        String[] array = mail.split("@");
        if (array[array.length - 1].compareTo(".com") == 0){
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                if (curPosition > 0) {
                    if (curPosition == listFragment.size() - 1){
                        viewPager.setCurrentItem(curPosition - 1);
                        return;
                    }
                    viewPager.setCurrentItem(curPosition - 1);
                } else {
                    return;
                }
                break;
            case R.id.btn_next:
                if (curPosition < listFragment.size() - 1) {
                    viewPager.setCurrentItem(curPosition + 1);


                } else {
                    if (curPosition == listFragment.size() - 1 ){
                        startActivity(new Intent(getActivity(), CourseActivity.class));
                        getActivity().finish();
                    }
                    return;
                }
                break;
        }
    }

    public void setUpListCircle(int countCircle){

        for (int i = 0; i < countCircle; i++){
            circles.add(new Circle(R.drawable.circle_full, R.drawable.circle_empty));
        }
        circleAdapter.notifyDataSetChanged();

    }
}
