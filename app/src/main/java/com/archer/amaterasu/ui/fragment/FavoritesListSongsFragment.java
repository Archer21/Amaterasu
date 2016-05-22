package com.archer.amaterasu.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.archer.amaterasu.R;
import com.archer.amaterasu.common.BaseFragment;
import com.archer.amaterasu.common.BasePresenter;
import com.archer.amaterasu.domain.ListSong;
import com.archer.amaterasu.domain.Song;
import com.archer.amaterasu.ui.adapter.FavoritesSongListAdapter;
import com.archer.amaterasu.utils.ItemOffsetDecoration;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesListSongsFragment extends BaseFragment {

    RecyclerView recyclerList;

    private FavoritesSongListAdapter adapter;

    public FavoritesListSongsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new FavoritesSongListAdapter(CONTEXT);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerList = (RecyclerView) view.findViewById(R.id.recycler_favorites_songs);
        if (savedInstanceState == null){
            setupListConfiguration();
//            setDummieContent();
        }
    }

    private void setupListConfiguration(){
        recyclerList.setLayoutManager(new LinearLayoutManager(CONTEXT, LinearLayoutManager.HORIZONTAL, false));
        recyclerList.setAdapter(adapter);
        recyclerList.addItemDecoration(new ItemOffsetDecoration(CONTEXT, R.integer.offset));
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_favorites_list_songs;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    public void setDummieContent(){
        ArrayList<ListSong> dummieList = new ArrayList<>();
        ArrayList<Song> dummieSongsOne = new ArrayList<>();
        ArrayList<Song> dummieSongsTwo = new ArrayList<>();
        ArrayList<Song> dummieSongsThree = new ArrayList<>();
        ArrayList<Song> dummieSongsFour = new ArrayList<>();

        ListSong listOne = new ListSong();
        ListSong listTwo = new ListSong();
        ListSong listThree = new ListSong();
        ListSong listFour = new ListSong();

        Song wolf = new Song();
        wolf.setSongImageSmall("http://t02.deviantart.net/RdkCoVAytgSJkBe3zKhaTBxZJ_s=/300x200/filters:fixed_height(100,100):origin()/pre14/0ca6/th/pre/f/2009/329/5/7/spice_and_wolf_by_chvampaiiaxinuzuka.jpg");
        Song sao = new Song();
        sao.setSongImageSmall("https://v.cdn.vine.co/r/avatars/D5311B62C71188549169414316032_32d784aa0ae.1.5.jpg?versionId=SRP81.GMiY1UBZ3zemFhTG_2FB.3wxp5");
        Song fate = new Song();
        fate.setSongImageSmall("http://img1.ak.crunchyroll.com/i/spire2/54014d917b61c6f9610ba1ac885f58641411919139_large.png");

        dummieSongsOne.add(wolf);
        dummieSongsOne.add(sao);
        dummieSongsOne.add(fate);

        dummieSongsTwo.add(sao);
        dummieSongsTwo.add(wolf);
        dummieSongsTwo.add(fate);

        dummieSongsThree.add(fate);
        dummieSongsThree.add(wolf);
        dummieSongsThree.add(sao);

        dummieSongsFour.add(wolf);
        dummieSongsFour.add(fate);
        dummieSongsFour.add(sao);

        listOne.setName("Best Anime Openings");
        listOne.setSongs(dummieSongsOne);

        listTwo.setName("Best off Eai Aoi");
        listTwo.setSongs(dummieSongsTwo);

        listThree.setName("Epic fight music");
        listThree.setSongs(dummieSongsThree);

        listFour.setName("Twitch stream music");
        listFour.setSongs(dummieSongsFour);

        dummieList.add(listOne);
        dummieList.add(listTwo);
        dummieList.add(listThree);
        dummieList.add(listFour);

        dummieList.add(listTwo);
        dummieList.add(listOne);
        dummieList.add(listFour);
        dummieList.add(listThree);

        dummieList.add(listOne);
        dummieList.add(listTwo);

        adapter.addAll(dummieList);
    }
}


















