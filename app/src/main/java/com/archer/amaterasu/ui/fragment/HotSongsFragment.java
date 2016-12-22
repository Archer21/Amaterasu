package com.archer.amaterasu.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.archer.amaterasu.R;
import com.archer.amaterasu.common.BaseFragment;
import com.archer.amaterasu.common.BasePresenter;
import com.archer.amaterasu.domain.Song;
import com.archer.amaterasu.io.ApiAdapter;
import com.archer.amaterasu.io.model.SongResponse;
import com.archer.amaterasu.mvp.presenter.HotSongPresenter;
import com.archer.amaterasu.mvp.viewmodel.HotSongsViewModel;
import com.archer.amaterasu.ui.activity.SongDetailActivity;
import com.archer.amaterasu.ui.adapter.HotSongAdapter;
import com.archer.amaterasu.utils.ItemOffsetDecoration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotSongsFragment extends BaseFragment implements HotSongsViewModel {

    // Constants
    private static final int NUM_COLS = 2;
    private static final String IMAGE_URL = "IMAGE";
    private final String LOG_TAG = HotSongsFragment.this.getClass().getSimpleName();

    // References
    private HotSongAdapter adapter;


    // Binded views with butterknife
    @BindView(R.id.top_songs_recycler_list)
    RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new HotSongAdapter(CONTEXT, new HotSongAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Song item) {
                Intent intent = new Intent(CONTEXT, SongDetailActivity.class);
                intent.putExtra(IMAGE_URL, item.getImages().get(1));

                startActivity(intent);
            }
        });
    }



    /**
     * Overrided methods from HotSongsViewModel
     */
    @Override
    public void setupList() {
        recyclerView.setLayoutManager(new GridLayoutManager(CONTEXT, NUM_COLS));
        recyclerView.setAdapter(adapter);
//        recyclerView.addItemDecoration(new ItemOffsetDecoration(CONTEXT, R.integer.hot_song_card_offset));
    }

    @Override
    public void setupAdapter(List<Song> songs) {
        Log.e(LOG_TAG, songs.toString());
        adapter.clear();
        adapter.addAll(songs);
    }

    @Override
    public void onFailSearch(String error) {
        Log.e(LOG_TAG, error);
    }

    /**
     * Overrided methods from BaseFragment
     */
    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_hot_songs;
    }

    @Override
    public BasePresenter getPresenter() {
        return new HotSongPresenter(this);
    }
}

































