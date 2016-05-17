package com.archer.amaterasu.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.archer.amaterasu.R;
import com.archer.amaterasu.common.BaseFragment;
import com.archer.amaterasu.common.BasePresenter;
import com.archer.amaterasu.domain.Artist;
import com.archer.amaterasu.io.ApiAdapter;
import com.archer.amaterasu.io.model.ArtistResponse;
import com.archer.amaterasu.ui.activity.ArtistDetailActivity;
import com.archer.amaterasu.ui.adapter.TopArtistAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopArtistFragment extends BaseFragment {

    private static final String LOG_TAG = TopArtistFragment.class.getSimpleName();
//    @Bind(R.id.recycler_artist_list)
//    RecyclerView topArtistRecyclerList;

    RecyclerView recyclerList;

    private TopArtistAdapter topArtistAdapter;
    private boolean isFirstCall = true;

    public TopArtistFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        topArtistAdapter = new TopArtistAdapter(getActivity(), new TopArtistAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Artist item) {
                Intent intent = new Intent(CONTEXT, ArtistDetailActivity.class);
                intent.putExtra("NAME", item.getName());
                startActivity(intent);
            }
        });

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerList = (RecyclerView) view.findViewById(R.id.recycler_artist_list);
        setupList();
//        setDummieContent();
    }

    public void callData(){
        Call<ArtistResponse> call = ApiAdapter.getApiService().getArtists();
        call.enqueue(new Callback<ArtistResponse>() {
            @Override
            public void onResponse(Response<ArtistResponse> response) {
                topArtistAdapter.addAll(response.body().getArtists());
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isFirstCall){
            callData();
            isFirstCall = false;
            Log.e(LOG_TAG, "Loading data");
        } else {
            Log.e(LOG_TAG, "Data is current loaded");
        }
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_top_artist;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    public void setupList(){
        recyclerList.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerList.setAdapter(topArtistAdapter);
    }

//    private void setDummieContent(){
//        ArrayList<Artist> artists= new ArrayList<>();
//        for (int i = 0; i < 9; i++) {
//            Artist ignite = new Artist();
//            ignite.setCover("http://www.generasia.com/w/images/thumb/c/cf/Eir_Aoi_-_Ignite_(Regular_Edition_CD_Only).jpg/300px-Eir_Aoi_-_Ignite_(Regular_Edition_CD_Only).jpg");
//            ignite.setName("Ignite");
//            ignite.setRating(1.5f);
//            ignite.setVotes(4356);
//            artists.add(ignite);
//        }
//        topArtistAdapter.addAll(artists);
//    }
}
















