package com.archer.amaterasu.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.archer.amaterasu.R;
import com.archer.amaterasu.common.BaseFragment;
import com.archer.amaterasu.domain.Song;
import com.archer.amaterasu.ui.adapter.HotSongAdapter;
import com.archer.amaterasu.utils.ItemOffsetDecoration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotSongsFragment extends BaseFragment {

    // Constants
    private static final int NUM_COLS = 2;

    // References
    private HotSongAdapter adapter;

    // Binded views with butterknife
    @BindView(R.id.top_songs_recycler_list)
    RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new HotSongAdapter(CONTEXT);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupList();
        setDummieContent();
    }

    /**
     * Methods for HotSongFragment
     */

    public void setupList () {
        GridLayoutManager layoutManager = new GridLayoutManager(CONTEXT, NUM_COLS);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new ItemOffsetDecoration(CONTEXT, R.integer.hot_song_card_offset));
    }


    private void setDummieContent(){
        List<Song> songs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Song song = new Song();
            HashMap<Integer, String> images = new HashMap<>();
            images.put(0, "https://lh3.googleusercontent.com/-QKucqaMK-30/AAAAAAAAAAI/AAAAAAAAIo4/f6idNlRAyc0/s0-c-k-no-ns/photo.jpg");
            images.put(1, "https://lh3.googleusercontent.com/-QKucqaMK-30/AAAAAAAAAAI/AAAAAAAAIo4/f6idNlRAyc0/s0-c-k-no-ns/photo.jpg");
            song.setImages(images);
            song.setTitle("Ignite");
            song.setArtist("Sawano Hirayuki");
            song.setLikes(4356);
            song.setDuration("3:40");
            songs.add(song);
        }
        adapter.addAll(songs);
    }


        /**
         * Overrided methods from BaseFragment
         */

    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_hot_songs;
    }
}

































