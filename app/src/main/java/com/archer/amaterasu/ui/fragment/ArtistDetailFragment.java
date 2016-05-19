package com.archer.amaterasu.ui.fragment;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.archer.amaterasu.R;
import com.archer.amaterasu.common.BasePresenter;
import com.archer.amaterasu.domain.Artist;
import com.archer.amaterasu.utils.SetupTabsLayout;
import com.facebook.drawee.view.SimpleDraweeView;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArtistDetailFragment extends SetupTabsLayout {

    @Bind(R.id.viewPager)
    ViewPager viewPager;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.artist_name)
    TextView artistName;
    @Bind(R.id.artist_image)
    SimpleDraweeView artistImage;
    @Bind(R.id.artist_rank)
    TextView artistRanking;

    Fragment[] tabsFragments = {
            new ArtistPersonalInformationFragment(),
            new ArtistSongsListFragment()
    };

    String[] tabsTitles = {
            "Personal Information",
            "List Songs"
    };


    public ArtistDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(view);
        configArtist();
        setupViewPager(viewPager, tabLayout, tabsFragments, tabsTitles);
        tabLayout.setTabTextColors(R.color.primaryText, R.color.primaryText);
    }

    public void configArtist(){
        Artist artist = Parcels.unwrap(getActivity().getIntent().getParcelableExtra("ARTIST"));
        setArtistImage(artist.getPhoto());
        setArtistName(artist.getName());
        setArtistRanking(artist.getRating());
    }

    public void setArtistName(String name){
        artistName.setText(name);
    }

    public void setArtistImage(String urlImage){
        Uri uri = Uri.parse(urlImage);
        artistImage.setImageURI(uri);
    }

    public void setArtistRanking(float ranking){
        artistRanking.setText("Ranking: " + ranking);
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_artist_detail;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

}

















