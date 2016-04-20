package com.archer.amaterasu.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.archer.amaterasu.R;
import com.archer.amaterasu.common.BaseFragment;
import com.archer.amaterasu.domain.Song;
import com.archer.amaterasu.ui.adapter.TopSongsAdapter;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopSongsFragment extends BaseFragment {

    private static final int NUM_COLS = 2;
    private TopSongsAdapter topSongsAdapter;

    @Bind(R.id.recycler_list_container)
    RecyclerView recyclerList;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupListConfiguration();
    }

    private void setupListConfiguration(){
        topSongsAdapter = new TopSongsAdapter(CONTEXT);
        recyclerList.setLayoutManager(new GridLayoutManager(getActivity(), NUM_COLS));
        recyclerList.setAdapter(topSongsAdapter);
        setDummieContent();
    }

    private void setDummieContent(){
        ArrayList<Song> songs = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            Song ignite = new Song();
            ignite.setSongImage("http://www.generasia.com/w/images/thumb/c/cf/Eir_Aoi_-_Ignite_(Regular_Edition_CD_Only).jpg/300px-Eir_Aoi_-_Ignite_(Regular_Edition_CD_Only).jpg");
            ignite.setSongName("Ignite");
            ignite.setSongRating(1.5f);
            ignite.setSongPlaycount(4356);
            ignite.setSongListeners(120125);
            songs.add(ignite);
        }
        topSongsAdapter.addAll(songs);
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_top_songs;
    }
}
















