package com.eways.etutor.Views.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eways.etutor.Adapter.Favorite.FavoriteAdapter;
import com.eways.etutor.Model.Favorite;
import com.eways.etutor.R;
import com.eways.etutor.Utils.FileUtils;
import com.eways.etutor.Utils.params.GlobalParams;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFavorite extends Fragment {

    /* VIEWS */
    RecyclerView rcFavorite;

    public FragmentFavorite() {
        // Required empty public constructor
    }

    public static FragmentFavorite newInstance() {
        
        Bundle args = new Bundle();
        
        FragmentFavorite fragment = new FragmentFavorite();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_favorite, container, false);

        declareViews(root);
        handleViews();

        return root;
    }

    public void declareViews(View root){
        rcFavorite = root.findViewById(R.id.list_favorite);

    }

    public void handleViews(){
        setUpListFavorite();
    }

    public void setUpListFavorite(){
        try {
            JSONArray jsonArray = new JSONArray(FileUtils.loadJSONFromAsset(getContext(), "favorite.json"));
            ArrayList<Favorite> listFavorite = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++){
                listFavorite.add(GlobalParams.getInstance().getGSon().fromJson(jsonArray.getJSONObject(i).toString(), Favorite.class));
            }

            FavoriteAdapter favoriteAdapter = new FavoriteAdapter(listFavorite, R.layout.item_favorite);
            rcFavorite.hasFixedSize();
            rcFavorite.setLayoutManager(new GridLayoutManager(getContext(), 2));
            rcFavorite.setAdapter(favoriteAdapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
