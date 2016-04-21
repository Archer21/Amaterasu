package com.archer.amaterasu.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.archer.amaterasu.R;
import com.archer.amaterasu.common.BaseFragment;
import com.archer.amaterasu.io.ApiAdapter;
import com.archer.amaterasu.io.model.SongResponse;
import com.archer.amaterasu.ui.adapter.TopSongsAdapter;

import butterknife.Bind;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopSongsFragment extends BaseFragment {

    public static final String LOG_TAG = TopSongsFragment.class.getSimpleName();
    private boolean isFirstTime = true;
    private static final int NUM_COLS = 2;
    private TopSongsAdapter topSongsAdapter;

    @Bind(R.id.recycler_list_container)
    RecyclerView recyclerList;


    @Override
    public void onResume() {
        super.onResume();
        if(isFirstTime){
            getApiSongsData();
            isFirstTime = false;
            Log.e(LOG_TAG, "Calling Data for first time");
        } else {
            Log.e(LOG_TAG, "Data is current visible");
        }
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupListConfiguration();
    }





    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_top_songs;
    }

    private void setupListConfiguration(){
        topSongsAdapter = new TopSongsAdapter(CONTEXT);
        recyclerList.setLayoutManager(new GridLayoutManager(getActivity(), NUM_COLS));
        recyclerList.setAdapter(topSongsAdapter);
    }

    private void getApiSongsData(){
        Call<SongResponse> call = ApiAdapter.getApiService().getSongs();
        call.enqueue(new Callback<SongResponse>() {
            @Override
            public void onResponse(Response<SongResponse> response) {
                topSongsAdapter.addAll(response.body().getSongs());
//                Log.e(LOG_TAG, response.body().getSongs().toString());
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });
    }

//    private void setDummieContent(){
//        ArrayList<Song> songs = new ArrayList<>();
//        for (int i = 0; i < 9; i++) {
//            Song ignite = new Song();
//            ignite.setSongImage("http://www.generasia.com/w/images/thumb/c/cf/Eir_Aoi_-_Ignite_(Regular_Edition_CD_Only).jpg/300px-Eir_Aoi_-_Ignite_(Regular_Edition_CD_Only).jpg");
//            ignite.setSongTitle("Ignite");
//            ignite.setSongRating(1.5f);
//            ignite.setSongPlaycount(4356);
//            ignite.setSongListeners(120125);
//            songs.add(ignite);
//        }
//        topSongsAdapter.addAll(songs);
//    }
}
















