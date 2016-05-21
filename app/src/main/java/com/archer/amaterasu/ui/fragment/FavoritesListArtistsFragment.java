package com.archer.amaterasu.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.archer.amaterasu.R;
import com.archer.amaterasu.common.BaseFragment;
import com.archer.amaterasu.common.BasePresenter;
import com.archer.amaterasu.domain.Artist;
import com.archer.amaterasu.ui.adapter.FavoriteArtistListAdapter;
import com.archer.amaterasu.utils.ItemOffsetDecoration;

import java.util.ArrayList;

import butterknife.Bind;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesListArtistsFragment extends BaseFragment {

    private static final String LOG_TAG = FavoritesListArtistsFragment.class.getSimpleName();
    @Bind(R.id.favorites_artists_recycler_list)
    RecyclerView recyclerList;

    FavoriteArtistListAdapter adapter;
//    Realm realm;

    public FavoritesListArtistsFragment() {
        // Required empty public constructor
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        realm = Realm.getDefaultInstance();
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        realm.close();
//    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new FavoriteArtistListAdapter(CONTEXT);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState == null){
            setupListConfiguration();
//            setDummieContent();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        RealmResults<Artist> results = getRealm().where(Artist.class).findAll();
        adapter.addAll(results);
        Log.e(LOG_TAG, results + "\n");
    }

    private void setupListConfiguration(){
        recyclerList.setLayoutManager(new LinearLayoutManager(CONTEXT, LinearLayoutManager.HORIZONTAL, false));
        recyclerList.setAdapter(adapter);
        recyclerList.addItemDecoration(new ItemOffsetDecoration(CONTEXT, R.integer.offset));
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_favorites_list_artists;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    public void setDummieContent(){
        ArrayList<Artist> artists= new ArrayList<>();

        Artist eairAoi = new Artist();
        eairAoi.setPhoto("http://www.sony-asia.com/microsite/hiresaudio/img/artists/thumb_eir_aoi.jpg");

        Artist boa = new Artist();
        boa.setPhoto("http://images4.fanpop.com/image/photos/21000000/BoA-Kwon-boa-21069379-200-200.png");

        Artist tommyHeavenly = new Artist();
        tommyHeavenly.setPhoto("http://s3.evcdn.com/images/block200/I0-001/002/118/126-6.jpeg_/tommy-heavenly6-26.jpeg");

        artists.add(eairAoi);
        artists.add(boa);
        artists.add(tommyHeavenly);

        artists.add(boa);
        artists.add(tommyHeavenly);
        artists.add(eairAoi);

        artists.add(eairAoi);
        artists.add(tommyHeavenly);
        artists.add(boa);

        artists.add(eairAoi);


        adapter.addAll(artists);
    }
}

































